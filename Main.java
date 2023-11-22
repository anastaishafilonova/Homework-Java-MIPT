import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    FilterOfFile filterOfFile = new FilterOfFile();
    Scanner input = new Scanner(System.in);
    System.out.print("Введите путь исходного файла: ");
    String nameOfStartFile = input.nextLine();
    System.out.print("Введите путь файла, содержащего слова для фильтрации: ");
    String nameOfFilterFile = input.nextLine();
    System.out.print("Введите путь файла, в который нужно записать результат: ");
    String nameOfResultFile = input.nextLine();
    try {
      filterOfFile.filter(nameOfStartFile, nameOfFilterFile, nameOfResultFile);
    } catch (IOException e) {
      throw new IOException("Files are not found :(", e);
    }
  }
}
// C:\Users\79058\IdeaProjects\IOStreamHomeworkMIPT\src\TestingFiles\startFile
// C:\Users\79058\IdeaProjects\IOStreamHomeworkMIPT\src\TestingFiles\filterFile
// C:\Users\79058\IdeaProjects\IOStreamHomeworkMIPT\src\TestingFiles\resultFile