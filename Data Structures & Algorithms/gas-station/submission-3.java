class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            totGas += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        if (totGas < 0) return -1;
        return start;
    }
}
