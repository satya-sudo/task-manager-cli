package cli;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import model.Task;
import model.TaskStatus;
import model.User;
import service.TaskService;

public class CommandHandler {
    private final TaskService service;
    private final Scanner scanner = new Scanner(System.in);

    public CommandHandler(TaskService service) {
        this.service = service;
    }

    public void start() {
        while(true) {
            printMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> createTask();
                case 2 -> listTasks();
                case 3 -> deleteTask();
                case 4 -> updateTaskStatus();
                case 5 -> createUser();
                case 6 -> assignUser();
                case 7 -> listTasksByStatus();
                case 8 -> exit();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void printMenu() {
        System.out.println("\n=== TASK MANAGER ===");
        System.out.println("1. Create Task");
        System.out.println("2. List All Tasks");
        System.out.println("3. Delete Task");
        System.out.println("4. Update Task Status");
        System.out.println("5. Create User");
        System.out.println("6. Assign User to Task");
        System.out.println("7. List Tasks By Status");
        System.out.println("8. Exit");
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
        Task task = service.createTask(title);
        System.out.println("Task Created" + task.toString());
    }

    private void listTasks() {
        if (service.getAllTasks().isEmpty()) {
            System.out.println("No tasks present");
            return;
        }
        List tasks = service.getAllTasks();
        tasks.forEach(System.out::println);
    }
    private void  deleteTask() {
        System.out.println("Enter task ID: ");
        String idStr = scanner.nextLine();

        try {
            UUID id = UUID.fromString(idStr);
            service.deleteTask(id);
            System.out.println("Task Deleted!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Id");
        }
    }
    private  void createUser() {
        System.out.println("Enter User's name:");
        String name = scanner.nextLine();
        User user = service.createUser(name);
        System.out.println("User created:" + user);
    }
    private void assignUser() {
        try {
            System.out.print("Enter task ID: ");
            UUID taskId = UUID.fromString(scanner.nextLine());
            System.out.print("Enter user ID: ");
            UUID userId = UUID.fromString(scanner.nextLine());
            User user = service.getUser(userId);
            service.assignUser(taskId, user);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid UUID format.");
        }
    }
    private void updateTaskStatus() {
        try {
            System.out.print("Enter task ID: ");
            UUID taskId = UUID.fromString(scanner.nextLine());
            printStatusList();
            int choice = readInt();
            TaskStatus newStatus = TaskStatus.values()[choice];

            service.updateStatus(taskId, newStatus);
            System.out.println("Task status updated.");

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input.");
        }
    }
    private void listTasksByStatus() {
        printStatusList();

        try {
            int choice = readInt();
            TaskStatus status = TaskStatus.values()[choice];

            List<Task> tasks = service.getTasksByStatus(status);

            if (tasks.isEmpty()) {
                System.out.println("No tasks with status " + status);
                return;
            }

            tasks.forEach(System.out::println);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid status choice.");
        }
    }
    private void printStatusList() {
         System.out.println("Choose new status:");
        for (TaskStatus status : TaskStatus.values()) {
            System.out.println(status.ordinal() + " - " + status);
        }
    }
    private void exit() {
        System.out.println("Bye");
        System.exit(0);
    }
}