package WorkPrepare;

import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for(int i = 0; i < len; i ++){
                arr[i] = sc.nextInt();
            }
            System.out.println(helper(arr));
        }
    }

    private static int helper(int[] arr){
        if(isSort(arr)) return 0;
        if(isSortInverst(arr)) return 1;

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int tmp = 0;
        for(int i = 0; i < arr.length; i ++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
                tmp = stack.peek();
            }else{
                if(tmp > arr[i]){
                    tmp = arr[i];
                }else{
                    stack.push(arr[i]);
                    tmp = arr[i];
                }
            }
        }

        res++;
        int[] cur = new int[stack.size()];
        for(int i = stack.size()-1; i > 0; i --){
            cur[i] = stack.pop();
        }
        if(isSortInverst(cur)) return res + 1;
        else return res + helper(cur);

    }
    private static boolean isSort(int[] arr){
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] > arr[i-1]) continue;
            else return false;
        }
        return true;
    }
    private static boolean isSortInverst(int[] arr){
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] < arr[i-1]) continue;
            else return false;
        }
        return true;
    }
}
