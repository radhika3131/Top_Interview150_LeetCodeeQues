package InterviewQuestions;

import java.util.Scanner;

public class JumpGameII {
	public static int jump(int[] nums) {
        int near = 0, far = 0, jumps = 0;

        while (far < nums.length - 1) {
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            near = far + 1;
            far = farthest;
            jumps++;
        }

        return jumps;        
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
		
   
       int Result = jump(nums);
       System.out.println(Result);

	}

}
