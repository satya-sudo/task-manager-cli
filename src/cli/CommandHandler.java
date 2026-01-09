package cli;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import model.Task;
import repository.TaskRepository;

public class CommandHandler {
    private final TaskRepository repository;
    private final Scanner scanner = new Scanner(System.in);

    public CommandHandler(TaskRepository repository) {
        this.repository = repository;
    }

    public void start() {
        while(true) {
            printMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> createTask();
                case 2 -> listTask();
                case 3 -> deleteTask();
                case 4 -> exit();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void printMenu() {
        System.out.println("\n=== TASK MANAGER ===");
        System.out.println("1. Create Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Delete Task");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a Choice:");
            scanner.next();
        }
        int value =  scanner.nextInt();
        scanner.nextLine();
        return value;
    }
    private void createTask() {
        System.out.println("Enter Title:");
        String title = scanner.nextLine();  
        Task task = new Task(title);
        repository.save(task);
        System.out.println("Task Created" + task.toString());
    }

    private void listTask() {
        if (repository.List().isEmpty()) {
            System.out.println("No tasks present");
            return;
        }
        List tasks = repository.List();
        tasks.forEach(System.out::println);
    }
    private void  deleteTask() {
        System.out.println("Enter task ID: ");
        String idStr = scanner.nextLine();

        try {
            UUID id = UUID.fromString(idStr);
            repository.delete(id);
            System.out.println("Task Deleted!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Id");
        }
    }

    private void exit() {
        System.out.println("Bye");
        System.exit(0);
    }
}