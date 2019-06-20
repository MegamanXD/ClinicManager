package rmit.SADI.Commands.PatientCRUD;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.PatientList;

import java.util.Scanner;

public class NewPatient implements Command {
    //Singleton
    private static NewPatient instance = new NewPatient();
    private NewPatient(){}
    public static NewPatient getInstance() {
        return instance;
    }

    //Core method
    public Patient createPatient(){
        Patient patient = new Patient();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter patient's Name: ");
        patient.setName(s.nextLine());
        System.out.print("Enter patient's Birthdate (dd-mm-yyyy): ");
        patient.setBirthdate(s.nextLine());
        return patient;
    }

    @Override
    public void execute() {
        Patient patient = createPatient();
        System.out.println();
        PatientList patientList = PatientList.getInstance();
        if (patient.getBirthdate() != null){
            patient.setId(patientList.getList().size()+1);
            patientList.getList().add(patient);
        }
    }
}
