package leecode;

import java.util.Stack;

/**
 * @author: sj.hu
 * @date: 2020/3/10 14:45
 **/
public class Solution {

    public static void main(String[] args) {
        int[] prices = new int[]{7,2,9,1,6,9};
        //System.out.println("max profit:" + maxProfit(prices));

        Stack<String> stack = new Stack<>();
        stack.push("111");
        stack.push("222");
        stack.push("333");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

}
