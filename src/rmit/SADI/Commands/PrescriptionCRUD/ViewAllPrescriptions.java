package rmit.SADI.Commands.PrescriptionCRUD;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.*;

public class ViewAllPrescriptions implements Command {
    //Singleton
    private static ViewAllPrescriptions instance = new ViewAllPrescriptions();
    private ViewAllPrescriptions(){}
    public static ViewAllPrescriptions getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println(PrescriptionList.getInstance());
    }
}
