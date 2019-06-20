package rmit.SADI.ListToString;

import rmit.SADI.CoreDatabase.Patient;
import rmit.SADI.CoreDatabase.PrescribedDrug;
import rmit.SADI.CoreDatabase.Prescription;
import rmit.SADI.CoreDatabase.Visit;

import java.util.List;

public class ListToString {
    //VisitList
    public static String VisitList(List<Visit> visits){
        StringBuilder sb = new StringBuilder("                                                                        List of visits" +
                "\n___________________________________________________________________________________\n");
        if (visits.size() == 0)
            sb.append("It's empty. Almost too empty ... \n");
        else {
            for (Visit visit:visits) {
                sb.append(visit + "\n\n");
            }
        }
        return sb.toString();
    }

    //PrescribedDrugList
    public static String PrescribedDrugList(List<PrescribedDrug> drugList){
        StringBuilder sb = new StringBuilder("                                                                List of prescribed drugs" +
                "\n___________________________________________________________________________________\n");
        if (drugList.size() == 0)
            sb.append("It's empty. Almost too empty ... \n");
        else {
            for (PrescribedDrug prescribedDrug : drugList) {
                sb.append(prescribedDrug + "\n");
            }
        }
        return sb.toString();
    }

    //PatientList
    public static String PatientList(List<Patient> patientList){
        StringBuilder sb = new StringBuilder("                                                                      List of patients" +
                "\n___________________________________________________________________________________\n");
        if (patientList.size() == 0)
            sb.append("It's empty. Almost too empty ... \n");
        else {
            for (Patient patient:patientList) {
                sb.append(patient + "\n");
            }
        }
        return sb.toString();
    }

    //PrescriptionList
    public static String PrescriptionList(List<Prescription> prescriptionList){
        StringBuilder sb = new StringBuilder("                                                                   List of prescriptions"+
                "\n___________________________________________________________________________________\n");
        if (prescriptionList.size() == 0)
            sb.append("It's empty. Almost too empty ... \n");
        else {
            for (Prescription prescription:prescriptionList) {
                sb.append(prescription + "                                                                   ~~~~~~~~~~~~~~\n");
            }
        }
        return sb.toString();
    }
}
