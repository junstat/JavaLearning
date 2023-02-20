package Q2199.Q2105WateringPlantsII.solution;

public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0, j = plants.length - 1, canA = capacityA, canB = capacityB, ans = 0;
        while (i < j) {
            ans += (canA < plants[i] ? 1 : 0) + (canB < plants[j] ? 1 : 0);
            canA = canA < plants[i] ? capacityA : canA;
            canB = canB < plants[j] ? capacityB : canB;
            canA -= plants[i++];
            canB -= plants[j--];
        }
        return ans + (i == j && Math.max(canA, canB) < plants[i] ? 1 : 0);
    }
}