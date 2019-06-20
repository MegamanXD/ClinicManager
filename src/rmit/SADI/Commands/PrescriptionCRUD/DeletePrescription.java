package rmit.SADI.Commands.PrescriptionCRUD;

import rmit.SADI.Commands.PrescribedDrugCRUD.DeletePrescribedDrug;
import rmit.SADI.Commands.VisitCRUD.GetVisitByID;
import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.Prescription;
import rmit.SADI.CoreDatabase.PrescriptionList;

public class DeletePrescription {
    //Singleton
    private static DeletePrescription instance = new DeletePrescription();
    private DeletePrescription(){}
    public static DeletePrescription getInstance() {
        return instance;
    }

    //Core method
    public void autoDelete(int patientID){
        for (int i = 0; i < PrescriptionList.getInstance().getList().size(); i++) {
            Prescription prescription = PrescriptionList.getInstance().getList().get(i);
            if (prescription.getVisit().getPatient().getId() == patientID){
                DeletePrescribedDrug.getInstance().autoDelete(prescription.getId());     //Delete related prescribed drugs
                PrescriptionList.getInstance().getList().remove(prescription);
                i--;    //Size decreases by 1, so index also decreases by 1
            }

        }
    }
}
