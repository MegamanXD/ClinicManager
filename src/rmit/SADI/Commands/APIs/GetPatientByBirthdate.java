package rmit.SADI.Commands.APIs;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.PatientList;
import rmit.SADI.ListToString.ListToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GetPatientByBirthdate implements Command {
    private PatientList patientList = PatientList.getInstance();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Singleton
    private static GetPatientByBirthdate instance  = new GetPatientByBirthdate();
    private GetPatientByBirthdate(){}
    public static GetPatientByBirthdate getInstance() {
        return instance;
    }

    //Core method
    private List<Patient> getPatientByBirthdate(Date date){
        List<Patient> found = new ArrayList<>();
        for (Patient patient:patientList.getList()) {
            if (patient.getBirthdate().compareTo(date) == 0){
                found.add(patient);
            }
        }
        return found;
    }

    @Override
    public void execute() {
        Date date;
        Scanner s = new Scanner(System.in);
        System.out.println("***Get patients by Birthdate***");
        System.out.print("Search for Birthdate (dd-mm-yyyy): ");
        try {
            date = dateFormat.parse(s.nextLine());
            List<Patient> found = getPatientByBirthdate(date);
            if ( found.size() == 0)
                System.out.print("\nThis person is too healthy to go in here :)\n\n");
            else
                System.out.println(ListToString.PatientList(found));
        } catch (ParseException e) {
            System.out.println("\nInput: invalid!\n");
        }
    }
}
