package rmit.SADI.CoreDatabase;

import rmit.SADI.ListToString.ListToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientList implements Serializable {
    private List<Patient> patientList = new ArrayList<>();

    //Singleton
    private static PatientList instance = new PatientList();
    private PatientList() {}
    public static PatientList getInstance() {
        return instance;
    }

    //Setters
    public void setList(List<Patient> patientList) {
        this.patientList = patientList;
    }
    public static void setInstance(PatientList instance) {
        PatientList.instance = instance;
    }

    //Getters
    public List<Patient> getList() {
        return patientList;
    }

    //toString
    @Override
    public String toString() {
        return ListToString.PatientList(patientList);
    }
}
