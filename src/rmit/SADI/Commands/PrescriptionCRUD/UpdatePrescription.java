package rmit.SADI.Commands.PrescriptionCRUD;

import rmit.SADI.Commands.VisitCRUD.GetVisitByID;
import rmit.SADI.Commands.VisitCRUD.UpdateVisit;
import rmit.SADI.CoreDatabase.*;

public class UpdatePrescription {
    //Singleton
    private static UpdatePrescription instance = new UpdatePrescription();
    private UpdatePrescription(){}
    public static UpdatePrescription getInstance() {
        return instance;
    }

    //Core method
    public void autoUpdate(Patient patient){
        for (Prescription prescription: PrescriptionList.getInstance().getList()) {
            if (prescription.getVisit().getPatient().getId() == patient.getId()){
                prescription.setVisit(GetVisitByID.getInstance().getVisitByID(prescription.getVisit().getId()));
                PrescriptionList.getInstance().getList().set(prescription.getId()-1,prescription);
            }
        }
    }
}
