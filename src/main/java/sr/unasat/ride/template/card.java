package sr.unasat.ride.template;

public class card extends payment{

    final double afhandelingskosten =2.5;

    public card(){

    }

    @Override
    void SelectieBerichtTonen() {
        System.out.println("U heeft voor card gekozen");
    }

//    @Override
//    void AfhandelingBerichtTonen() {
//        System.out.println("De afhandelings kosten zijn: SRD " + afhandelingskosten);
//    }
}
