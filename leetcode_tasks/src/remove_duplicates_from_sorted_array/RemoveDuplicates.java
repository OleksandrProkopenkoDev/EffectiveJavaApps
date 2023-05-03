package remove_duplicates_from_sorted_array;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

	public static void main(String[] args) {

//		int[] input =  {0,0,1,1,1,2,2,3,3,4};
//		int[] nums =  {-3,-1,0,0,0,3,3};
		int[] nums = {0,0,1,1,1,2,2,3,3,4,4,4,4,4,4};
		List<Integer> output = new ArrayList<>();
		
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]!=nums[i+1]) {
				output.add(nums[i]);				
			}
		}
		output.add(nums[nums.length-1]);
		for (int i = 0; i < output.size(); i++) {
			nums[i] = output.get(i);
			System.out.print(nums[i]+" ");
		}
		
		System.out.println(output);
			
		
		
	}
	
	/*
	 * Set<Integer> set = new HashSet<>(); for(int i = 0; i<input.length;i++) {
	 * set.add(input[i]);
	 * 
	 * } System.out.println("set: "+set); int count=0; for(Integer i: set) {
	 * input[count++] = i;
	 * 
	 * }
	 * 
	 * for (Integer i : input) { System.out.print(i+" "); }
	 * System.out.println("\n"+set); System.out.println(count);
	 */

}
