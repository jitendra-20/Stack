import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //String infix="a+b*c+d";
        //String infix="a+b*c";
        //String infix="a+(b*c)+d";
        String infix="c+d*e-f*g^a*b+k/h";
        //abc*+d+

        System.out.println(solution.infix2PostFix(infix));

    }
}
class Solution {


    public String infix2PostFix(String expr) {
        //If we find the operand, put in the result
        //if we find the operator with higher priority then the stack's top operrator priorrity,
        // then push it push it
        char[] infix= expr.toCharArray();
        Stack<Character> stack= new Stack<>();
        StringBuilder sb= new StringBuilder();
        int i=0;
        while(i<infix.length){
            if(isOperand(infix[i])){
                sb.append(infix[i]);
                i++;
            }else{
                  if(stack.empty() || isHigherPriority(infix[i])>isHigherPriority(stack.peek())) {
                       stack.push(infix[i]);
                       i++;

                  }else{
                      char operator= stack.pop();
                      if(operator != '(' && operator !=')')
                          sb.append(operator);
                  }
            }
            System.out.println("value of I: "+i);

            System.out.println(stack);
        }
        while(!stack.empty()){
            char operator= stack.pop();
            if(operator != '(' && operator !=')')
                sb.append(operator);

        }
        return sb.toString();
    }
    boolean isOperand(char x){
        if(x=='+' || x=='-'|| x=='/' || x=='(' || x==')' || x=='*' || x=='^'){
            return false;
        }else{
            return true;
        }
    }
    int isHigherPriority(char x){
        if (x=='+' || x=='-') return 1;
        else if (x=='*' || x=='/') return 2;
        else if (x=='^') return 3;
        else if (x=='(' || x==')') return 4;
        else
            return 0;
    }


}