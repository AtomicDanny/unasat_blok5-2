package sr.unasat.ride.template;

public abstract class payment {

    double afhandelingskosten;

    payment(){}

    public boolean payments(){
        SelectieBerichtTonen();
//        AfhandelingBerichtTonen();
        return false;
    }

    abstract void SelectieBerichtTonen();
//    abstract void AfhandelingBerichtTonen();
}
