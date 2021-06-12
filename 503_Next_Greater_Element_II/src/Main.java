import java.util.Arrays;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,1};
       // int[] nums={5,4,3,10,11,7,9,15,8};
        Solution sol= new Solution();
        sol.nextGreaterElements(nums);
    }
}

class Solution{

    public int[] nextGreaterElements(int[] nums) {
        if(nums.length<=1){
            return nums;
        }

        int[] result= new int[nums.length];

        Stack<Integer> stack= new Stack<>();
        stack.push(0);
        for(int i=1;i<nums.length;i++){
            int peek=stack.peek();
           if(nums[peek]<nums[i]) {
               while(!stack.empty() && nums[stack.peek()]<nums[i]){
                   result[stack.pop()]=nums[i];
               }
               stack.push(i);

           }else{
               stack.push(i);
           }
        }
       //put rest of the element in result arrray while stack is empty
        while(!stack.empty()){
            int i=stack.pop();
            result[i]=-1;
        }

        System.out.println(Arrays.toString(result));
        return new int[]{};

    }

}