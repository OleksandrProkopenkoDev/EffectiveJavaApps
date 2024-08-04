package palindrome_number;

public class Solution {
    public static void main(String[] args) {
        Integer input = 123211;

        System.out.println("input = " + input);
        System.out.println("is palindrome ? " + isPalindrome(input));
    }

    private static boolean isPalindrome(Integer input) {
        if(input < 0) return false;
        int reverse = 0;
        int temp = input;

        while (temp > 0){
            int r = temp % 10;
            reverse = reverse * 10 + r;
            temp = temp / 10;
        }


        return (input == reverse);
    }
}
