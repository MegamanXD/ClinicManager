package rmit.SADI.CoreDatabase;

import java.io.Serializable;

public class PrescribedDrug implements Serializable {
    private int prescriptionID;
    private String drugName, dose, howToUse;
    private byte quantity;

    //Setters
    public void setPrescriptionID(int prescriptionID) { this.prescriptionID = prescriptionID; }
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
    public void setDose(String dose) {
        this.dose = dose;
    }
    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }
    public void setQuantity(byte quantity) {
        this.quantity = quantity;
    }

    //Getters
    public int getPrescriptionID() { return prescriptionID; }
    public String getDrugName() {
        return drugName;
    }
    public String getDose() {
        return dose;
    }
    public String getHowToUse() {
        return howToUse;
    }
    public byte getQuantity() {
        return quantity;
    }

    //toString
    @Override
    public String toString() {
        return "Name: " + drugName + ", Quantity: " + quantity + ", Dose: " + dose + ", How To Use: " + howToUse +
                " ||     Prescription ID: " + prescriptionID;
    }
}
