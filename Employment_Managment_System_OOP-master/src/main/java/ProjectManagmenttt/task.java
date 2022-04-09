/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagmenttt;

import java.util.ArrayList;

public class task {
    
    private String name;
    private date deadline;
    
    public ArrayList<teamMember> assignedUsers=new ArrayList<teamMember>();
    
    private final int taskID;
    private static int taskCounter=1;
    
    public static ArrayList<task> tasks=new ArrayList<task>();
            
    public enum status
    {
        toDo,
        onGoing,
        done  
    }
    
    public status currentStatus;
    
    public task(String name, date deadline) {
        this.name = name;
        this.deadline = deadline;
        
       currentStatus= status.toDo;
        
        taskID=taskCounter;
        taskCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public date getDeadline() {
        return deadline;
    }
     
    public void setDeadline(date deadline) {
        this.deadline = deadline;
    }
    
    public int getTaskID() {
        return taskID;
    }
    
    public status getCurrentStatus() {
        return currentStatus;
    }
}
