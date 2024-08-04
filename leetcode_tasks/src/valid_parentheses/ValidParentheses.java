package valid_parentheses;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(){}[][]((())){{()}}";
//        System.out.println(validateParentheses(s));
        System.out.println(validateParenthesesV2(s));
    }

    private static boolean validateParenthesesV2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' ){
                stack.push('}');
            }else
            if(s.charAt(i) == '[' ){
                stack.push(']');
            }else
            if(s.charAt(i) == '(' ){
                stack.push(')');
            }

            if(s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')'){
                if( stack.isEmpty()){
                    return false;
                }
                char ch = stack.pop();
                if(ch != s.charAt(i)){
                    return false;
                }
            }

        }
        if(stack.empty()){
            return true;
        }else
        {
            return false;
        }
    }

    private static boolean validateParentheses(String s) {
        String[] pairs = {"()","[]","{}"};
        int idx = 0;
        for (int i = 0; i < s.length(); i+=2) {
            for (int j = 0; j < pairs.length; j++) {
                if(s.substring(i,i+2).equals(pairs[j]) ){
                    idx++;
                }
                if(idx == 0){
                    return false;
                }
            }

        }

        return true;
    }
}
