package src.timeCalculations;

public class TimeCalculations {
    // Calculate time taken to fill all the tanks
    public double calculateTimeToAllFull(double[] capacities, double waterFlowRate, int lastTank, int currentIndex, double currentFlow) {
        if (waterFlowRate <= 0.0) {
            System.out.println("Water flow rate value need to be greater than 0.0");
            return -1.0;
        }

        if (lastTank <= 0) {
            System.out.println("Last tank value need to be greater than 0");
            return -1.0;
        }

        double timeToFillCurrent = (capacities[currentIndex] - currentFlow) / waterFlowRate;
        if (currentIndex == lastTank) {
            return timeToFillCurrent;
        }
        double timeToFillNext = calculateTimeToAllFull(capacities, waterFlowRate, lastTank, currentIndex + 1, currentFlow + waterFlowRate);
        return Math.max(timeToFillCurrent, timeToFillNext);
    }

    // Calculate time taken to fill the last tank
    public double fillTanks(double[] waterLevels, double[] capacities, double waterFlowRate, int lastTank, double time) {
        boolean isLastTankFull = true;
        if (waterFlowRate <= 0.0) {
            System.out.println("Water flow rate value need to be greater than 0.0");
            return -1.0;
        }

        if (lastTank <= 0) {
            System.out.println("Last tank value need to be greater than 0");
            return -1.0;
        }

        if (capacities.length == 0) {
            System.out.println("Capacity cannot be empty");
            return -1.0;
        }

        if (waterLevels.length == 0) {
            System.out.println("Water levels cannot be empty");
            return -1.0;
        }

        for (int i = 0; i < waterLevels.length; i++) {
            double overflow = waterLevels[i] - capacities[i] + waterFlowRate;
            if (overflow > 0) {
                waterLevels[i] = capacities[i];
                if (i < lastTank) {
                    waterLevels[i + 1] += overflow;
                }
            } else {
                waterLevels[i] += waterFlowRate;
            }
            // Last tank is full once it reaches the capacity
            if (waterLevels[lastTank] < capacities[lastTank]) {
                isLastTankFull = false;
            }
        }
        if (isLastTankFull)
            return time;
        else
            return fillTanks(waterLevels, capacities, waterFlowRate, lastTank, time + 1);
    }
}
