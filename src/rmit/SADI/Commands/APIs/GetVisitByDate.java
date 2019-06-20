package rmit.SADI.Commands.APIs;

import rmit.SADI.Commands.Command;
import rmit.SADI.CoreDatabase.Visit;
import rmit.SADI.CoreDatabase.VisitList;
import rmit.SADI.ListToString.ListToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GetVisitByDate implements Command {
    private VisitList visitList = VisitList.getInstance();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Singleton
    private static GetVisitByDate instance  = new GetVisitByDate();
    private GetVisitByDate(){}
    public static GetVisitByDate getInstance() {
        return instance;
    }

    //Core method
    private List<Visit> getVisitByDate(Date date){
        List<Visit> found = new ArrayList<>();
        for (Visit visit:visitList.getList()) {
            if (visit.getDate().compareTo(date) == 0){
                found.add(visit);
            }
        }
        return found;
    }

    @Override
    public void execute() {
        Date date;
        Scanner s = new Scanner(System.in);
        System.out.println("***Get visits by Date***");
        System.out.print("Search for Date (dd-mm-yyyy): ");
        try {
            date = dateFormat.parse(s.nextLine());
            List<Visit> found = getVisitByDate(date);
            if ( found.size() == 0)
                System.out.println("\nNo visit. Must be doctors' holiday :)\n");
            else
                System.out.println(ListToString.VisitList(found));
        } catch (ParseException e) {
            System.out.println("\nInput: invalid!\n");
        }
    }
}
