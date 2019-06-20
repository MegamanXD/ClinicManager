package rmit.SADI.Commands.APIs;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.PatientList;
import rmit.SADI.ListToString.ListToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetPatientByName implements Command {
    private PatientList patientList = PatientList.getInstance();

    //Singleton
    private static GetPatientByName instance = new GetPatientByName();
    private GetPatientByName(){}
    public static GetPatientByName getInstance() {
        return instance;
    }

    //Core Method
    private List<Patient> getPatientByName(String name){
        List<Patient> found = new ArrayList<>();
        for (Patient patient:patientList.getList()){
            if (patient.getName().indexOf(name) >-1)
                found.add(patient);
        }
        return found;
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("***Get patients by Name***");
        System.out.print("Search for Name (case sensitive): ");
        List<Patient> found = getPatientByName(s.nextLine());
        if (found.size() == 0)
            System.out.println("\nThis person is not here. Must be at home then :)\n");
        else
            System.out.println(ListToString.PatientList(found));
    }
}
