import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\t===== Stardew Valley Crop Calculator =====\n");

        ArrayList<String[]> cropsPlanted = new ArrayList<>();
        cropsPlanted = getCropsPlanted();

        printCropValues(cropsPlanted);

    }

    public static ArrayList<String[]> getCropsPlanted(){
        Scanner input = new Scanner(System.in);
        ArrayList<String[]> cropQuantity = new ArrayList<>();
        String text = "";
        int i = 0;
        System.out.printf("%35s%n", "---- Crop Quantities ----");
        System.out.println("\tPlease enter the crop name and quantity planted\n\tseperated by a comma with no spaces.\n\tEnter 'done' when finished.");
        System.out.println();

        while(true){
            System.out.print("Crop name, amount planted (corn,14): ");
            text = input.nextLine();

            if (text.equalsIgnoreCase("done")) {
                break;
            }

            cropQuantity.add(text.split(","));
        }

        return cropQuantity;
    }

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

        for(int i = 0; i < numCrops.size(); i++){
            System.out.println(numCrops.get(i)[0] + ": " + harvestValue.get(i));


        }
    }
}