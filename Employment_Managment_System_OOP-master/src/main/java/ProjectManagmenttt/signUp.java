/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagmenttt;

import java.util.Scanner;


public class signUp {
    static Scanner input= new Scanner(System.in);
    public static void signUpp ()
    {
        System.out.println("1-Create new account");
        System.out.println("2-Login to an existing account");
        System.out.println("3-Close application");
        
        int x =input.nextInt();
        
        if (x == 1) 
        {
            System.out.println("Create username: ");
            String username = input.next();

            System.out.println("Create password: ");
            String password = input.next();

            System.out.println("Choose user type by typing its number ");
            System.out.println("1- Team Leader ");
            System.out.println("2- Team Member ");

            x = input.nextInt();

            switch (x) {
                case 1:
                    teamLeader user = new teamLeader(username, password);
                    teamLeader.leaders.add(user);
                    login.currentLeader = user;
                    home.home(true);
                    break;
                case 2:
                    teamMember user2 = new teamMember(username, password);
                    teamMember.members.add(user2);
                    login.currentUser = user2;
                    home.home(false);
                    break;
                default:
                    System.out.println("input not valid, please try again.");
                    signUpp();
                    break;
            }

        }
        else if (x==2)
        {
            login.loginn();
        }
        else if (x==3)
        {
            System.exit(0);
        }
        else
        {
           System.out.println("input not valid, please try again.");
           signUpp(); 
        }
        
        
        
        
        
    }
    
}
