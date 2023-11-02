import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class ThreadGame implements Runnable {
  private static final Logger logger = Logger.getLogger(ThreadGame.class.getSimpleName());
  private static final Object lock = new Object();
  private static final  Random random = new Random();
  
  private CopyOnWriteArrayList<Integer> array = new CopyOnWriteArrayList<>();
  private int points;
  private String name;
  
  public ThreadGame(String name) {
    this.name = name;
  }
  
  @Override
  public void run() {
    while (array.size() < 100) {
      int x = random.nextInt(1, 101);
      synchronized (lock) {
        if (!array.contains(x)) {
          array.add(x);
          points += 1;
        }
      }
      if (array.size() == 100) {
        logger.info("Winner`s name is " + name + " " +  points);
        return;
        }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    var t1 = new Thread(new ThreadGame("First"));
    var t2 = new Thread(new ThreadGame("Second"));
    t1.start();
    t2.start();
  }
}
