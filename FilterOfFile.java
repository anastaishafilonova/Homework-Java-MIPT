import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FilterOfFile {
  private static final Logger logger = Logger.getLogger(FilterOfFile.class.getSimpleName());
  static ArrayList<String> filterWords = new ArrayList<>();
  static ArrayList<String> linesFromStartFile = new ArrayList<>();

  public void filter(String nameOfStartFile, String nameOfFilterFile, String nameOfResultFile) throws IOException {

    var startFile = new BufferedReader(new FileReader(nameOfStartFile));
    var filterFile = new BufferedReader(new FileReader(nameOfFilterFile));
    var resultFile = new FileWriter(nameOfResultFile);

    String line;

    try {
      while ((line = filterFile.readLine()) != null) {
        filterWords.add(line);
        logger.info("Read from buffered filterFile: " + line);
      }
    } catch (IOException e) {
      throw new IOException("Filter file is not found :(", e);
    } finally {
      filterFile.close();
    }

    try {
      while ((line = startFile.readLine()) != null) {
        linesFromStartFile.add(line);
        logger.info("Read from buffered startFile: " + line);
      }
    } catch (IOException e) {
      throw new IOException("Start file is not found :(", e);
    } finally {
      startFile.close();
    }

    List<String> resultLines = linesFromStartFile.stream()
        .filter(this::LineNotContainsOneOfFilterWords)
        .toList();

    for (String resultLine : resultLines) {
      resultFile.write(resultLine + "\n");
    }

    resultFile.close();
  }

  public boolean LineNotContainsOneOfFilterWords(String line) {
    boolean flag = true;
    for (String filterWord : filterWords) {
      if (line.contains(filterWord)) {
        flag = false;
        break;
      }
    }
    return flag;
  }
}
