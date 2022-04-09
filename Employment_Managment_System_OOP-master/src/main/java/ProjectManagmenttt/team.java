/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagmenttt;

import java.util.ArrayList;

/**
 *
 * @author Tarek
 */
public class team {
    private String teamName;
    private final int teamID;
    private static int teamcounter=1;
    
    public ArrayList<task> teamTasks=new ArrayList<task>();
    public int teamTasksCounter=0;
    
    public ArrayList<teamMember> teamMembers=new ArrayList<teamMember>();
    public int teamMemberCount=0;
    
    public teamMember teamLeader;
    
    public static ArrayList<team> teams=new ArrayList<team>();
    
    public team(String teamName)
    {
      this.teamName=teamName;
      teamID=teamcounter;
      teamcounter++;
    }
    
    public int getTeamID()
    {
      return teamID;
    }
} 