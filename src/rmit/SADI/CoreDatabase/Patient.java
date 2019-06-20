package rmit.SADI.CoreDatabase;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient implements Serializable {
    private int id;
    private String name, address,gender;
    private Date birthdate;

    //Make Date more intuitive
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }

    public void setBirthdate(String birthdate) {
        try {
            this.birthdate = dateFormat.parse(birthdate);
        } catch (ParseException e) {
            System.out.println("Input: invalid!");
        }
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male"))
            this.gender = gender;
        else{
            System.out.println("Wrong gender inputted. Set gender to: null");
            this.gender = null;
        }
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public String getGender() {
        return gender;
    }

    //toString
    @Override
    public String toString() {
        return birthdate==null ?null:"Patient\t\tID: " + id + ", Name: " + name + ", Birthdate: " + dateFormat.format(birthdate) +
                " ||     Address: " + address + ", Gender: " + gender;
    }
}
