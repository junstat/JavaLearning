package Q0199.Q0134GasStation;

/*
    1> If car starts at A and can not reach B. Any station between A and B
    can not reach B.(B is the first station that A can not reach.)
    2> If the total number of gas is bigger than the total number of cost. There must be a solution.
 */
public class Solution1 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, tank = 0;
        // if car fails at start, record the next station
        for (int i = 0; i < gas.length; i++)
            if ((tank = tank + gas[i] - cost[i]) < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        return (total + tank < 0) ? -1 : start;
    }
}

/*
If you are confused,(like I was before),try think about it with two passes. Use the first pass to determine if we
have a solution(property 2 above). Then use the second pass to find out the start position(use property 1).
After you are comfortable with 2 passes, you can absolutely modify it into one pass solution.

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //determine if we have a solution
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        // find out where to start
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length;i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
 */