package rmit.SADI.CoreDatabase;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit implements Serializable {
    private int id;
    private Patient patient;
    private Date date;
    private String problems;

    //Make Date more intuitive
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Setters
    public void setDate(String date) {
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Input: invalid!\n");
        }
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Getters
    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public Patient getPatient() {
        return patient;
    }
    public String getProblems() {
        return problems;
    }

    //toString
    @Override
    public String toString() {
        return date==null?null:patient + "\nVisit\t\t\tID: " + id + ", Date: " + dateFormat.format(date) + " ||     Problems: " + problems;
    }
}
