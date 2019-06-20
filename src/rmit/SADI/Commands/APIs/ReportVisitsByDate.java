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

public class ReportVisitsByDate implements Command {
    private VisitList visitList = VisitList.getInstance();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Singleton
    private static ReportVisitsByDate instance = new ReportVisitsByDate();
    private ReportVisitsByDate(){}
    public static ReportVisitsByDate getInstance() {
        return instance;
    }

    //Core method
    private void countVisit(Date date){
        int found=0;
        List<Visit> matches = new ArrayList<>();

        for (Visit visit:visitList.getList()) {
            if (visit.getDate().compareTo(date) == 0){
                found++;
                matches.add(visit);
            }
        }
        System.out.println("\nNo. of visits on " + dateFormat.format(date) + " found = "+ found);
        if (found>0)
            System.out.println(ListToString.VisitList(matches));
    }

    @Override
    public void execute() {
        Date date;
        Scanner s = new Scanner(System.in);
        System.out.println("***Report of visits by Date***");
        System.out.print("Input Date (dd-mm-yyyy): ");
        try {
            date = dateFormat.parse(s.nextLine());
            countVisit(date);
        } catch (ParseException e) {
            System.out.println("\nInput: invalid!");
            System.out.println();
        }
    }
}
