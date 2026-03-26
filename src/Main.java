import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
This class is designed to handle the input the user, read the Stardew Vally crop data from a file (still to be implemented),
and calculate the profit that the user will make from their planted crops in a season. Currently, this program assumes
that the use will continue to plant the same crop in the same plot after each harvest for the entire season.
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\t===== Stardew Valley Crop Calculator =====\n");

        ArrayList<String[]> cropsPlanted = new ArrayList<>();
        cropsPlanted = getCropsPlanted();

        printCropValues(cropsPlanted);

    }

    /*
    This method prompts the user for input. It then fetches the user input and returns it as a string in a double
    ArrayList where the first column contains the crop name and the second column contains the number of plots that
    have that crop planted in them.
    */
    public static ArrayList<String[]> getCropsPlanted(){
        Scanner input = new Scanner(System.in);
        ArrayList<String[]> cropQuantity = new ArrayList<>();
        String text = "";
        System.out.printf("%35s%n", "---- Crop Quantities ----");
        System.out.println("\tPlease enter the crop name and quantity planted\n\tseperated by a comma with no spaces.\n\tEnter 'done' when finished.");
        System.out.println();

        while(true){
            System.out.print("Crop name, amount planted (corn,14): ");
            text = input.nextLine();

            if (text.equalsIgnoreCase("done")) {                 //Checks if the user has
                break;                                                      //typed the quit command.
            }

            cropQuantity.add(text.split(","));                        //Adds input as 2 index array to ArrayList.
        }

        return cropQuantity;
    }

    /*
    This is the calculation method. Using the ArrayList returned by the getCropsPlanted method it will calculate the
    net profit for each crop type over the course of a season. First the code calculates the net income from the planted
    crops, then it subtracts the cost of seeds. Next it multiplies this value by the number of harvests each crop will
    have per season and returns the values in a multidimensional ArrayList.
     */
    public static ArrayList<String[]> calculateProfits(ArrayList<String[]> cropQuantity){
        return null; //placeholder
    }


    /*
    This method takes the ArrayList from getCropsPlanted and calculates the values for each crop per harvest and prints
    the crop names and the value base value they will sell for to the terminal. This method will need to be split into
    a value calculation method (above) and print method. The calculation method will also take the number of harvests each crop
    has per season and the cost of the seeds to return a net profit value per season.
     */

    public static void printCropValues(ArrayList<String[]> numCrops){
        ArrayList<String[]> basePrices = new ArrayList<>();
        basePrices.add(new String[] {"potato", "88"});
        basePrices.add(new String[] {"kale", "121"});
        basePrices.add(new String[] {"garlic", "66"});

        ArrayList<Integer> harvestValue = new ArrayList<>();

        for (String[] row : numCrops) {
            int value;
            int quantity;
            String cropName = row[0];

            for(int i = 0; i < basePrices.size(); i++) {
                if (cropName.equals(basePrices.get(i)[0])) {
                    value = Integer.parseInt(basePrices.get(i)[1]);
                    quantity = Integer.parseInt(row[1]);
                    harvestValue.add(value * quantity);
                }
            }


        }

        System.out.println();
        System.out.printf("%35s%n", "---- Crop Values ----");
        for(int i = 0; i < numCrops.size(); i++){
            System.out.println(numCrops.get(i)[0] + ": " + harvestValue.get(i));


        }
    }
}