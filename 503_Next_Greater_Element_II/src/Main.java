import java.util.Arrays;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
       // int[] nums={1,2,1};
       // int[] nums={5,4,3,10,11,7,9,15,8};
        int [] nums={3,8,4,1,2};
        Solution sol= new Solution();
      //  sol.nextGreaterElements(nums);
       // sol.nextGreaterElements1(nums);
        //sol.nextGreaterElements1WithCirculralArray(nums);
        sol.nextGreaterElements1WithCirculralArray2(nums);
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

    public int[] nextGreaterElements1(int[] nums) {
        if(nums.length<=1){
            return nums;
        }

        int[] result= new int[nums.length];

        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<nums.length;i++){
            //if stack.peek is bigger than incomming items
            //then pop
            while(!stack.empty() && nums[i]>nums[stack.peek()] ){
                result[stack.pop()]=nums[i];
            }
            stack.push(i);
        }

        //put rest of the element in result arrray while stack is empty
        while(!stack.empty()){
            int i=stack.pop();
            result[i]=-1;
        }

       return result;

    }


    public int[] nextGreaterElements1WithCirculralArray(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        int[] result= new int[nums.length];
        Arrays.fill(result,-1);

        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<2*nums.length;i++){
            //if stack.peek is bigger than incomming items
            //then pop
            while(!stack.empty() && nums[i% nums.length]>nums[stack.peek()] ){
                result[stack.pop()]=nums[i%nums.length];
            }
            if(i<nums.length) stack.push(i);
        }
        return result;

    }


    public int[] nextGreaterElements1WithCirculralArray2(int[] nums) {
        System.out.println("input: "+Arrays.toString(nums));
        int n=nums.length;
        Stack<Integer> stack= new Stack<>();
        int[] result= new int[nums.length];
        Arrays.fill(result,-1);

        //--++
        for(int i=n-2;i>=0;i--) {
            while(!stack.empty() && stack.peek()<nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }

        System.out.println("stack: "+stack.toString());

        for(int i=n-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            if(stack.size()==0){
                result[i]=-1;
            }else{
                result[i]=stack.peek();
            }

            stack.push(nums[i]);

        }

        System.out.println("stack: "+stack.toString());
        System.out.println(Arrays.toString(result));
       return new int []{};
    }
}