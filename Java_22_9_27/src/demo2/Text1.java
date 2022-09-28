package demo2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 逆序打印链表*/
public class Text1 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if (!tokens[i].equals( "+" )   || !tokens[i].equals( "-" )  || !tokens[i].equals( "*" )  || !tokens[i].equals( "/" )){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int nub2 = stack.pop();
                int nub1 = stack.pop();
                switch(tokens[i]){
                    case "+":
                        stack.push(nub1 + nub2);
                        break;
                    case "-":
                        stack.push(nub1 - nub2);
                        break;
                    case "*":
                        stack.push(nub1 * nub2);
                        break;
                    case "/":
                        stack.push(nub1 / nub2);
                        break;

                }
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] strs = {"2","1","+","3","*"};
        evalRPN(strs);
    }

    public boolean isValid(String s) {
        /**
         思路：
         将左括号压入栈中
         */

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '{'||s.charAt(i) == '('||s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() == '[' && s.charAt(i) == ']' || stack.peek() == '(' && s.charAt(i) == ')' || stack.peek() == '{' && s.charAt(i) == '}'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    // 循环方式



    // 递归方式

}
