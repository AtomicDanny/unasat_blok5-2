package sr.unasat.ride.decorator;

abstract public class CarDecorator implements Car{
    protected Car tempCar;

    public CarDecorator(Car newCar){
        this.tempCar =newCar;
    }

    @Override
    public String getModel() {
        return tempCar.getModel();
    }

    @Override
    public double getPrijs() {
        return tempCar.getPrijs();
    }
}
