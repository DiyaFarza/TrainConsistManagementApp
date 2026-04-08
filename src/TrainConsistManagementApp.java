import java.util.ArrayList;
import java.util.List;

// Base class for all bogies
abstract class Bogie {
    String id;

    public Bogie(String id) {
        this.id = id;
    }

    abstract void displayDetails();
}

// Passenger Bogie
class PassengerBogie extends Bogie {
    String type;
    int capacity;

    public PassengerBogie(String id, String type, int capacity) {
        super(id);
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    void displayDetails() {
        System.out.println("Passenger Bogie -> ID: " + id +
                ", Type: " + type +
                ", Capacity: " + capacity);
    }
}

// Goods Bogie
class GoodsBogie extends Bogie {
    String shape;
    String cargoType;

    public GoodsBogie(String id, String shape, String cargoType) {
        super(id);
        this.shape = shape;
        this.cargoType = cargoType;
    }

    @Override
    void displayDetails() {
        System.out.println("Goods Bogie -> ID: " + id +
                ", Shape: " + shape +
                ", Cargo: " + cargoType);
    }
}

// Train class
class Train {
    String trainName;
    List<Bogie> bogies;

    public Train(String trainName) {
        this.trainName = trainName;
        bogies = new ArrayList<>();
    }

    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
    }

    public void displayConsist() {
        System.out.println("Train Name: " + trainName);
        System.out.println("Total Bogies: " + bogies.size());
        System.out.println("---- Consist Details ----");

        for (Bogie b : bogies) {
            b.displayDetails();
        }
    }
}

// Main Application
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Initialize Train
        Train train = new Train("Express 101");

        // Add Passenger Bogies
        train.addBogie(new PassengerBogie("P1", "Sleeper", 72));
        train.addBogie(new PassengerBogie("P2", "AC Chair", 50));

        // Add Goods Bogies
        train.addBogie(new GoodsBogie("G1", "Rectangular", "Coal"));
        train.addBogie(new GoodsBogie("G2", "Cylindrical", "Oil"));

        // Display Summary
        train.displayConsist();
    }
}
