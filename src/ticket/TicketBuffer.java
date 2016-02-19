/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class TicketBuffer 
{
    private ArrayList<Ticket> tickets;
    
    public TicketBuffer()
    {
        tickets = new ArrayList<>();
    }
    
    public void addTicket(Scanner input)
    {
        System.out.println();
        System.out.println("Add a new Ticket");
        System.out.println();
        
        System.out.println("Enter a title for the ticket");
        System.out.print(">> ");
        String title = input.next();
        System.out.println();
        
        System.out.println("Enter a description for the ticket");
        System.out.print(">> ");
        String description = input.next();
        System.out.println();
        
        System.out.println("Enter a priority for the ticket");
        System.out.print(">> ");
        int priority = -1;
       
        try
        {
            priority = input.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Must be an integer value.");
            Application.noSuchPromptInt(input);
        }
        
        System.out.println();
        
        System.out.println("Creating Ticket.....");
        Ticket t = new Ticket(title, description, priority);
        
        System.out.println("Adding to List.....");
        sortByPriority();
        
        tickets.add(t);
        System.out.println();
    }
    
    public void editTicket(Scanner input)
    {
        System.out.println();
        System.out.println("Which ticket would you like to edit?");
        int index = input.nextInt();
        System.out.println();
        
        System.out.println("As it stands, this Ticket reads:");
        System.out.println(tickets.get(index).toString());
        System.out.println("Is this the Ticket you wish to edit? (y/n)");
        if(input.next().equals("n"))
            return;
        
        System.out.println("Would you like to edit:");
        System.out.println("    1. Title");
        System.out.println("    2. Description");
        System.out.println("    3. Priority");
        int selector = input.nextInt();
        
        System.out.println("What would you like to change it to?");
        if(selector == 1)
        {
            tickets.get(index).setTitle(input.next());
        }
        else if(selector == 2)
        {
            tickets.get(index).setDescription(input.next());
        }
        else if(selector == 3)
        {
            tickets.get(index).setUserPriority(input.nextInt());
        }
        
        System.out.println("This is what the Ticket looks like now: ");
        System.out.println(tickets.get(index).toString());
        
        System.out.println("Would you like to edit another? (y/n)");
        if(input.next().equals("y"))
        {
            editTicket(input);
        }
    }
    
    public void deleteTicket(Scanner input)
    {
        System.out.println();
        System.out.println("Which ticket would you like to delete (index)");
        int index = input.nextInt();
        System.out.println("As it stands, this Ticket reads:");
        System.out.println(tickets.get(index).toString());
        System.out.println("Is this the Ticket you wish to delete? (y/n)");
        if(input.next().equals("n"))
            return;
        
        tickets.remove(index);
    }
    
    public void save() // add support to make multiple files
    {
        System.out.println();
        System.out.println("Saving.....");
        
        PrintWriter writer = null;
        
        try {
            writer = new PrintWriter("ticket_list.txt", "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < tickets.size(); i++)
        {
            writer.println(i);
            writer.println(tickets.get(i));
            writer.println();
        }
        
        writer.close();
    }
    
    public void sortByPriority()
    {
        Ticket temp;
        for(int i = 0; i < tickets.size()-1; i++)
        {
            for(int j = 1; j < tickets.size()-i; j++)
            {
                if(tickets.get(j-1).getPriority() > tickets.get(j).getPriority())
                {
                    temp = tickets.get(j-1);
                    tickets.set(j-1, tickets.get(j));
                    tickets.set(j, temp);
                }
            }
        }    
    }
    
    public void openSaveFile()
    {
        System.out.println("Opening Save File.....");
        FileReader reader = null;
        File file = new File("ticket_list.txt");
        
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader br = new BufferedReader(reader);
        
        String title = "";
        String description = "";
        double priority = -1;
        
        boolean reading = true;
        while(reading)
        {
            try 
            {
                br.readLine();
                title = br.readLine();
                description = br.readLine();
                br.skip(10);
                priority = Double.parseDouble(br.readLine());
                br.skip(0);
                br.readLine();
                tickets.add(new Ticket(title, description, priority));
            } 
            catch (IOException | NullPointerException ex) 
            {
                reading = false;
            }
        }
        
        System.out.println();
    }

    @Override
    public String toString() 
    {
        String s = "";
        for(int i = 0; i < tickets.size(); i++)
        {
            s = s + i + "\n" + tickets.get(i).toString() + "\n\n";
        }
        return s;
    }
    
    
}
