package sr.unasat.ride.decorator;

public class Insurance extends CarDecorator {

    final double prijs = 300;

    public Insurance (Car newCar){
        super(newCar);
//        System.out.println();
    }


    @Override
    public String getModel() {
        return tempCar.getModel() + ",Insurance";
    }

    @Override
    public double getPrijs() {
        return tempCar.getPrijs() + prijs;
    }
}
