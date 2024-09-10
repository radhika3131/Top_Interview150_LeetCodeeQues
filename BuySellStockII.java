package InterviewQuestions;

import java.util.Scanner;

public class BuySellStockII {
	

	public static int maxProfit(int[] prices) {
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maximumProfit += prices[i] - prices[i - 1];
        }
        return maximumProfit;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] prices = new int[n];
		for(int i =0 ; i< n ; i++)
		{
			prices[i] = sc.nextInt();
		}
		
   
       int Profit = maxProfit(prices);
       System.out.println("Maximum profit is :" + Profit);

	}
}
