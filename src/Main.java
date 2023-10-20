package src;

import src.timeCalculations.TimeCalculations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeCalculations calculator = new TimeCalculations();

        // Input the number of tanks and the rate of water filling
        int numberOfTanks = scanner.nextInt();
        // Converting the input flow rate into multiples of 0.5 seconds - inorder to find the exact second in which the tank gets filled
        int k = scanner.nextInt();
        double waterFlowRate = (double) k / 2;
        // Initialize variables to track the time and water levels in tanks
        double[] waterLevels = new double[numberOfTanks];
        double[] capacities = new double[numberOfTanks];

        // Validate boundary conditions
        if (numberOfTanks < 1 || numberOfTanks > 100000) {
            System.out.println("Invalid number of tanks");
            scanner.close();
            return;
        }

        if (k < 1 || k > 100000) {
            System.out.println("Invalid water flow rate");
            scanner.close();
            return;
        }

        // Input the capacities of each tank
        for (int i = 0; i < numberOfTanks; i++) {
            capacities[i] = scanner.nextInt();
        }
        scanner.close();

        // Calculate timeToAllFull recursively
        double timeToAllFull = calculator.calculateTimeToAllFull(capacities, waterFlowRate, numberOfTanks-1, 0, 0);
        double time = calculator.fillTanks(waterLevels, capacities, waterFlowRate, numberOfTanks-1, 0);

        // Using floor function to get the whole integer part of the double value
        // Using String format %0.f to format the output
        System.out.println("Time taken for the last tank to fill: " +  String.format("%.0f",Math.floor(time/2)) + " seconds");
        System.out.println("Time taken for all the tanks to fill: "  +  String.format("%.0f",Math.floor(timeToAllFull/2))+ " seconds");

    }
}
