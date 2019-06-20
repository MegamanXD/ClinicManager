package rmit.SADI.Commands.PatientCRUD;

import rmit.SADI.Commands.APIs.GetPatientByID;
import rmit.SADI.Commands.Command;
import rmit.SADI.Commands.PrescriptionCRUD.DeletePrescription;
import rmit.SADI.Commands.VisitCRUD.DeleteVisit;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.PatientList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeletePatient implements Command {
    //Singleton
    private static DeletePatient instance = new DeletePatient();
    private DeletePatient(){}
    public static DeletePatient getInstance() {
        return instance;    }

    //Core method
    private void removePatient(int id){
        Patient patientToBeDeleted = GetPatientByID.getInstance().getPatientByID(id);
        if (patientToBeDeleted == null)
            System.out.println("Can't delete non-existing people :)");
        else
            System.out.println("Deleted: " + patientToBeDeleted);
        PatientList.getInstance().getList().remove(patientToBeDeleted);
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter patient's ID: ");
        int patientID;
        try{
            patientID = s.nextInt();
            s.nextLine();
            removePatient(patientID);
            System.out.println();

            DeleteVisit.getInstance().autoDelete(patientID);
            DeletePrescription.getInstance().autoDelete(patientID);
        }catch (InputMismatchException e){
            System.out.println("Input: Invalid! Database: unchanged!");
            System.out.println();
        }
    }
}
