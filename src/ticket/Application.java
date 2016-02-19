/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;



import java.util.Scanner;

/**
 *
 * @author Ben
 */
public class Application
{
    TicketBuffer buffer;
    
    public void run()
    {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        
        buffer = new TicketBuffer();
        //tickets = new ArrayList<>();
        
        System.out.println("Welcome to Ticket V1");
        System.out.println("Time to start Organizing your Life!");
        System.out.println();
        
        buffer.openSaveFile();
        
        System.out.println("Please enter a command (h for list of commands)");
        
        boolean exitStatus = true;
        do
        {
            System.out.print(">> ");
            exitStatus = getUserInput(input);
        }while(exitStatus);
    }
    
     public boolean getUserInput(Scanner input)
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

    public void showList()
    {
        System.out.println();
        System.out.println(buffer.toString());
    }
    
    public static String noSuchPromptString(Scanner input)
    {
        System.out.println("That is not a valad command.  Please re-enter");
        System.out.print(">> ");
        return input.next();
    }
    
    public static int noSuchPromptInt(Scanner input)
    {
        System.out.println("That is not a valad command.  Please re-enter");
        System.out.print(">> ");
        return input.nextInt();
    }
    
    public static double noSuchPromptDouble(Scanner input)
    {
        System.out.println("That is not a valad command.  Please re-enter");
        System.out.print(">> ");
        return input.nextDouble();
    }
    
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
}
