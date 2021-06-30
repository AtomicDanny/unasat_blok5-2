package sr.unasat.ride.decorator;

public class Paraphernalia extends CarDecorator {

    final double prijs = 50;

    public Paraphernalia (Car newCar){
        super(newCar);
//        System.out.println();
    }


    @Override
    public String getModel() {
        return tempCar.getModel() + ", Paraphernalia";
    }

    @Override
    public double getPrijs() {
        return tempCar.getPrijs() + prijs;
    }
}
