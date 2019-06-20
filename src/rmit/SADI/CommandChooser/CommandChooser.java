package rmit.SADI.CommandChooser;

import rmit.SADI.Commands.Command;
import rmit.SADI.Commands.PatientCRUD.DeletePatient;
import rmit.SADI.Commands.PatientCRUD.NewPatient;
import rmit.SADI.Commands.PatientCRUD.UpdatePatient;
import rmit.SADI.Commands.PatientCRUD.ViewAllPatients;
import rmit.SADI.Commands.PrescribedDrugCRUD.ViewAllPrescribedDrugs;
import rmit.SADI.Commands.PrescriptionCRUD.NewPrescription;
import rmit.SADI.Commands.PrescriptionCRUD.ViewAllPrescriptions;
import rmit.SADI.Commands.VisitCRUD.NewVisit;
import rmit.SADI.Commands.VisitCRUD.ViewAllVisits;

public class CommandChooser {
    Command[] commands= {
            NewPatient.getInstance(),
            DeletePatient.getInstance(),
            UpdatePatient.getInstance(),
            ViewAllPatients.getInstance(),

            NewVisit.getInstance(),
            ViewAllVisits.getInstance(),

            NewPrescription.getInstance(),
            ViewAllPrescriptions.getInstance(),

            ViewAllPrescribedDrugs.getInstance(),

            APIChooser.getInstance()
    };

    //Singleton
    private static CommandChooser instance = new CommandChooser();
    private CommandChooser(){}
    public static CommandChooser getInstance() {
        return instance;
    }

    //Core method
    public void performOption(int option){
        commands[option-1].execute();
    }
}
