/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ben
 */
public class Ticket 
{
    private double priority;
    private String title;
    private String description;
    private int userPriority;
    //private Date dateCreated = new Date();
    //private Date deadline;
    
    public Ticket(String ti, String disc, int prior)
    {
        title = ti;
        description = disc;
        userPriority = prior;
        priority = userPriority;
    }
    
    public Ticket(String ti, String disc, double prior)
    {
        title = ti;
        description = disc;
        priority = prior;
    }
    
    public String toString()
    {
        return title + "\n" + description + "\n" + "Priority: " + priority;
    }
    
    public double getPriority()
    {
        return priority;
    }
    
    public int getUserPriority()
    {
        return userPriority;
    }
    
    public void setUserPriority(int u)
    {
        userPriority = u;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String t)
    {
        title = t;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String d)
    {
        description = d;
    }
    
    
}
