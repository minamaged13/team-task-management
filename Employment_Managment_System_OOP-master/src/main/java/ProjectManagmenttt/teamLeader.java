/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagmenttt;

/**
 *
 * @author Tarek
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class teamLeader extends teamMember{
    
    static Scanner userInput = new Scanner(System.in);
    
    static ArrayList<teamLeader> leaders=new ArrayList<teamLeader>();
    
    team currentTeam;
    
    public teamLeader(String u , String p)
    {
        super (u,p);
    }
    
    public static void createTeam()
    {
       System.out.println("Please enter team name: ");
       String teamName= userInput.next();
       
       team newTeam=new team(teamName);
       
       //team added to teams array
       team.teams.add(newTeam);
       
       //team assigned to leader
       login.currentLeader.currentTeam=newTeam;
       
       System.out.println("Team created.\n ");
       home.home(true);
       
    }
    public static void assignMemberToTeam()
    {
        if (login.currentLeader.currentTeam==null)
        {
            System.out.println("No current team exists, create a team and try again.\n");
        }
                
        else
        {
        System.out.println("Please enter member ID: ");
        int ID= userInput.nextInt();
       if(ID==login.currentLeader.getMemberID())
       {
           System.out.println("You are already this team's leader and assigned to it by default.\n");
       }
       else
       {
        boolean found = false;
       
       for (int i=0;i<teamMember.members.size();i++)
        {
            if (ID==teamMember.members.get(i).getMemberID())
            {
             found=true;
             login.currentLeader.currentTeam.teamMembers.add(teamMember.members.get(i));
             teamMember.members.get(i).currentTeam=login.currentLeader.currentTeam;
             System.out.println("Member assigned.\n ");
            }
           
               
        } 
        if(found==false)
           {
           System.out.println("Member not found,please try again.\n ");
           }
        }
        }
       home.home(true);
    }
    
    public static void createTask()
    {
        
        if (login.currentLeader.currentTeam==null)
        {
            System.out.println("No current team exists, create a team and try again.\n");
            home.home(true);
        }
        else
        {
        System.out.println("Please enter task name: ");
        String Taskname= userInput.next();
        
        System.out.println("Please enter task deadline day: ");
        int deadlineDay= userInput.nextInt();
        System.out.println("Please enter task deadline month: ");
        int deadlineMonth= userInput.nextInt();
        System.out.println("Please enter task deadline year: ");
        int deadlineYear= userInput.nextInt();
        
        date taskDeadline=new date (deadlineDay,deadlineMonth,deadlineYear);
        task newTask= new task(Taskname,taskDeadline);
        
        //Task added to tasks array
        task.tasks.add(newTask);
        
        //Tasks added to team tasks
        login.currentLeader.currentTeam.teamTasks.add(newTask);
        login.currentLeader.currentTeam.teamTasksCounter++;
        
        System.out.println("Task created with ID : "+newTask.getTaskID()  + "\n ");
        
        home.home(true);
    }
    }
    
    public static void editTask() 
    {
        if (login.currentLeader.currentTeam==null)
        {
            System.out.println("No current team exists, create a team and try again.\n");
        }
        else
        {
        System.out.println("1-Edit Your own task");
        System.out.println("2-Edit team task ");
        
        int x = userInput.nextInt();

        switch (x) {
            case 1:
                System.out.println("Please choose which task you wish to change its status by writing its ID");
                x = userInput.nextInt();

                boolean found = false;

                for (int i = 0; i < login.currentLeader.listOfTasks.size(); i++) {

                    if (x == login.currentLeader.listOfTasks.get(i).getTaskID()) {
                        found = true;
                        if (login.currentLeader.listOfTasks.get(i).getCurrentStatus() == task.status.toDo) {
                            System.out.println("Task current status: To Do");
                        } else if (login.currentLeader.listOfTasks.get(i).getCurrentStatus() == task.status.onGoing) {
                            System.out.println("Task current status: Ongoing");
                        } else {
                            System.out.println("Task current status: Done");
                        }

                        System.out.println("Choose what would you like to change the current status to by writing its number");
                        System.out.println("1-To Do");
                        System.out.println("2-Ongoing");
                        System.out.println("3-Done");
                        
                        x = userInput.nextInt();

                        switch (x) {
                            case 1:
                                login.currentUser.listOfTasks.get(i).currentStatus = task.status.toDo;
                                break;
                            case 2:
                                login.currentUser.listOfTasks.get(i).currentStatus = task.status.onGoing;
                                break;
                            case 3:
                                login.currentUser.listOfTasks.get(i).currentStatus = task.status.done;
                                break;
                            default:
                                System.out.println("input not valid, please try again");
                                home.home(true);
                                break;
                        }

                    }
                }
                if (found == false) {
                    System.out.println("Task ID not found, please try again.");
                } else {
                    System.out.println("Task's status edited.\n");
                }
                home.home(true);
                break;
            case 2:
                System.out.println("Please choose which task you wish to edit by writing its ID");
                x = userInput.nextInt();
                found = false;

                for (int i = 0; i < login.currentLeader.currentTeam.teamTasks.size(); i++) {

                    if (x == login.currentLeader.currentTeam.teamTasks.get(i).getTaskID()) {
                        found = true;

                        System.out.println("Choose what you would like to edit by typing its number.");
                        System.out.println("1-Task name ");
                        System.out.println("2-Task deadline day ");
                        System.out.println("3-Task deadline month ");
                        System.out.println("4-Task deadline year ");

                        x = userInput.nextInt();
                        date deadlineDate = login.currentLeader.currentTeam.teamTasks.get(i).getDeadline();

                        if (x == 1) {
                            System.out.println("Enter new task name");
                            String y = userInput.next();
                            login.currentLeader.currentTeam.teamTasks.get(i).setName(y);
                        } else if (x == 2) {
                            System.out.println("Enter new deadline day");
                            x = userInput.nextInt();
                            deadlineDate.setDay(x);
                        } else if (x == 3) {
                            System.out.println("Enter new deadline month");
                            x = userInput.nextInt();
                            deadlineDate.setMonth(x);
                        } else if (x == 4) {
                            System.out.println("Enter new deadline year");
                            x = userInput.nextInt();
                            deadlineDate.setYear(x);
                        } else {
                            System.out.println("input not valid, please try again");
                            home.home(true);
                        }

                    }
                }

                if (found == false) 
                {
                    System.out.println("Task ID not found, please try again.");
                }
                else
                {
                    System.out.println("Task edited");
                }
                home.home(true);
                break;
                
            default:
                System.out.println("input not valid, please try again");
                home.home(true);
                break;
                
                
        }

    }
        home.home(true);
    }
    
    public static void deleteTask()
    {
        if (login.currentLeader.currentTeam==null)
        {
            System.out.println("No current team exists, create a team and try again.\n");
        }
        else
        {
        System.out.println("Please choose which task you wish to delete by writing its ID");
        
        int x = userInput.nextInt();
        boolean found = false;
        
        for (int i = 0; i <login.currentLeader.currentTeam.teamTasks.size(); i++) 
        {

            if (login.currentLeader.currentTeam.teamTasks.get(i).getTaskID() == x) 
            {
                found = true;
                login.currentLeader.currentTeam.teamTasks.remove(i); 
                break;
            }
        }
        if (found == false) 
        {
            System.out.println("Task ID not found, please try again.");
            
        }
        else
        {
            System.out.println("Task deleted.");
        }
        
        
    }
       home.home(true); 
    }
    
    public static void assignTask()
    {
        if (login.currentLeader.currentTeam==null)
        {
            System.out.println("No current team exists, create a team and try again.\n");
        }
        else
        {
        System.out.println("ID of team member:");
        int x=userInput.nextInt();
        
        System.out.println("ID of task:");
        int y=userInput.nextInt();
        
        boolean assigned=false;
        
        if (x==login.currentLeader.getMemberID())
        {
            for (int j = 0; j < login.currentLeader.currentTeam.teamTasks.size(); j++) 
            {
               
                if (y == login.currentLeader.currentTeam.teamTasks.get(j).getTaskID()) 
                    
                {
                    assigned=true;
                    
                    //assign task to member
                    login.currentLeader.listOfTasks.add(login.currentLeader.currentTeam.teamTasks.get(j));
                    login.currentLeader.numberOfTasks++;
                    //assign member to task
                    login.currentLeader.currentTeam.teamTasks.get(j).assignedUsers.add(login.currentLeader);
                        
                    System.out.println("Task assigned.");
                    break;
                }                    
            }
            
        }
        
        else
        {
        for (int i = 0; i < login.currentLeader.currentTeam.teamMembers.size(); i++) 
        {
            if (x == login.currentLeader.currentTeam.teamMembers.get(i).getMemberID()) 
            {
                for (int j = 0; j < login.currentLeader.currentTeam.teamTasks.size(); j++) 
                {
                    if (y == login.currentLeader.currentTeam.teamTasks.get(j).getTaskID()) 
                    {
                        assigned=true;
                        
                        //assign task to member
                        teamMember.members.get(i).listOfTasks.add(login.currentLeader.currentTeam.teamTasks.get(j));
                        teamMember.members.get(i).numberOfTasks++;
                        //assign member to task
                        login.currentLeader.currentTeam.teamTasks.get(j).assignedUsers.add(teamMember.members.get(i));
                        
                        System.out.println("Task assigned.");
                        break;
                    }                    
                }
            }
        }
        }
          
        if (assigned==false)
        {
            System.out.println("team member ID or task ID not valid or member not assigned to team, please try again.");
        }
        
    }
        home.home(true);
    }
    
    
    public static void unassignTask()
    {
        if (login.currentLeader.currentTeam==null)
        {
            System.out.println("No current team exists, create a team and try again.\n");
        }
        else
        {
        System.out.println("ID of team member:");
        int x=userInput.nextInt();
        
        System.out.println("ID of task:");
        int y=userInput.nextInt();
        
        boolean unassigned=false;
        
        if (x==login.currentLeader.getMemberID())
        {
            for (int j = 0; j < login.currentLeader.listOfTasks.size(); j++) 
                {
                    if (y == login.currentLeader.listOfTasks.get(j).getTaskID()) 
                    {
                        unassigned=true;
                        
                        //unassign task from member
                        login.currentLeader.listOfTasks.remove(j);
                        login.currentLeader.numberOfTasks--;
                        
                        //unassign member from task
                        login.currentLeader.currentTeam.teamTasks.get(j).assignedUsers.remove(login.currentLeader);
                        
                        System.out.println("task unassigned.");
                        break;
                    }
                }
        
        }
        else
        {
            for (int i = 0; i < login.currentLeader.currentTeam.teamMembers.size(); i++) 
        {
            if (x == login.currentLeader.currentTeam.teamMembers.get(i).getMemberID()) 
            {
                for (int j = 0; j < login.currentLeader.currentTeam.teamMembers.get(i).listOfTasks.size(); j++) 
                {
                    if (y == login.currentLeader.currentTeam.teamMembers.get(i).listOfTasks.get(j).getTaskID()) 
                    {
                        unassigned=true;
                        
                        //unassign task from member
                        teamMember.members.get(i).listOfTasks.remove(j);
                        teamMember.members.get(i).numberOfTasks--;
                        //unassign member from task
                        teamMember.members.get(i).listOfTasks.get(j).assignedUsers.remove(i);
                        
                        System.out.println("task unassigned.");
                        break;
                    }
                }
            }
        }
        }
        if (unassigned==false)
        {
            System.out.println("team member ID or task ID not valid or task not assigned to this member, please try again.");
            
        }
        
    }
        home.home(true);
    }
    
    
    public static void browseTask() {
        if (login.currentLeader.currentTeam==null)
        {
            System.out.println("No current team exists, create a team and try again.\n");
        }
        else
        {
        
        System.out.println("1-All Tasks\n2-Your Tasks\n3-Search a task by name");
        int x=userInput.nextInt();
        
        if (x==1)
        {
            if (login.currentLeader.currentTeam.teamTasks.size()==0)
                {
                    System.out.println("No team tasks to display.\n");
                }
            else
                {
                    for (int i = 0; i < login.currentLeader.currentTeam.teamTasks.size(); i++)
                    {
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
        }  
        
        
        else if (x==2)
        {
            if (login.currentLeader.listOfTasks.size()==0)
            {
                System.out.println("No tasks assigned to you avaliable to display.");
            }
            else
            {
        for (int i = 0; i < login.currentLeader.listOfTasks.size(); i++) 
        {
    
            date endDate;
            endDate=login.currentLeader.listOfTasks.get(i).getDeadline();
            
            System.out.println("----------------------------------------");
            System.out.println("Task ID : "+login.currentLeader.listOfTasks.get(i).getTaskID());
            System.out.println("Task Name : "+login.currentLeader.listOfTasks.get(i).getName());
            System.out.println("Task Deadline : "+endDate.getDay()+"/"+endDate.getMonth()+"/"+endDate.getYear());
            System.out.println("Assigned team members:");
            
            for(int j=0;j<login.currentLeader.listOfTasks.get(i).assignedUsers.size();j++)
            {
                        System.out.println("Assigned member name: " + login.currentLeader.listOfTasks.get(i).assignedUsers.get(j).getUsername());
                        System.out.println("Assigned member ID: " + login.currentLeader.listOfTasks.get(i).assignedUsers.get(j).getMemberID());
            }
            System.out.println("----------------------------------------");
        }
            }
        }
        else if (x==3)
        {
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
               System.out.println("Couldn't find a task with this name please check you are typing the name correctly and try again.\n"); 
            }
        }
        else {
            System.out.println("Input not valid, please try again.");
        }
        
        
    }
        home.home(true);
}
}

