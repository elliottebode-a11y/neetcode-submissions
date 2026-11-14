class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0;
        int totCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i];
            tank -= cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
            totGas += gas[i];
            totCost += cost[i];
        }
        if (totGas < totCost) return -1;
        return start;
    }
}
