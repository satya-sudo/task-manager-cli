import cli.CommandHandler;
import repository.TaskRepository;
import repository.UserRepository;
import service.TaskService;

public class Main {
    public static void main(String[] args) {
      TaskRepository taskRepo = new TaskRepository();
      UserRepository userRepo = new UserRepository();
      TaskService service =  new TaskService(taskRepo, userRepo);
      CommandHandler cli = new  CommandHandler(service);
      cli.start();
    }
}