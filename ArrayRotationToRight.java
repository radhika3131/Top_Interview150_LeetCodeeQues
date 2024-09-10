package InterviewQuestions;

import java.util.Scanner;

public class ArrayRotationToRight {
	 public static void rotate(int[] arr, int k) {

	        int n = arr.length;
	        

	        if(n == 0)
	        {
	            return;
	        }
	        k = k %  n;

	        /*
	        if(k > n)
	        {
	            return;
	        }
	        // temporery array of storing last k eements
	        int[] temp = new int[k];

	        // copy last k elemets from org array to temp array
	        for(int i = n - k ; i<n ; i++)
	        {
	            temp[i - n + k ] = arr[i];
	        }

	        // shift rest of the lements present in org arr to the right
	        for(int i = n - k -1 ; i>=0 ; i--)
	        {
	            arr[i+k] = arr[i];
	        }

	        // copy elements of temp arr to org arr
	        for(int i = 0 ; i<k ; i++)
	        {
	            arr[i] = temp[i];
	        }

	        */

	        reverseArr(arr , 0 , n - k -1);
	        reverseArr(arr , n-k , n - 1);
	        reverseArr(arr , 0 , n-1);

	    }

	    public static void reverseArr(int[] arr , int start , int end)
	    {
	        while(start <= end)
	        {
	            int temp = arr[start];
	            arr[start] = arr[end];
	            arr[end] = temp;
	            start++;
	            end--;
	        }

	    }
	    
	    static void printArray(int arr[], int n)
	    {
	        for (int i = 0; i < n; i++)
	            System.out.print(arr[i] + " ");
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i =0 ; i< n ; i++)
		{
			arr[i] = sc.nextInt();
		}
		

        // Calling method 1 and 2 as defined above
		rotate(arr, k);
        printArray(arr, n);

	}

}
