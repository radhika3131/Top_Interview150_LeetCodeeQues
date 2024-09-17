package InterviewQuestions;
import java.util.*;

public class HIndex {
	 public static  int hIndex(int[] citations) {
	        int h = citations.length; int maxi=0;
	        Arrays.sort(citations);
	         for (int i=0; i<citations.length; i++){
	            if (citations[i]>= h-i){
	                maxi = Math.max(maxi,h-i);
	               
	            }
	         } return maxi;
	    }

	 public static void main(String[] args)
	 {
		 Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			int[] nums = new int[n];
			for(int i =0 ; i< n ; i++)
			{
				nums[i] = sc.nextInt();
			}
			
	   
	       int Result = hIndex(nums);
	       System.out.println(Result);
	 }
}
