package demo;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int [] pushA ={1,2,3,4,5};
        int [] popA = {4,3,5,1,2};
        boolean ret = IsPopOrder(pushA, popA);
        System.out.println(ret);
    }

    //方法一压入栈
    public static  boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while(pushA[i] <= popA[j]){
            stack.push(pushA[i]);
            i++;
        }
        while(j < popA.length){
            if(stack.peek() == popA[j]){
                stack.pop();
                j++;
            }else {
                if(i < pushA.length){
                    stack.push(pushA[i]);
                    i++;
                }else {
                    break;
                }
            }
        }
        if(stack.isEmpty() && j == popA.length){
            return true;
        }else {
            return false;
        }
    }






    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if("+-*/".contains(tokens[i])){
                int b = stack.pop();
                int a = stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                }
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
