package rmit.SADI.Commands.VisitCRUD;

import rmit.SADI.CoreDatabase.Visit;
import rmit.SADI.CoreDatabase.VisitList;

public class DeleteVisit{
    //Singleton
    private static DeleteVisit instance = new DeleteVisit();
    private DeleteVisit(){}
    public static DeleteVisit getInstance() {
        return instance;
    }

    //Core method
    public void autoDelete(int patientID){
        for (int i = 0; i < VisitList.getInstance().getList().size(); i++) {
            Visit visit = VisitList.getInstance().getList().get(i);
            if(visit.getPatient().getId() == patientID){
                VisitList.getInstance().getList().remove(visit);
                i--;    //Size decreases by 1, so index also decreases by 1
            }

        }
    }
}
