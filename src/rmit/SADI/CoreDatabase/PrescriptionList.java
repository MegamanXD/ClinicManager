package rmit.SADI.CoreDatabase;

import rmit.SADI.ListToString.ListToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionList implements Serializable {
    private List<Prescription> prescriptionList = new ArrayList<>();

    //Singleton
    private static PrescriptionList instance = new PrescriptionList();
    private PrescriptionList(){};
    public static PrescriptionList getInstance() {
        return instance;
    }

    //Setters
    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
    public static void setInstance(PrescriptionList instance) { PrescriptionList.instance = instance; }

    //Getters
    public List<Prescription> getList() {
        return prescriptionList;
    }

    //toString
    @Override
    public String toString() {
        return ListToString.PrescriptionList(prescriptionList);
    }
}
