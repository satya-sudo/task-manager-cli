import model.Task;
import model.User;
import repository.TaskRepository;

public class Main {
    public static void main(String[] args) {
      TaskRepository repo = new TaskRepository();
      User u = new User("Satyam");
      Task t = new Task("Learn java for liscous");
      Task t1 =  new Task("Some thing new");

      t.assignedUser(u);
      repo.save(t1);
      repo.save(t);
      System.out.println(repo.List());

      repo.delete(t1.getId());
      System.out.println(repo.List());
    }
}