package demo;

import java.util.Stack;

public class Test {
    public String func(String str) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            if(stack.isEmpty() && str.charAt(i) == ')'){
                return "NO";
            }
            if(str.charAt(i) == '('){
                stack.push(Integer.parseInt(str.charAt(i)+"") );
            }
            if(str.charAt(i) == ')'){
                stack.pop();
            }
        }

        if(stack.isEmpty() && i == str.length()-1){
            if(Math.abs > 2){
                return false;
            }
            return "YES";
        }
        return "NO";
    }


}
