package rmit.SADI.Commands.APIs;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.PrescribedDrugList;

public class ReportDrugsPrescribed implements Command {
    //Singleton
    private static ReportDrugsPrescribed instance = new ReportDrugsPrescribed();
    private ReportDrugsPrescribed(){}
    public static ReportDrugsPrescribed getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println("\n***Report of Prescribed Drugs***");
        System.out.println("No. of drugs prescribed = " + PrescribedDrugList.getInstance().getList().size());
        System.out.println(PrescribedDrugList.getInstance());
    }
}
