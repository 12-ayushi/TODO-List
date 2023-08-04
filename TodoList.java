import java.util.ArrayList;
import java.util.Scanner;

class TodoItem {
    private String task;
    private boolean completed;

    public TodoItem(String task) {
        this.task = task;
        this.completed = false;
    }

    public String getTask() {
        return task;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "[" + (completed ? "X" : " ") + "] " + task;
    }
}

public class TodoList {
    private ArrayList<TodoItem> tasks;
    private Scanner scanner;

    public TodoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String task) {
        tasks.add(new TodoItem(task));
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks in the list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 1 && index <= tasks.size()) {
            TodoItem item = tasks.get(index - 1);
            item.setCompleted(true);
            System.out.println("Task marked as completed: " + item.getTask());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void removeCompletedTasks() {
        tasks.removeIf(TodoItem::isCompleted);
        System.out.println("Completed tasks removed.");
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Todo List =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Completed Tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case 2:
                    todoList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int index = scanner.nextInt();
                    todoList.markTaskAsCompleted(index);
                    break;
                case 4:
                    todoList.removeCompletedTasks();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
