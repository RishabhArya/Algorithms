public class Solution {
    public static void main(String[] args) {
        int[] array = { 3, 2, 1 };
        int value = 5;
        find(array, value);

    }

    static void find(int[] array, int value) {

        int[][] dp = new int[array.length + 1][value + 1];

        // This means we have no coin adn extracting a value from a no coin is like hell
        for (int i = 0; i <= value; i++) {
            dp[0][i] = Integer.MAX_VALUE;

        }
        for (int i = 1; i <= array.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= value; j++) {
            dp[1][j] = (j % array[0] == 0) ? j / array[0] : Integer.MAX_VALUE;
        }

        for (int i = 2; i < array.length; i++) {
            for (int j = 1; j < value; j++) {
                if (array[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] =Math.min(dp[i - 1][j], 1+dp[i][j - array[i - 1]]);
                }

            }
        }
        System.out.println(dp[array.length][value]);
    }
}