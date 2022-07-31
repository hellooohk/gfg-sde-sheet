import java.util.*;

public class MinCoins {
    /*
     * Given an infinite supply of each denomination of Indian currency { 1, 2, 5,
     * 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
     * Find the minimum number of coins and/or notes needed to make the change for
     * Rs N.
     */
    private static List<Integer> minPartition(int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        final int[] denominations = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        for(int i=denominations.length-1; i >= 0; i--) {
            while(N >= denominations[i]){
                N-= denominations[i];
                result.add(denominations[i]);   
                if(N == 0) break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        System.out.println(minPartition(N).toString());
    }
}