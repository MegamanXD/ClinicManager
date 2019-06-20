package rmit.SADI.Commands.VisitCRUD;

import rmit.SADI.Commands.APIs.GetPatientByID;
import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.Visit;
import rmit.SADI.CoreDatabase.VisitList;

public class ViewAllVisits implements Command {
    //Singleton
    private static ViewAllVisits instance = new ViewAllVisits();
    private ViewAllVisits(){}
    public static ViewAllVisits getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println(VisitList.getInstance());
    }
}
