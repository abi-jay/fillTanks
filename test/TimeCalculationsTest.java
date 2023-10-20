package test;

import org.junit.Test;
import src.timeCalculations.TimeCalculations;

import static org.junit.Assert.*;

public class TimeCalculationsTest {

    @Test
    public void calculateTimeToAllFullForInput1() {
        //Given
        double[] capacities = {30, 3, 7, 20};
        double waterFlowRate = 1;
        int numberOfTank = 4;
        double expected = 30;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.calculateTimeToAllFull(capacities, waterFlowRate, numberOfTank - 1, 0, 0);

        //Then
        assertEquals(0, Double.compare(expected, actual));
    }

    @Test
    public void calculateTimeToAllFullForInput2() {
        //Given
        double[] capacities = {4, 6};
        double waterFlowRate = 2;
        int numberOfTank = 2;
        double expected = 2;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.calculateTimeToAllFull(capacities, waterFlowRate, numberOfTank - 1, 0, 0);

        //Then
        assertEquals(0, Double.compare(expected, actual));
    }

    @Test
    public void calculateTimeToAllFullForInput3() {
        //Given
        double[] capacities = {100000000, 99999999, 10000000, 1000000, 900000, 90000, 9000, 800, 80, 777};
        double waterFlowRate = 7;
        int numberOfTank = 10;
        double expected = 1.4285714285714285E7;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.calculateTimeToAllFull(capacities, waterFlowRate, numberOfTank - 1, 0, 0);

        //Then
        assertEquals(0, Double.compare(expected, actual));
    }

    @Test
    public void calculateTimeForInvalidWaterFlowRate() {
        //Given
        double[] capacities = {100000000, 99999999, 10000000, 1000000, 900000, 90000, 9000, 800, 80, 777};
        double waterFlowRate = 0;
        int numberOfTank = 10;
        double expected = -1.0;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.calculateTimeToAllFull(capacities, waterFlowRate, numberOfTank - 1, 0, 0);

        //Then
        assertEquals(0, Double.compare(expected, actual));
    }

    @Test
    public void calculateTimeForInvalidNumberOfTanks() {
        //Given
        double[] capacities = {100000000, 99999999, 10000000, 1000000, 900000, 90000, 9000, 800, 80, 777};
        double waterFlowRate = 7;
        int numberOfTank = 0;
        double expected = -1.0;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.calculateTimeToAllFull(capacities, waterFlowRate, numberOfTank - 1, 0, 0);

        //Then
        assertEquals(0, Double.compare(expected, actual));
    }

    @Test
    public void fillTanksToAllFullForInput1() {
        //Given
        double[] capacities = {30, 3, 7, 20};
        double waterFlowRate = (double)1/2;
        int numberOfTank = 4;
        double expected = 10;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.fillTanks(new double[numberOfTank], capacities, waterFlowRate, numberOfTank - 1, 0);

        //Then
        assertEquals(0, Double.compare(expected, Math.floor(actual/2)));
    }

    @Test
    public void fillTanksToAllFullForInput2() {
        //Given
        double[] capacities = {4, 6};
        double waterFlowRate = (double)2/2;
        int numberOfTank = 2;
        double expected = 2;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.fillTanks(new double[numberOfTank], capacities, waterFlowRate, numberOfTank - 1, 0);

        //Then
        assertEquals(0, Double.compare(expected, Math.floor(actual/2)));
    }

    @Test
    public void fillTanksToAllFullForInput3() {
        //Given
        double[] capacities = {100000000, 99999999, 10000000, 1000000, 900000, 90000, 9000, 800, 80, 777};
        double waterFlowRate = (double)7/2;
        int numberOfTank = 10;
        double expected = 61;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.fillTanks(new double[numberOfTank], capacities, waterFlowRate, numberOfTank - 1, 0);

        //Then
        assertEquals(0, Double.compare(expected, Math.floor(actual/2)));
    }

    @Test
    public void fillTanksForInvalidWaterFlowRate() {
        //Given
        double[] capacities = {100000000, 99999999, 10000000, 1000000, 900000, 90000, 9000, 800, 80, 777};
        double waterFlowRate = 0;
        int numberOfTank = 10;
        double expected = -1.0;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.fillTanks(new double[numberOfTank], capacities, waterFlowRate, numberOfTank - 1, 0);

        //Then
        assertEquals(0, Double.compare(expected, actual));
    }

    @Test
    public void fillTanksForInvalidNumberOfTanks() {
        //Given
        double[] capacities = {100000000, 99999999, 10000000, 1000000, 900000, 90000, 9000, 800, 80, 777};
        double waterFlowRate = 7;
        int numberOfTank = 0;
        double expected = -1.0;

        //When
        TimeCalculations timeCalculations = new TimeCalculations();
        double actual = timeCalculations.fillTanks(new double[numberOfTank], capacities, waterFlowRate, numberOfTank - 1, 0);

        //Then
        assertEquals(0, Double.compare(expected, actual));
    }
}