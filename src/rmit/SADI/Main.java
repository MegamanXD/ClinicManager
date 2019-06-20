package rmit.SADI;

import rmit.SADI.CommandChooser.CommandChooser;
import rmit.SADI.FileInputOutput.FileIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileIO.read();  //Load Database
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        byte option;
        CommandChooser commandChooser = CommandChooser.getInstance();

        do{
            System.out.println("1. New patient                      5. New visit                  7. New prescription                  9. View all prescribed drugs");
            System.out.println("2. Delete patient                   6. View all visits            8. View all prescriptions            10. APIs");
            System.out.println("3. Update patient");
            System.out.println("4. View all patients                                              11. Quit");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Input option: ");
            try{
                option = scan.nextByte();
                if (option<1 || option>11)
                {
                    System.out.println("Please enter only 1-11\n");
                    continue;
                }
                if (option == 11){
                    FileIO.export();    //Save Database
                    quit = true;
                    continue;
                }
                commandChooser.performOption(option);
            }catch (InputMismatchException e){
                System.out.println("Please enter only 1-11\n");
                scan.nextLine();
            }
        }while (!quit);
    }
}
