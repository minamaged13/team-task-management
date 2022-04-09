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
public class login {
    
    static Scanner input= new Scanner(System.in);
    
    public static teamLeader currentLeader;
    public static teamMember currentUser;
    
    public static void loginn ()
    {
        System.out.println("Enter your username: ");
        String username=input.next();
        
        System.out.println("Enter your password: ");
        String password=input.next();
        
        System.out.println("Enter your account type: ");
        System.out.println("1-Team Leader ");
        System.out.println("2-Team Member ");
        int x=input.nextInt();
        
        boolean signedIn=false;
        
        if (x==1)
        {
            for (int i = 0 ; i < teamLeader.leaders.size();i++)
        {
            if (username.equals(teamLeader.leaders.get(i).getUsername())&&password.equals(teamLeader.leaders.get(i).getPassword()))
            {
                signedIn=true;
                currentLeader=teamLeader.leaders.get(i);
                home.home(true);
                break;
            }
        }
            
        }
        else if (x==2)
        {
            for (int i = 0 ; i < teamMember.members.size();i++)
        {
            if(username.equals(teamMember.members.get(i).getUsername())&&password.equals(teamMember.members.get(i).getPassword()))
            {
               signedIn=true;
               currentUser=teamMember.members.get(i);
               home.home(false);
               break;
            }
        }
            
        }
        else
        {
           System.out.println("input not valid, please try again.");
           loginn();
        }
        if (signedIn==false)
        {
            System.out.println("username or password not correct, try again.");
            loginn();
        }
        
        
    }
    
}

