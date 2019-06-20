package rmit.SADI.Commands.PrescribedDrugCRUD;

import rmit.SADI.CoreDatabase.PrescribedDrug;
import rmit.SADI.CoreDatabase.PrescribedDrugList;
import rmit.SADI.CoreDatabase.Prescription;
import rmit.SADI.CoreDatabase.PrescriptionList;

public class DeletePrescribedDrug {
    //Singleton
    private static DeletePrescribedDrug instance = new DeletePrescribedDrug();
    private DeletePrescribedDrug(){}
    public static DeletePrescribedDrug getInstance() {
        return instance;
    }

    //Core method
    public void autoDelete(int prescriptionID){
        for (int i = 0; i < PrescribedDrugList.getInstance().getList().size(); i++) {
            PrescribedDrug prescribedDrug = PrescribedDrugList.getInstance().getList().get(i);
            if (prescribedDrug.getPrescriptionID() == prescriptionID){
                PrescribedDrugList.getInstance().getList().remove(prescribedDrug);
                i--;    //Size decreases by 1, so index also decreases by 1
            }
        }
    }
}
