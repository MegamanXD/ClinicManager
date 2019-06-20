package rmit.SADI.CoreDatabase;

import rmit.SADI.ListToString.ListToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrescribedDrugList implements Serializable {
    private List<PrescribedDrug> prescribedDrugList = new ArrayList<>();

    //Singleton
    private static PrescribedDrugList instance = new PrescribedDrugList();
    private PrescribedDrugList(){}
    public static PrescribedDrugList getInstance() {
        return instance;
    }

    //Setters
    public void setList(List<PrescribedDrug> prescribedDrugList) {
        this.prescribedDrugList = prescribedDrugList;
    }
    public static void setInstance(PrescribedDrugList instance) {
        PrescribedDrugList.instance = instance;
    }

    //Getters
    public List<PrescribedDrug> getList() {
        return prescribedDrugList;
    }

    //toString
    @Override
    public String toString () {
        return ListToString.PrescribedDrugList(prescribedDrugList);
    }
}
