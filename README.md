
# Glowing and Flowing
## Abhinaya Jayakumar



## 🔗 Links
[![github](https://img.shields.io/badge/github-abi%20jay-red)](https://github.com/abi-jay/HTML-CSS-JavaScript-SBA)
[![linkedin](https://img.shields.io/badge/linkedin-Abhinaya%20Jayakumar-blue)](https://www.linkedin.com/in/abhinayaj/)

## Project Structure
```
.
├── README.md
├── out
│   └── artifacts
│       └── fillTank_jar
│           └── fillTank.jar
└── src
│   └── Main.java
│   ├── timeCalculations
│         └── TimeCalculations.java
└── test
     └── TimeCalculationsTest.java


```
### Logic
#### To calculate time for the last tank to get full:
- Start with 0, increment water level in each tank according to the rate(k) provided
- If the last tank is full, this is the base case for the recursion, so return the time. 
- At what time, the overflow from previous tank + input to this tank + water level already there in this tank will be equal to the capacity (so that after that point it will overflow) ?
- We require the overflow because all previous overflows may add eventually to the last one.
- Overflow is the excess water

- Arriving at the formula:
    -
    overflow = (waterlevel[i] + input) - capacity[i]

- If there is a overflow in a tank, pass it to the next one unless the next one is the last tank & maintain this tank's waterlevel at its max capacity:
    -
    waterLevels[i + 1] = waterLevels[i + 1] + overflow
    waterLevels[i] = capacities[i]

- If there is no overflow, keep adding the waterflow(k) into each tank and increment time:
    -
    waterLevels[i] = waterLevels[i] + waterFlowRate
    recursive call -> fillTanks(waterLevels, capacities, waterFlowRate, lastTank, time + 1);

- Once the last tank hits its capacity, waterLevels[lastTank] == capacities[lastTank], return the time
- I have converting the input flow rate into multiples of 0.5 seconds - inorder to find the exact second in which the tank gets filled
- Used floor function to get the whole integer part of the double value
- Used String format %0.f to format the output
    

#### To calculate time for all tanks to get full:
- Start with 0, increment water level in each tank according to the rate(k) provided
- If the tank that is processing is the last tank, this is the base case for the recursion, so return the time. 
- At what time, the overflow from previous tank + input to this tank + water level already there in this tank will be equal to the capacity (so that after that point it will overflow) ?

- Time to fill the first tank (since no overflow). Find the time when:
    -
    input+ waterlevel[1st tank] = capacity[1st tank]
    input is second * rate (Example, at 10 seconds if k is 1, input is 10*1 units of water)
    => timeToFillCurrent = (capacities[currentIndex] - waterLevel) / waterFlowRate

- Time to fill the next tanks (other than the last one). Using recursive call, send the next tank index and add the input water units to its waterlevel:
    -
    input+ waterlevel[1st tank] = capacity[1st tank]
    recursive call => calculateTimeToAllFull(capacities, waterFlowRate, lastTank, currentIndex + 1, waterLevel + waterFlowRate);

- The tank with the highest capacity needs to get full, so use Max function to compare.
    -
    Math.max(timeToFillCurrent, timeToFillNext);




```
## Deliverables
fillTank.zip
```
## Running Tests

To run tests, run the following command

```
  TimeCalculationsTest.java has the following tests:
  - calculateTimeToAllFullForInput1()
  - calculateTimeToAllFullForInput2()
  - calculateTimeToAllFullForInput3()
  - calculateTimeForInvalidWaterFlowRate()
  - calculateTimeForInvalidNumberOfTanks()
  - fillTanksToAllFullForInput1()
  - fillTanksToAllFullForInput2()
  - fillTanksToAllFullForInput3()
  - fillTanksForInvalidWaterFlowRate()
  - fillTanksForInvalidNumberOfTanks()

These tests are written in JUnit4 and performs validation on input as well

```




## Run Locally

Clone the project

```bash
  git clone https://github.com/abi-jay/fillTanks
```

Go to the project directory

```bash
  cd fillTank
```

Run jar file

```bash
java -jar /Users/abibala/Documents/fillTank/out/artifacts/fillTank_jar/fillTank.jar               
4
1
30
3
7
20
```

Output

```bash
  Time taken for the last tank to fill: 10 seconds
  Time taken for all the tanks to fill: 30 seconds
```


## Screenshots


IntelliJ Run the program
<img width="828" alt="main" src="https://github.com/abi-jay/fillTanks/blob/7b05e63e45250b240bc4e8c3a110dbdd1499fcdd/images/Main%20java.png">

IntelliJ Tests
<img width="947" alt="test" src="https://github.com/abi-jay/fillTanks/blob/7b05e63e45250b240bc4e8c3a110dbdd1499fcdd/images/Test%20cases.png">

Run the jar in terminal
<img width="952" alt="jar" src="https://github.com/abi-jay/fillTanks/blob/7b05e63e45250b240bc4e8c3a110dbdd1499fcdd/images/Jar%20file%20from%20terminal.png">    