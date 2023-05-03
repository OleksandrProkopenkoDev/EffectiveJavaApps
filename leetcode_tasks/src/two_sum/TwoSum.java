package two_sum;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {27,32,2,7,11,15};
		int target = 9;
		
		int[] output = twoSum(nums, target);
		System.out.println(Arrays.toString(output));
	}

    private static int[] twoSum(int[] nums, int target) {
//    	num1+num2=target
//    	check first with all others if first+second =target, then return their indices
    	int[] result = new int[2];
    	for(int i = 0; i < nums.length;i++ ) {
    		for(int j = 1; j < nums.length; j++) {
    			if(nums[i]+nums[j] == target) {
    				result[1]=i;
    				result[0]=j;
    				return result;
    			}
    		}
    	}
    	
    	return result;
    }
}
