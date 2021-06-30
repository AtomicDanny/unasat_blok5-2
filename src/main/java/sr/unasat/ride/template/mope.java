package sr.unasat.ride.template;

public class mope extends payment{

    final double afhandelingskosten = 10;

    public mope(){

    }

    @Override
    void SelectieBerichtTonen() {
        System.out.println("U heeft voor MOPE gekozen");
    }

//    @Override
//    void AfhandelingBerichtTonen() {
//        System.out.println("De afhandelings kosten zijn: SRD " + afhandelingskosten);
//    }
}
