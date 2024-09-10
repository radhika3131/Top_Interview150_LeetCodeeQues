/**
 * 
 */
package InterviewQuestions;

/**
 * 
 */
public class BuySellStockI {

	/**
	 * @param args
	 */
	
	public static int maxProfit(int[] arr) {
        int minBuySoFar = arr[0];
        int res = 0;

        // update the buying price - which should be the minumum value so far
        for(int i =1 ; i< arr.length ; i++)
        {
            minBuySoFar = Math.min(minBuySoFar , arr[i]);

            // update the result if the get larger profit then before
            res = Math.max(res , arr[i] - minBuySoFar);
        }

        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices));

	}

}
