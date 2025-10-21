/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClasses;

/**
 *
 * @author Kavindu
 */
public class TaskList {
    public Task head;
    
    public TaskList(){
        head = null;
    }
    
    public void addTask(Task task){
        if (head == null) {
            head = task;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = task;
        }
    }
    
    public Task findTask(int id){
        Task current = head;
        while (current != null) {            
            if(id == current.getId()){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public Task deleteTask(int id) {
        Task searchedTask = findTask(id);
        if (searchedTask != null) {
            Task current = head;
            Task previous = null;
            while (current != null) {
                if (current.getId() == id) {
                    if (current == head) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return current; // Return the deleted node
                }
                previous = current;
                current = current.next;
            }
            return null; // Return null if the item was not found 
        } else {
            return null; // Return null if the item was not found
        }

    }
    
    public void sortById() {
        if (head == null || head.next == null) {
            // The list is already sorted or empty.
            return;
        }

        Task sorted = null; // Initialize the sorted sublist
        Task current = head; // Initialize the current Task to be sorted

        while (current != null) {
            Task next = current.next; // Store the next Task before we detach it

            if (sorted == null || current.getId() < sorted.getId()) {
                // Insert current Task into the sorted sublist
                current.next = sorted;
                sorted = current;
            } else {
                // Find the correct position for the current Task in the sorted sublist
                Task temp = sorted;
                while (temp.next != null && current.getId() > temp.next.getId()) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next; // Move to the next Task in the original list
        }

        head = sorted; // Update the head to the sorted sublist
    }
    
    public void sortByDate() {
        if (head == null || head.next == null) {
            // The list is already sorted or empty.
            return;
        }

        Task sorted = null; // Initialize the sorted sublist
        Task current = head; // Initialize the current Task to be sorted

        while (current != null) {
            Task next = current.next; // Store the next Task before we detach it
            
            if (sorted == null || current.getDueDate().isBefore(sorted.getDueDate())) {
                // Insert current Task into the sorted sublist
                current.next = sorted;
                sorted = current;
            } else {
                // Find the correct position for the current Task in the sorted sublist
                Task temp = sorted;
                while (temp.next != null && current.getDueDate().isAfter(temp.next.getDueDate())) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next; // Move to the next Task in the original list
        }

        head = sorted; // Update the head to the sorted sublist
    }
    
    public int getLastTaskId() {
        if (head == null) {
            throw new IllegalStateException("The list is empty");
        }

        Task current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.getId();
    }
    
    public void markCompleteTask(int id){
        Task searchedTask = findTask(id);
        if(searchedTask != null){
            searchedTask.setIsCompleted(true);
        }
    }
    
    public TaskList getCompletedTaskList(){
        TaskList completedTasks = new TaskList();
        Task current = head;
        while (current != null) {            
            if(current.isIsCompleted()){
                Task t = new Task(current.getId(), current.getTitle(), current.getDescription(), current.getDueDate() ,current.isIsCompleted());
                completedTasks.addTask(t);
            }
            current = current.next;
        }      
        return completedTasks;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 /*   
    
    
    
    
    
    
    private LinkedList<Task> taskList;

    public TaskList() {
        taskList = new LinkedList<>();
    }

    public LinkedList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(LinkedList<Task> taskList) {
        this.taskList = taskList;
    }
    
    public void addTask(Task task){
        taskList.add(task);
    }
     
    public void sortTasksByDueDate(){   //sort by due date using insertion sort
        for(int i = 1 ; i < taskList.size() ; i++){
            Task markedTask = taskList.get(i);
            LocalDate markedTaskDate = markedTask.getDueDate();
            int j = i-1;
            while(j>=0 && markedTaskDate.compareTo(taskList.get(j).getDueDate()) < 0){
                taskList.set(j+1, taskList.get(j));
                j--;
            }  
            taskList.set(j+1, markedTask);
        }
    }
    
    public void sortTasksById(){
        for(int i = 1 ; i < taskList.size() ; i++){
            Task markedTask = taskList.get(i);
            int markedTaskId = markedTask.getId();
            int j = i-1;
            while(j>=0 && markedTaskId < taskList.get(j).getId()){
                taskList.set(j+1, taskList.get(j));
                j--;
            }  
            taskList.set(j+1, markedTask);
        }
    }
    
    public Task removeTask(int id){
        Task taskToRemove = null;
        for(Task t : taskList){
            if(t.getId() == id){
                taskToRemove = t;
                break;
            }
        }
        
        if(taskToRemove != null){
            taskList.remove(taskToRemove);
            return taskToRemove;
        }else{
            return null;
        }
    }
    
    public void getCompletedTask(){
        LinkedList<Task> completeTAsks = new LinkedList<>();
        for(Task t : taskList){
            if(t.isIsCompleted()){
                completeTAsks.add(t);
            }
        }
        setTaskList(completeTAsks);
    }
    
    public void markTaskComplete(int id){
        Task findTask = find(id);
        if(findTask != null){
            findTask.setIsCompleted(true);
        }
    }
    
    public Task find(int id){
        for(Task t : taskList){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    
 */   
    
}
