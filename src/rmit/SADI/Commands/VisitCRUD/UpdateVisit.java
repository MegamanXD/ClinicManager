package rmit.SADI.Commands.VisitCRUD;

import rmit.SADI.Commands.APIs.GetPatientByID;
import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateVisit {
    //Singleton
    private static UpdateVisit instance = new UpdateVisit();
    private UpdateVisit(){}
    public static UpdateVisit getInstance() {
        return instance;
    }

    //Core method
    public void autoUpdate(Patient patient){
        for (Visit visit: VisitList.getInstance().getList()) {
            if (visit.getPatient().getId() == patient.getId()){
                visit.setPatient(patient);
                VisitList.getInstance().getList().set(visit.getId()-1,visit);
            }
        }
    }
}
