package InterviewQuestions;

import java.util.Scanner;

public class JumpGame {
	
	    public static boolean canJump(int[] nums) {
	        int goal = nums.length - 1;

	        for (int i = nums.length - 2; i >= 0; i--) {
	            if (i + nums[i] >= goal) {
	                goal = i;
	            }
	        }

	        return goal == 0;        
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] nums = new int[n];
		for(int i =0 ; i< n ; i++)
		{
			nums[i] = sc.nextInt();
		}
		
   
       Boolean Result = canJump(nums);
       System.out.println(Result);
	}

}
