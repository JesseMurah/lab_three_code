package partTwo;

import java.util.List;
import java.util.Map;

public class Sector {

    private String name;
    private Map<Integer, Double> emissions;


    public Sector(String name, Map<Integer, Double> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Double> getEmissions() {
        return emissions;
    }

    public int getYearWithHighestEmissions() {
        //Map<Integer, Double> emissions  = sector.getEmissions();

        //initialize variables to keep track of the highest emission value and their corresponding year
        double highestEmission = 0.0;
        int yearWithHighestEmission = 0;

        //Loop through each entry in the emissions map
        for (Map.Entry<Integer, Double> entry : emissions.entrySet()) {
            int year = entry.getKey();
            double emissionValue = entry.getValue();

            //check if the emission value is greater than the highest emission
            if (emissionValue > highestEmission) {
                highestEmission = emissionValue;
                emissionValue = year;
            }
        }
        //return year with the highest emission value
        return yearWithHighestEmission;
    }

    public static Sector sectorWithBiggestChangeInEmissions(List<Sector> sectors, int startYear, int endYear) {

    }
}
