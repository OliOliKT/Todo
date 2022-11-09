public class Task {

    private String taskDescription;
    private int priority;
    private int workload;

    public Task(String taskDescription, int priority, int workload) {
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.workload = workload;
    }

    public int getMinutes() {
        return workload;
    }

    public int getPriority() {
        return priority;
    }


    public String toString() {
        String priorityMessage = "";
        if (priority == 1) {
            priorityMessage = "very important";
        }
        if (priority == 2) {
            priorityMessage = "important";
        }
        if (priority == 3) {
            priorityMessage = "unimportant";
        }
        if (priority == 4) {
            priorityMessage = "after learn Portuguese";
        }
        return taskDescription + " takes " + workload + " minutes and has priority " + priorityMessage;
    }


}
