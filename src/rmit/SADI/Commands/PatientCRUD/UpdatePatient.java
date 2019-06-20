package rmit.SADI.Commands.PatientCRUD;

import rmit.SADI.Commands.APIs.GetPatientByID;
import rmit.SADI.Commands.Command;
import rmit.SADI.Commands.PrescriptionCRUD.UpdatePrescription;
import rmit.SADI.Commands.VisitCRUD.UpdateVisit;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.PatientList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdatePatient implements Command {
    //Singleton
    private static UpdatePatient instance = new UpdatePatient();
    private UpdatePatient(){}
    public static UpdatePatient getInstance() {
        return instance;    }

    //Core method
    private Patient updatePatient(int id){
        Patient patientToBeUpdated = GetPatientByID.getInstance().getPatientByID(id);
        if (patientToBeUpdated == null)
            System.out.println("Can't update non-existing people :)");
        else {
            patientToBeUpdated.setId(id);
            System.out.println("Current patient details:\n" + patientToBeUpdated +"\n");
            Scanner s = new Scanner(System.in);
            System.out.print("Update patient's Address: ");
            patientToBeUpdated.setAddress(s.nextLine());
            System.out.print("Update patient's gender (male/female): ");
            patientToBeUpdated.setGender(s.nextLine());
            PatientList.getInstance().getList().set(id-1, patientToBeUpdated);
            System.out.println("Updated info:\n" + patientToBeUpdated);
        }
        return patientToBeUpdated;
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter patient's ID: ");
        int patientID;
        try{
            patientID = s.nextInt();
            s.nextLine();
            Patient updatedPatient = updatePatient(patientID);
            System.out.println();

            UpdateVisit.getInstance().autoUpdate(updatedPatient);
            UpdatePrescription.getInstance().autoUpdate(updatedPatient);
        }catch (InputMismatchException e){
            System.out.println("Input: Invalid!");
            System.out.println();
        }
    }
}
