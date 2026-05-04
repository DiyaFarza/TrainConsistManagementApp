import java.util.*;
import java.util.stream.*;

// Model class for Goods Bogie
class GoodsBogie {
    private String type;   // Cylindrical, Open, Box
    private String cargo;  // Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Cargo: " + cargo;
    }
}

// Main Application
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Create list of goods bogies
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain"),
                new GoodsBogie("Cylindrical", "Petroleum")
        );

        // Step 2: Display bogies
        System.out.println("=== Goods Bogies List ===");
        bogies.forEach(System.out::println);

        // Step 3: Safety Validation using Streams
        boolean isSafe = bogies.stream()
                .allMatch(bogie ->
                        !bogie.getType().equalsIgnoreCase("Cylindrical")
                                || bogie.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Step 4: Display Result
        System.out.println("\n=== Safety Check Result ===");
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }

        // Step 5: Continue program
        System.out.println("\nProgram execution completed.");
    }
}
