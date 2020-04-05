package p122;

public class Greedy {
    int hasStock = 0; // 0: have no stock, 1: have stock
    int buyPrice = 0;
    int profit = 0;

    public int maxProfit(int[] prices) {
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                if (hasStock == 1) {
                    sellStock(prices[i]);
                }
                continue;
            }

            if (prices[i] > prices[i + 1]) {
                if (hasStock == 0) {
                    // Do nothing
                } else {
                    sellStock(prices[i]);
                }
            } else if (prices[i] <= prices[i + 1]) {
                if (hasStock == 0) {
                    buyStock(prices[i]);
                } else {
                    // Do nothing
                }
            }
        }

        return profit;
    }

    private void buyStock(int currentPrice) {
        hasStock = 1;
        buyPrice = currentPrice;
    }

    private void sellStock(int currentPrice) {
        hasStock = 0;
        profit += currentPrice - buyPrice;
    }
}
