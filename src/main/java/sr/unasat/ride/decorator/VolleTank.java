package sr.unasat.ride.decorator;

public class VolleTank extends CarDecorator{
    final double prijs = 100;

    public VolleTank (Car newCar){
        super(newCar);
//        System.out.println();
    }


    @Override
    public String getModel() {
        return tempCar.getModel() + ", Volle Tank";
    }

    @Override
    public double getPrijs() {
        return tempCar.getPrijs() + prijs;
    }
}
