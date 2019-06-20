package rmit.SADI.Commands.VisitCRUD;

import rmit.SADI.CoreDatabase.Visit;
import rmit.SADI.CoreDatabase.VisitList;

public class GetVisitByID {
    private VisitList visitList = VisitList.getInstance();

    //Singleton
    private static GetVisitByID instance = new GetVisitByID();
    private GetVisitByID(){}
    public static GetVisitByID getInstance() {
        return instance;
    }

    //Core Method
    public Visit getVisitByID(int id){          //Usually each person is given a different ID
        for (Visit visit:visitList.getList()){
            if (visit.getId() == id)
                return visit;
        }
        return null;
    }
}
