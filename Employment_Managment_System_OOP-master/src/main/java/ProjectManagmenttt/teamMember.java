/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagmenttt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class teamMember {
    
    private String username;
    private String password;
    
    private final int memberID;
    private static int memberCounter = 1;
    
    public team currentTeam;
    
    public ArrayList<task>listOfTasks=new ArrayList<task>();
    public int numberOfTasks=0;
    
    public static ArrayList<teamMember> members=new ArrayList<teamMember>();
    
    static Scanner userInput = new Scanner (System.in);

    public teamMember(String username, String password) 
    {
        this.username = username;
        this.password = password;
        memberID = memberCounter;
        memberCounter++;
    }
    
    public static void browseTask() 
    {
        if (login.currentUser.currentTeam==null)
        {
            System.out.println("No current team exists, please wait until a leader adds you to a team and try again.\n");
        }
        else
        {
        System.out.println("1-All Tasks\n2-Your Tasks\n3-Search a task by name");
        int x=userInput.nextInt();
        
        switch (x) 
        {
            case 1:
                if(login.currentUser.currentTeam==null)
                {
                   System.out.println("You are not assigned to team, please try again after beign assigned to a team.\n"); 
                }
                else if (login.currentUser.currentTeam.teamTasks.size()==0)
                {
                    System.out.println("No team tasks to display.\n");
                }
                else
                {
                    for (int i = 0; i < login.currentUser.currentTeam.teamTasks.size(); i++)
                    {
                        date endDate;
                        endDate=login.currentUser.currentTeam.teamTasks.get(i).getDeadline();
                        
                        System.out.println("----------------------------------------");
                        System.out.println("Task ID : "+login.currentUser.currentTeam.teamTasks.get(i).getTaskID());
                        System.out.println("Task Name : "+login.currentUser.currentTeam.teamTasks.get(i).getName());
                        System.out.println("Task Deadline : "+endDate.getDay()+"/"+endDate.getMonth()+"/"+endDate.getYear());
                        System.out.println("Assigned team members:");
                        
                        for(int j=0;j<login.currentUser.currentTeam.teamTasks.get(i).assignedUsers.size();j++)
                        {
                        System.out.println("Assigned member name: " + login.currentUser.currentTeam.teamTasks.get(i).assignedUsers.get(j).getUsername());
                        System.out.println("Assigned member ID: " + login.currentUser.currentTeam.teamTasks.get(i).assignedUsers.get(j).getMemberID());
                        } 
                        System.out.println("----------------------------------------");
                    }
                } break;
            case 2:
                for (int i = 0; i < login.currentUser.listOfTasks.size(); i++) 
                {
                    date endDate;
                    endDate=login.currentUser.listOfTasks.get(i).getDeadline();
                    
                    System.out.println("----------------------------------------");
                    System.out.println("Task ID : "+login.currentUser.listOfTasks.get(i).getTaskID());
                    System.out.println("Task Name : "+login.currentUser.listOfTasks.get(i).getName());
                    System.out.println("Task Deadline : "+endDate.getDay()+"/"+endDate.getMonth()+"/"+endDate.getYear());
                    System.out.println("Assigned team members:");
                    
                    for(int j=0;j<login.currentUser.listOfTasks.get(i).assignedUsers.size();j++)
                    {
                        System.out.println("Assigned member name: " + login.currentUser.listOfTasks.get(i).assignedUsers.get(j).getUsername());
                        System.out.println("Assigned member ID: " + login.currentUser.listOfTasks.get(i).assignedUsers.get(j).getMemberID());
                    } 
                    System.out.println("----------------------------------------");
                } break;
            case 3:
            System.out.println("Enter The Task's name");
            String z =userInput.next();
            boolean found = false;
            for (int i = 0; i < login.currentLeader.currentTeam.teamTasks.size(); i++)
                    {
                        if(z.toLowerCase().equals(login.currentLeader.currentTeam.teamTasks.get(i).getName().toLowerCase()))
                        {
                         found =true;
                        date endDate;
                        endDate=login.currentLeader.currentTeam.teamTasks.get(i).getDeadline();
                        
                        System.out.println("----------------------------------------");
                        System.out.println("Task ID : "+login.currentLeader.currentTeam.teamTasks.get(i).getTaskID());
                        System.out.println("Task Name : "+login.currentLeader.currentTeam.teamTasks.get(i).getName());
                        System.out.println("Task Deadline : "+endDate.getDay()+"/"+endDate.getMonth()+"/"+endDate.getYear());
                        System.out.println("Assigned team members:");
                        
                        for(int j=0;j<login.currentLeader.currentTeam.teamTasks.get(i).assignedUsers.size();j++)
                        {
                        System.out.println("Assigned member name: " + login.currentLeader.currentTeam.teamTasks.get(i).assignedUsers.get(j).getUsername());
                        System.out.println("Assigned member ID: " + login.currentLeader.currentTeam.teamTasks.get(i).assignedUsers.get(j).getMemberID());
                        }
                        System.out.println("----------------------------------------");
                        }
                    } 
            if (found==false)
            {
               System.out.println("Couldn't find a task with this name please check you are typing the name correctly and try again."); 
            } break;
            default:
                System.out.println("Input not valid, please try again.");
                break;
        

   
                
    }
        }
        home.home(false);
    }
    
    
    public static void editTask () {
        
        if (login.currentUser.currentTeam==null)
        {
            System.out.println("You are not assigned to team, please try again after beign assigned to a team.\n");
        }
        
        else
        {
        System.out.println("Please choose which task you wish to change its status by writing its ID");
        int x=userInput.nextInt();
        
        boolean found = false;
        
        for (int i = 0; i < login.currentUser.listOfTasks.size(); i++) 
        {
            
            if(x==login.currentUser.listOfTasks.get(i).getTaskID())
            {
                found=true;
                if (login.currentUser.listOfTasks.get(i).getCurrentStatus()==task.status.toDo)
                {
                    System.out.println("Task current status: To Do");
                }
                else if (login.currentUser.listOfTasks.get(i).getCurrentStatus()==task.status.onGoing)
                {
                    System.out.println("Task current status: Ongoing");
                }
                else
                {
                    System.out.println("Task current status: Done");
                }
                
                System.out.println("Choose what would you like to change the current status to by writing its number");
                System.out.println("1-To Do");
                System.out.println("2-Ongoing");
                System.out.println("3-Done");
                x=userInput.nextInt();
                
                switch (x) 
                {
                    case 1:
                        login.currentUser.listOfTasks.get(i).currentStatus=task.status.toDo;
                        break;
                    case 2:
                        login.currentUser.listOfTasks.get(i).currentStatus=task.status.onGoing;
                        break;
                    case 3:
                        login.currentUser.listOfTasks.get(i).currentStatus=task.status.done;
                        break;
                    default:
                        System.out.println("input not valid, please try again");
                        break;
                }
               
            }
        }
        if (found==false)
        {
            System.out.println("Task ID not found or User not assigned to this task, please try again.");
        }
        else
        {
            System.out.println("Task's status edited.\n"); 
        }
        
    }
        home.home(false);
    }

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

     public void setPassword(String password) {
        this.password = password;
    } 
    
    public String getPassword() {
        return password;
    }
  

    public int getMemberID() {
        return memberID;
    }
}
