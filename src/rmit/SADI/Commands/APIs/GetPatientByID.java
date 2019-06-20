package rmit.SADI.Commands.APIs;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.PatientList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetPatientByID implements Command {
    private PatientList patientList = PatientList.getInstance();

    //Singleton
    private static GetPatientByID instance = new GetPatientByID();
    private GetPatientByID(){}
    public static GetPatientByID getInstance() {
        return instance;
    }

    //Core Method
    public Patient getPatientByID(int id){          //Usually each person is given a different ID
        for (Patient patient:patientList.getList()){
            if (patient.getId() == id)
                return patient;
        }
            return null;
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("***Get patient by ID***");
        System.out.print("Search for Patient ID: ");

        try{
            int patientID =  s.nextInt();
            s.nextLine(); //Get the Enter key out of the Scanner
            Patient found = getPatientByID(patientID);
            if (found == null)
                System.out.println("\nThis person is not here. Must be at home then :)\n");
            else
                System.out.println("\nFound:    "+found+"\n");
        }catch (InputMismatchException e){
            System.out.println("\nInput: Invalid!");
            System.out.println();
        }
    }
}
