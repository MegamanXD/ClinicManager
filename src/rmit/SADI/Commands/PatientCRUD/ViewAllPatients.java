package rmit.SADI.Commands.PatientCRUD;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.PatientList;

public class ViewAllPatients implements Command {
    //Singleton
    private static ViewAllPatients instance = new ViewAllPatients();
    private ViewAllPatients(){}
    public static ViewAllPatients getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println(PatientList.getInstance());
    }
}
