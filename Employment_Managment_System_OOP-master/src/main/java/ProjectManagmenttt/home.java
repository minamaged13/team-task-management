/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagmenttt;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class home {
     static Scanner input=new Scanner(System.in);
    
    public static void home(boolean leader)
    {
        if(leader==false)
        {
        System.out.println("Welcome "+login.currentUser.getUsername()+" your ID is "+login.currentUser.getMemberID());
        System.out.println("1-Browse tasks");
        System.out.println("2-Edit tasks");
        System.out.println("3-Logout");
        
        int x=input.nextInt();
        switch (x)
        {
            case 1: teamMember.browseTask(); 
            break;
            case 2: teamMember.editTask();
            break;
            case 3: signUp.signUpp();
            break;
            default:System.out.println("input not valid,please try again");
            home.home(false);
            break;
        }
        }
        
        else if (leader==true)
        {
        System.out.println("Welcome "+login.currentLeader.getUsername()+" your ID is "+login.currentLeader.getMemberID());   
        System.out.println("1-Create team");
        System.out.println("2-Assign member to team");
        System.out.println("3-Create task");
        System.out.println("4-Edit task"); 
        System.out.println("5-Assign task"); 
        System.out.println("6-Unassign task"); 
        System.out.println("7-Delete task");
        System.out.println("8-Browse tasks");
        System.out.println("9-Logout");
        
        int x=input.nextInt();
        
        switch (x)
        {
            case 1: teamLeader.createTeam(); 
            break;
            case 2: teamLeader.assignMemberToTeam();
            break;
            case 3: teamLeader.createTask();
            break;
            case 4: teamLeader.editTask();
            break;
            case 5: teamLeader.assignTask();
            break;
            case 6: teamLeader.unassignTask();
            break;
            case 7: teamLeader.deleteTask();
            break;
            case 8: teamLeader.browseTask();
            break;
            case 9: signUp.signUpp();
            break;
            default:System.out.println("input not valid,please try again");
            home.home(true);
            break;
        }
        
        }
    }
    
}
