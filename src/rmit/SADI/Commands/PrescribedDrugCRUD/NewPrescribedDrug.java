package rmit.SADI.Commands.PrescribedDrugCRUD;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.PrescribedDrug;
import rmit.SADI.CoreDatabase.PrescribedDrugList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewPrescribedDrug implements Command {
    //Singleton
    private static NewPrescribedDrug instance = new NewPrescribedDrug();
    private NewPrescribedDrug(){}
    public static NewPrescribedDrug getInstance() {
        return instance;
    }

    //Core method
    public PrescribedDrug createPrescribedDrug(){
        PrescribedDrug prescribedDrug = new PrescribedDrug();
        Scanner s = new Scanner(System.in);
        System.out.print("Name of drug: ");
        prescribedDrug.setDrugName(s.nextLine());
        System.out.print("Quantity: ");
        try {
            prescribedDrug.setQuantity(s.nextByte());
        }catch (InputMismatchException e){
            System.out.println("Input: invalid!");
            return null;
        }finally {
            s.nextLine(); //Get the Enter key out of the Scanner
        }
        System.out.print("Dose: ");
        prescribedDrug.setDose(s.nextLine());
        System.out.print("How to use: ");
        prescribedDrug.setHowToUse(s.nextLine());
        return prescribedDrug;
    }

    @Override
    public void execute() {
        PrescribedDrug prescribedDrug = createPrescribedDrug();
        System.out.println();
        if (prescribedDrug != null)
            PrescribedDrugList.getInstance().getList().add(prescribedDrug);
    }
}
