package com.example.leetCode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gasDelta = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            gasDelta[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < gasDelta.length; i++) {
            if (canCompleteCircuit(gasDelta, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canCompleteCircuit(int[] gasDelta, int startStationIndex) {
        int remainingGas = 0;
        int currentStationIndex = startStationIndex;
        while (true) {
            remainingGas += gasDelta[currentStationIndex];
            currentStationIndex = getNextStationIndex(gasDelta, currentStationIndex);
            if (remainingGas < 0) {
                return false;
            }
            if (currentStationIndex == startStationIndex) {
                return true;
            }
        }
    }

    private int getNextStationIndex(int[] gasDelta, int currentStationIndex) {
        if (++currentStationIndex == gasDelta.length) {
            return 0;
        } else {
            return currentStationIndex;
        }
    }
}
