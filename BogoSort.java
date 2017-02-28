import java.io.*;

public class BogoSort
{
	public static void main(String[]args)
	{
		int numCount = 4;
		int[] nums = new int[numCount];
		boolean solved = false;
		
		for(int i=0;i < numCount;i++)
			nums[i] = (int)(Math.random()*100);
		
		for(int i=0;i < numCount;i++)
			System.out.println(nums[i]);
		System.out.println();
		
		while(!solved)
		{
			int count = 0;
			for(int i=0;i < numCount-1;i++)
				if(nums[i] <= nums[i+1])
					count++;
			if(count == numCount-2)
				solved = true;
			
			int a = (int)(Math.random()*numCount);
			int b = (int)(Math.random()*numCount);
			
			int hold = nums[a];
			nums[a] = nums[b];
			nums[b] = hold;
			
			//for(int i=0;i < numCount;i++)
			//	System.out.print(nums[i] + " ");
			//System.out.println();
			
			System.out.println(count);
		}
		
		System.out.println();
		
		for(int i=0;i < numCount;i++)
			System.out.println(nums[i]);
	}
}