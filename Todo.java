import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Todo {

    private List<Task> TodoList;
    int totalMinutes = 0;

    public Todo() {
        TodoList = new ArrayList<>();
    }

    public void addTask(String description, int priority, int minutes) {
        if (priority < 1 || priority > 4) {
            System.out.println(description + " has invalid priority");
        }
        if (minutes < 0) {
            System.out.println(description + " has invalid workload");
        }
        else {
            TodoList.add(new Task(description, priority, minutes));
        }
    }

    public void print() {
        System.out.println("Todo:");
        System.out.println("-----");
        if (TodoList.isEmpty()) {
            System.out.println("You're all done for today! #TodoZero");
        }
        else {
            for (Task task : TodoList) {
                System.out.println(task.toString());
            }
        }
        if (totalMinutes > 0) {
            System.out.println(totalMinutes + " minutes of work done!");
        }
        
    }

    public void completeTask(int index) {
        try { 
            totalMinutes += TodoList.get(index).getMinutes();
            TodoList.remove(index);
        }
        catch(Exception e) {
            System.out.println("Invalid index");
        }
    }

    public void printPriority(int limit) {
        System.out.println("Filtered todo:");
        System.out.println("--------------");
        int counter = 0;
        for (Task task : TodoList) {
            if (task.getPriority() <= limit) {
                System.out.println(task);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No tasks with given priority");
        }
    }

    public void printPrioritized() {
        System.out.println("Prioritized todo:");
        System.out.println("-----------------");

        TodoList.stream()
        .sorted(Comparator.comparing(Task::getMinutes))
        .sorted(Comparator.comparing(Task::getPriority))
        .forEach(System.out::println);

    }
}
