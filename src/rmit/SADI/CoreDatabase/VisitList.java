package rmit.SADI.CoreDatabase;

import rmit.SADI.ListToString.ListToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisitList implements Serializable {
    private List<Visit> visits = new ArrayList<>();

    //Singleton
    private static VisitList instance = new VisitList();
    private VisitList(){}
    public static VisitList getInstance() {
        return instance;
    }

    //Setters
    public void setList(List<Visit> visits) {
        this.visits = visits;
    }

    public static void setInstance(VisitList instance) {
        VisitList.instance = instance;
    }

    //Getters
    public List<Visit> getList() {
        return visits;
    }

    //toString
    @Override
    public String toString() {
        return ListToString.VisitList(visits);
    }
}
