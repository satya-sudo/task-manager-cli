import cli.CommandHandler;
import repository.TaskRepository;
import service.TaskService;

public class Main {
    public static void main(String[] args) {
      TaskRepository repo = new TaskRepository();
      TaskService service =  new TaskService(repo);
      CommandHandler cli = new  CommandHandler(service);
      cli.start();
    }
}