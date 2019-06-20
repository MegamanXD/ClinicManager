package rmit.SADI.CommandChooser;

import rmit.SADI.Commands.APIs.*;
import rmit.SADI.Commands.Command;

import java.util.InputMismatchException;
import java.util.Scanner;

public class APIChooser implements Command {
    Command[] commands = {
            GetPatientByID.getInstance(),
            GetPatientByBirthdate.getInstance(),
            GetPatientByName.getInstance(),

            GetVisitByDate.getInstance(),
            GetVisitByPatient.getInstance(),

            ReportDrugsPrescribed.getInstance(),
            ReportVisitsByDate.getInstance()
    };

    //Singleton
    private static APIChooser instance = new APIChooser();
    private APIChooser(){}
    public static APIChooser getInstance() {
        return instance;
    }

    //Core method
    private void performOption(int option){
        commands[option-1].execute();
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Get patient by ID                       4. Get visit by Date                       6. Report drugs prescribed");
        System.out.println("2. Get patient by Birthdate                5. Get visit by Patient                    7. Report visits by Date");
        System.out.println("3. Get patient by Name");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.print("Input option: ");
        try{
            int option = s.nextInt();
            s.nextLine();
            if (option <1 || option > 7){
                System.out.println("Input: invalid! You can only choose option 1-8\n");
                return;
            }
            performOption(option);
        }catch (InputMismatchException e){
            System.out.println("Input: invalid!\n");
            return;
        }

    }
}
