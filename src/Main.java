import cli.CommandHandler;
import repository.TaskRepository;

public class Main {
    public static void main(String[] args) {
      TaskRepository repo = new TaskRepository();
      CommandHandler cli = new  CommandHandler(repo);
      cli.start();
    }
}