package rmit.SADI.Commands.PrescriptionCRUD;

import rmit.SADI.Commands.Command;
import rmit.SADI.Commands.PrescribedDrugCRUD.NewPrescribedDrug;
import rmit.SADI.Commands.VisitCRUD.GetVisitByID;
import rmit.SADI.CoreDatabase.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewPrescription implements Command {
    //Singleton
    private static NewPrescription instance = new NewPrescription();
    private NewPrescription(){}
    public static NewPrescription getInstance() {
        return instance;
    }

    //Core method
    public Prescription createPrescription(){
        Prescription prescription = new Prescription();
        Scanner s = new Scanner(System.in);
        try{
            System.out.print("Enter Visit ID: ");
            int visitID = s.nextInt();
            Visit visit = GetVisitByID.getInstance().getVisitByID(visitID);
            s.nextLine(); //Get the Enter key out of the Scanner4
            if (visit == null){
                System.out.println("No such visit.\n");
                return null;
            }
            prescription.setVisit(visit);

            System.out.print("Enter diagnosis: ");
            prescription.setDiagnosis(s.nextLine());

            System.out.print("No. of drugs to be prescribed: ");
            byte numberOfDrugs = s.nextByte();
            System.out.println();
            for (byte i = 0; i < numberOfDrugs; i++) {
                System.out.println("Drug no." + (i+1) +":");
                PrescribedDrug prescribedDrug = NewPrescribedDrug.getInstance().createPrescribedDrug();
                if (prescribedDrug == null){
                    i--; //Keep iterating until we get a valid one
                    System.out.println();
                    continue;
                }
                else {
                    prescribedDrug.setPrescriptionID(PrescriptionList.getInstance().getList().size()+1);
                    prescription.addMedicine(prescribedDrug);
                    PrescribedDrugList.getInstance().getList().add(prescribedDrug);
                    System.out.println();
                }
            }

        }catch (InputMismatchException e){
            System.out.println("Input: Invalid!");
            System.out.println();
            return null;
        }
        return prescription;
    }

    @Override
    public void execute() {
        Prescription prescription = createPrescription();
        if (prescription != null){
            prescription.setId(PrescriptionList.getInstance().getList().size()+1);
            PrescriptionList.getInstance().getList().add(prescription);
        }
    }
}
