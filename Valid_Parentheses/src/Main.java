import java.util.HashMap;
import java.util.Stack;
import java.util.Map;
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str="(())";
        System.out.println(solution.isValid(str));
    }
}
class Solution{
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[' ){
                stack.push(ch);
            }else if(stack.empty() ){
                return false;
            }else if (ch==')' && stack.pop()!='('){
                return false;
            }else if (ch=='}' && stack.pop()!='{') {
                return false;
            }else if (ch==']' && stack.pop()!='[') {
                return false;
            }
        }
        return stack.empty();

    }
}