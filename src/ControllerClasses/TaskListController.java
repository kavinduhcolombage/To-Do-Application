/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerClasses;

import ModelClasses.Task;
import ModelClasses.TaskList;
import todolistapp.FileHandling;
import java.util.LinkedList;

/**
 *
 * @author Kavindu
 */
public class TaskListController {
    private TaskList tskList = new TaskList();
    private FileHandling fileHandObj = new FileHandling();

    public TaskList getTskList() {
        return tskList;
    }

    public void setTskList(TaskList tskList) {
        this.tskList = tskList;
    }  
    
    //check file availabilty. is file not exist then create file
    public void checkFile(){
        fileHandObj.creteFolder();
        fileHandObj.createTxtFile();
    }
   
    //load all tasks from txt file to tasklist. this important only when starting the program
    public void getAllTaskListFromFile(){
        tskList = fileHandObj.getAllTaskList();
    }
    
    public void updateFile(TaskList tskList){
        LinkedList<Task> tskLinkedList = new LinkedList<>();
        
        Task task = tskList.head;
        while (task != null) {            
            tskLinkedList.add(task);
            task = task.next;
        }      
        fileHandObj.overWriteFile(tskLinkedList);
    }
 
}
