package rmit.SADI.Commands.PrescribedDrugCRUD;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.PrescribedDrugList;

public class ViewAllPrescribedDrugs implements Command {
    //Singleton
    private static ViewAllPrescribedDrugs instance = new ViewAllPrescribedDrugs();
    private ViewAllPrescribedDrugs(){}
    public static ViewAllPrescribedDrugs getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println(PrescribedDrugList.getInstance());
    }
}
