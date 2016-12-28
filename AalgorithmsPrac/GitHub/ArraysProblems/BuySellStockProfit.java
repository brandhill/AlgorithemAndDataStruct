package ArraysProblems;

public class BuySellStockProfit {

	static int MaxProfit(int[] prices){
		
		int min = prices[0];
		int diff = 0;
		for ( int i = 1; i < prices.length; i++) {
			if(prices[i] - min > diff){
				diff = prices[i] - min;
			}
			if(prices[i]<min){
				min = prices[i]; 
			}
		}
		return diff;
		
	}
	
	static int alltimeProfit(int[] prices){
		int profit = 0;
		for( int i = 1; i < prices.length; i++){
			if(prices[i-1] < prices[i]) {
				profit += prices[i] - prices[i-1];
			}
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		//int[] n = {2,1,2,1,0,1,2};
		int[] n = {3,2,6,5,0,3};
		int m = BuySellStockProfit.MaxProfit(n);
		System.out.println(m);
	}
}
