package partTwo;

import java.time.Year;
import java.util.List;
import java.util.Map;

public class Country {

    private String name;
    private Map<Integer, Emission> emissions;

    public Country(String name, Map<Integer, Emission> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    //getter for the fields

    public String getName() {
        return name;
    }

    public Map<Integer, Emission> getEmissions() {
        return emissions;
    }


    public int getYearWithHighestEmissions() {
        //Map<Integer, Emission> emissionMap = country.getEmissions();

        //initialize variables to keep track of the highest total emission and their corresponding year
        double highestTotalEmission = 0.0;
        int yearWithHighestEmission = 0;

        //loop through each emission and its emission data
        for(Integer year : emissions.keySet()) {
            //get the emissions data for the current year
            Emission emission = emissions.get(year);

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

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year){
        Country highestCH4EmissionCountry = null;
        double highestCH4Value = 0.0;


        for(Country country : countries) {
            Emission emission = country.getYearWithHighestEmissions(year);
            double CH4Emission = emission.getCh4();
            if(CH4Emission > highestCH4Value) {
                highestCH4Value = CH4Emission;
                highestCH4EmissionCountry = country;
            }
        }
        return highestCH4EmissionCountry;
    }

    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear) {
        Country highestChangeCountry = null;
        double highestChangeValue = 0.0;

        for (Country country: countries){
            Emission emissionYear1 = country.getYearWithHighestEmissions(startYear);
            Emission emissionYear2 = country.getYearWithHighestEmissions(endYear);

            if (emissionYear1!= null && emissionYear2!= null){
                double totalEmissionsYear1 = emissionYear1.getCo2()+emissionYear1.getCh4()+ emissionYear1.getN20();
                double totalEmissionsYear2 = emissionYear2.getCo2()+emissionYear2.getCh4()+ emissionYear2.getN20();

                double changeInEmissions = totalEmissionsYear2 - totalEmissionsYear1;

                if(changeInEmissions> highestChangeValue){
                    highestChangeValue = changeInEmissions;
                    highestChangeCountry = country;
                }
            }
        }

        if (highestChangeCountry!= null){
            System.out.println("Country with the highest change in emissions is:  "+ highestChangeCountry.getName());
            System.out.println("Change in emissions: "+ highestChangeValue);

        }
        return highestChangeCountry;
    }

}
}
