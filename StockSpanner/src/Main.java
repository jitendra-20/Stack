import javafx.util.Pair;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
       //int[] stockPrice={100, 80, 60, 70, 60, 75, 85};
        //int [] stockPrice={31,41,48,59,79};
        int[] stockPrice={100,86,78,89,1000};
        for(int i=0;i< stockPrice.length;i++){
            int param_1 = obj.next(stockPrice[i]);
            System.out.println(param_1);
        }

    }
}

class StockSpanner {
   Stack<Pair<Integer, Integer>> stack= new Stack<>() ;
    int i=0;
    public StockSpanner() {
    }

    public int next(int price) {

        int result=-1;
        if(stack.size()==0){
            stack.push(new Pair(i,price));
            i++;
            return 1;
        }
        else if(stack.size()>0){
            Pair<Integer, Integer> p2= stack.peek();
            if(p2.getValue()<=price){
               while(stack.size()>0 && p2.getValue()<=price) {
                   stack.pop();
                   if(stack.size()>0) p2=stack.peek();

               }

              if(stack.size()==0){
                       result= i+1;
               }else{
                   result= i-p2.getKey();
               }
            }else{
                result= i-p2.getKey();
            }
        }
        stack.push(new Pair(i,price));
        i++;
        return result;
    }
}
