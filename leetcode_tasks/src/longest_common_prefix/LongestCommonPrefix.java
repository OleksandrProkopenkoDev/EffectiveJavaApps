package longest_common_prefix;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flower", "flowe", "flowet", "af"};
//        findLongestCommonPrefix(input);
        System.out.println( findLongestCommonPrefixV2(input) );
    }

    private static String findLongestCommonPrefixV2(String[] input) {
        System.out.println(Arrays.toString(input));
        Arrays.sort(input);
//        System.out.println(Arrays.toString(input));
        String s1 = input[0];
        String s2 = input[input.length-1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            }else {
                break;
            }
        }
        if(idx == 0){
            return "There is no common prefix among the input strings.";
        }
        return s1.substring(0,idx);
    }


    private static void findLongestCommonPrefix(String[] input) {

        int count = 0;
        for (int i = 0; i < input[0].length(); i++) {
            for (int j = 1; j < input.length; j++) {

                int wordLength = input[j].length();


                if(i < wordLength  && input[0].charAt(i) == input[j].charAt(i) ){
                    count++;
                }else if(i < wordLength  && input[0].charAt(i) != input[j].charAt(i) && count < input.length){
                    System.out.println("There is no common prefix among the input strings.");
                    return;
                }else if(i > wordLength){
                    int prefix =  (count) / (input.length-1);
                    System.out.println(input[0].substring(0, prefix));
                    return;
                }
            }
        }

    }
}
