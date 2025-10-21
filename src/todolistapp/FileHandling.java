/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistapp;

import ModelClasses.Task;
import ModelClasses.TaskList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 *
 * @author Kavindu
 */
public class FileHandling {
    File f = new File("ToDoApp");
    
    public void creteFolder(){
        if (!f.exists()) {
            if (f.mkdir()) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Failed to create folder.");
            }
        }else{
            System.out.println("Folder already exists.");
        }
    }
    
    public void createTxtFile(){
        try {
            FileReader fr = new FileReader(f+"\\Tasks.txt");
            System.out.println("file exists");
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\Tasks.txt");
                System.out.println("file created");
                fw.close();
            } catch (IOException ex1) {
                System.out.println(ex);
            }
        }
    }
    
    public int countLines(){
        int ln = 0;
        try {
            try (RandomAccessFile raf = new RandomAccessFile(f + "\\tasks.txt", "rw")) {
                for (int i = 0; raf.readLine() != null; i++) {
                    ln++;           
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return ln;
    }
   
    public TaskList getAllTaskList(){
        TaskList tskList = new TaskList();
        try {  
            try (RandomAccessFile raf = new RandomAccessFile(f + "\\tasks.txt", "rw")) {
                for(int i=1 ; i < countLines() ; i=i+6){
                    String readId = raf.readLine().substring(7);
                    String readTitle = raf.readLine().substring(6);
                    String readDescrip = raf.readLine().substring(12);
                    String readDueDate = raf.readLine().substring(8);
                    String readStatus = raf.readLine().substring(12);
                    //converting to correct types
                    //convert string to int
                    int id = Integer.parseInt(readId);
                    //convert string to Loacaldate
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate localDate = LocalDate.parse(readDueDate, formatter);
                    //convert status to boolean
                    boolean isCompleted;
                    if(readStatus.equals("Not Completed")){
                        isCompleted = false;
                    }else{
                        isCompleted = true;
                    }
                    //create task object with parameters
                    Task t = new Task(id, readTitle, readDescrip, localDate, isCompleted);
                    //add to list
                    tskList.addTask(t);
                    raf.readLine();  //this for skip space line in tst file
                }
                raf.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        return tskList;
    }
    
    public void overWriteFile(LinkedList<Task> tskList){
        try {
            try (RandomAccessFile raf = new RandomAccessFile(f+"\\tasks.txt", "rw")) {
                raf.setLength(0);
                for(Task task : tskList){
                    raf.writeBytes("TaskID:" + task.getId() + "\r\n");
                    raf.writeBytes("Title:" + task.getTitle() + "\r\n");
                    raf.writeBytes("Description:" + task.getDescription() + "\r\n");
                    raf.writeBytes("dueDate:" + task.getDueDate() + "\r\n");
                    String taskStatus;
                    if (task.isIsCompleted()) {
                        taskStatus = "Completed";
                    } else {
                        taskStatus = "Not Completed";
                    }
                    raf.writeBytes("isCompleted:" + taskStatus + "\r\n");
                    //put space
                    raf.writeBytes("\r\n");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
