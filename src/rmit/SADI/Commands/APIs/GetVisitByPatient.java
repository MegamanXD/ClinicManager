package rmit.SADI.Commands.APIs;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Visit;
import rmit.SADI.CoreDatabase.VisitList;
import rmit.SADI.ListToString.ListToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetVisitByPatient implements Command {
    private VisitList visitList = VisitList.getInstance();

    //Singleton
    private static GetVisitByPatient instance = new GetVisitByPatient();
    private GetVisitByPatient(){}
    public static GetVisitByPatient getInstance() {
        return instance;
    }

    //Core Method
    private List<Visit> getVisitByPatient(int id){
        List<Visit> found = new ArrayList<>();
        for (Visit visit:visitList.getList()){
            if (visit.getPatient().getId() == id)
                found.add(visit);
        }
        return found;
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("***Get visits by Patient***");
        System.out.print("Search for Patient ID: ");
        List<Visit> found = getVisitByPatient(s.nextInt());
        s.nextLine(); //Get the Enter key out of the Scanner
        if (found.size() == 0)
            System.out.println("\nNo visit. Must be doctors' holiday :)\n");
        else
            System.out.println(ListToString.VisitList(found));
    }
}
