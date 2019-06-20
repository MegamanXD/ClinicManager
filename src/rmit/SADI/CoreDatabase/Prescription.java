package rmit.SADI.CoreDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Prescription implements Serializable {
    private int id;
    private Visit visit;
    private String diagnosis;
    private List<PrescribedDrug> drugs = new ArrayList<>();

    //Setters
    public void setId(int id) { this.id = id; }
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public void addMedicine(PrescribedDrug drug) { this.drugs.add(drug);}

    //Getters
    public int getId() { return id; }
    public Visit getVisit() {
        return visit;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public List<PrescribedDrug> getPrescribedDrug() {
        return drugs;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("                                                                   ***Background***" +
                "\n---------------------------------------------------------------------------------------------------------------\n"
                 + visit + "\nDiagnosis              " + diagnosis + "\n---------------------------------------------------------------------------------------------------------------\n" +
                "                                                                     ***Medicine***\n");
        if (drugs.size() == 0)
            sb.append("It's empty. Almost too empty ... \n");
        else {
            for (PrescribedDrug prescribedDrug : drugs) {
                sb.append(prescribedDrug + "\n");
            }
        }
        return  sb.toString();
    }
}
