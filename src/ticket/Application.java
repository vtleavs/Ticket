/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.Date;
import java.util.Scanner;

/**
 * The 'Ticket' application
 * 
 * @author Ben Leavitt
 */
public class Application
{
    TicketBuffer buffer;
    static Scanner input;

    /**
     * Initializes values
     */
    public Application() 
    {
        input = new Scanner(System.in).useDelimiter("\n");
        buffer = new TicketBuffer();
    }
    
    /**
     * Runs the application
     */
    public void run()
    {
        System.out.println(currentDate().toString()+"\n");
        
        System.out.println("Welcome to Ticket V1");
        System.out.println("Time to start Organizing your Life!");
        System.out.println();
        
        buffer.openSaveFile();
        
        System.out.println("Please enter a command (h for list of commands)");
        
        boolean runStatus = true;
        do
        {
            System.out.print(">> ");
            runStatus = getUserCommands(input);
        }while(runStatus);
    }
    
    /**
     * Called every time a user command is needed.  Asks user to input a 
     * command, and executes the command entered.
     * 
     * @param input The stream to get user input from
     * @return The run status of the program, quits on false
     */
    public boolean getUserCommands(Scanner input)
    {
        String in = input.next();
        switch(in)
        {
            case "h": listCommands();
                break;
            case "n": buffer.addTicket(input); // create new ticket
                break;
            case "d": buffer.deleteTicket(input); // delete ticket
                break;
            case "e": buffer.editTicket(input); // edit ticket
                break;
            case "r": buffer.sortByPriority(); // sort tickets
                break;
            case "l": showList(); // show ticket list
                break;
            case "s": buffer.save(); // save list
                break;
            case "x": return false;// exit program
            default: System.out.println("Type h for list of commands");
        }
        return true;
    }

    /**
     * Prints out the contents of 'buffer'
     */
    public void showList()
    {
        System.out.println();
        System.out.println(buffer.toString());
    }
    
    /**
     * If the user is prompted to input a String, and inputs a value that is not
     * recognized by the program, this will re-prompt the user to enter a valid
     * String.
     * 
     * @param input The stream to get user input from
     * @return The revised prompt input
     */
    public static String noSuchPromptString(Scanner input)
    {
        System.out.println("That is not a valad command.  Please re-enter");
        System.out.print(">> ");
        return input.next();
    }
    
    /**
     * If the user is prompted to input an int, and inputs a value that is not
     * recognized by the program, this will re-prompt the user to enter a valid
     * int.
     * 
     * @param input The stream to get user input from
     * @return The revised prompt input
     */
    public static int noSuchPromptInt(Scanner input)
    {
        System.out.println("That is not a valad command.  Please re-enter");
        System.out.print(">> ");
        return input.nextInt();
    }
    
    /**
     * If the user is prompted to input a double, and inputs a value that is not
     * recognized by the program, this will re-prompt the user to enter a valid
     * double.
     * 
     * @param input The stream to get user input from
     * @return The revised prompt input
     */
    public static double noSuchPromptDouble(Scanner input)
    {
        System.out.println("That is not a valad command.  Please re-enter");
        System.out.print(">> ");
        return input.nextDouble();
    }
    
    /**
     * Prints the list of available commands to the output
     */
    public void listCommands()
    {
        System.out.println();
        System.out.println(" h - list of commands");
        System.out.println(" n - new ticket");
        System.out.println(" d - delete ticket");
        System.out.println(" e - edit ticket");
        System.out.println(" r - sort tickets");
        System.out.println(" l - display ticket list");
        System.out.println(" x - exit program");
        System.out.println(" s - save list");
        System.out.println();
    }
    
    /**
     * Calculates current date.
     * @return The date.
     */
    static Date currentDate()
    {
        return new Date(System.currentTimeMillis());
    }
}
