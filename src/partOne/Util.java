package partOne;

import java.util.Map;

public class Util {

    public static int getYearWithHighestEmissions(Country country) {
        Map<Integer, Emission> emissionMap = country.getEmissions();

        //initialize variables to keep track of the highest total emission and their corresponding year
        double highestTotalEmission = 0.0;
        int yearWithHighestEmission = 0;

        //loop through each emission and its emission data
        for(Integer year : emissionMap.keySet()) {
            //get the emissions data for the current year
            Emission emission = emissionMap.get(year);

            //get the emissions for Co2, N2O and CH4
            double co2Emission = emission.getCo2();
            double n20Emission = emission.getN20();
            double ch4Emission = emission.getCh4();

            double totalEmission = co2Emission + n20Emission + ch4Emission;

            // Check if the total emissions for this year are higher than the highest found so far
            if (totalEmission > highestTotalEmission) {
                // Update the highest total emissions
                highestTotalEmission = yearWithHighestEmission;

                // Update the year with the highest total emissions
                yearWithHighestEmission = year;

            }
        }
        return yearWithHighestEmission;
    }


    public static int getYearWithHighestEmissions(Sector sector) {
        Map<Integer, Double> emissions  = sector.getEmissions();

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
}
