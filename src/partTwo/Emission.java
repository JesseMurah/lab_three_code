package partTwo;

public class Emission {
    //create the fields to represent the emission in kilo-tons
    private double co2;
    private double n20;
    private double ch4;

    //constructor to take double values for the co2, no2 & ch4
    public Emission(double co2, double n20, double ch4) {
        this.co2 = co2;
        this.n20 = n20;
        this.ch4 = ch4;
    }

    //Getters for the following fields


    public double getCo2() {
        return co2;
    }

    public double getN20() {
        return n20;
    }

    public double getCh4() {
        return ch4;
    }
}
