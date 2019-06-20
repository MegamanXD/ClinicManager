package rmit.SADI.FileInputOutput;

import rmit.SADI.CoreDatabase.PatientList;
import rmit.SADI.CoreDatabase.PrescribedDrugList;
import rmit.SADI.CoreDatabase.PrescriptionList;
import rmit.SADI.CoreDatabase.VisitList;

import java.io.*;

public class FileIO {
    //Export
    public static void exportPatientList(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("PatientList.heo"));
            outputStream.writeObject(PatientList.getInstance());
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error writing PatientList!");
            e.printStackTrace();
        }
    }

    public static void exportVisitList(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("VisitList.heo"));
            outputStream.writeObject(VisitList.getInstance());
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error writing VisitList!");
        }
    }

    public static void exportPrescribedDrugList(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("PrescribedDrugList.heo"));
            outputStream.writeObject(PrescribedDrugList.getInstance());
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error writing PrescribedDrugList!");
        }
    }

    public static void exportPrescriptionList(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("PrescriptionList.heo"));
            outputStream.writeObject(PrescriptionList.getInstance());
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error writing PrescriptionList!");
        }
    }

    public static void export(){
        exportPatientList();
        exportVisitList();
        exportPrescriptionList();
        exportPrescribedDrugList();
    }

    //Import
    public static void readPatientList(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("PatientList.heo"));
            PatientList.setInstance((PatientList) inputStream.readObject());
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading PatientList!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error reading PatientList!");
        }
    }

    public static void readVisitList(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("VisitList.heo"));
            VisitList.setInstance((VisitList) inputStream.readObject());
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading VisitList!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error reading VisitList!");
        }
    }

    public static void readPrescribedDrugList(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("PrescribedDrugList.heo"));
            PrescribedDrugList.setInstance((PrescribedDrugList) inputStream.readObject());
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading PrescribedDrugList!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error reading PrescribedDrugList!");
        }
    }

    public static void readPrescriptionList(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("PrescriptionList.heo"));
            PrescriptionList.setInstance((PrescriptionList) inputStream.readObject());
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading PrescriptionList!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error reading PrescriptionList!");
        }
    }

    public static void read(){
        readPatientList();
        readVisitList();
        readPrescriptionList();
        readPrescribedDrugList();
    }
}
