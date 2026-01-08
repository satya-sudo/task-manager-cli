import model.Task;
import model.User;

public class Main {
    public static void main(String[] args) {
      User u = new User("Satyam");
      Task t = new Task("Learn java for liscous");

      t.assignedUser(u);

      System.out.println(t);
    }
}