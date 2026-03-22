import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\t===== Stardew Valley Crop Calculator =====\n");

        ArrayList<String[]> cropsPlanted = new ArrayList<>();
        cropsPlanted = getCropsPlanted();

        //Test to see if input is read and correctly added to the arraylist
        for (String[] row : cropsPlanted) {
            System.out.println(Arrays.toString(row));
        }

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
}