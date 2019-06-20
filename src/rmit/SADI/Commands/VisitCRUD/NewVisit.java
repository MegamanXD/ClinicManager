package rmit.SADI.Commands.VisitCRUD;

import rmit.SADI.Commands.APIs.GetPatientByID;
import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.Visit;
import rmit.SADI.CoreDatabase.VisitList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewVisit implements Command {
    //Singleton
    private static NewVisit instance = new NewVisit();
    private NewVisit(){}
    public static NewVisit getInstance() {
        return instance;
    }

    //Core method
    public static Visit createVisit(){
        Visit visit = new Visit();
        Scanner s = new Scanner(System.in);
        try{
            System.out.print("Enter Patient ID: ");
            int patientID = s.nextInt();
            Patient patient = GetPatientByID.getInstance().getPatientByID(patientID);
            s.nextLine(); //Get the Enter key out of the Scanner4
            if (patient == null){
                System.out.println("No such person.");
                return null;
            }

            visit.setPatient(patient);
            System.out.print("Enter date of visit (dd-mm-yyyy): ");
            visit.setDate(s.nextLine());
            if (visit.getDate() == null)
                return null;

            System.out.print("Enter patient's Problems: ");
            visit.setProblems(s.nextLine());

        }catch (InputMismatchException e){
            System.out.println("Input: Invalid!");
            return null;
        }
        return visit;
    }

    @Override
    public void execute() {
        VisitList visitList = VisitList.getInstance();
        Visit visit = createVisit();
        System.out.println();
        if (visit != null){
            visit.setId(visitList.getList().size()+1);
            visitList.getList().add(visit);
        }
    }
}
