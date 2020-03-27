package com.mars.x.leecode;

import java.util.Stack;

/**
 * @author: sj.hu
 * @date: 2020/3/12 10:36
 **/
public class Solution1 {
    public static void main(String[] args) {

        int[] s= new int[]{56,59,71,73,66,67,55,82,68,85,87};
        int[] r = nextOrderGrowthDays_0(s);
        for(int i=0;i<r.length;i++) {
            System.out.print(r[i]+",");
        }
    }

    public static int[] nextOrderGrowthDays_0(int[] T) {
        if(T == null || T.length ==0) return new int[0];
        int[] r = new int[T.length];
        for(int i=0; i<T.length; i++) {
            for(int j=i+1; j<T.length; j++) {
                if(T[j] > T[i]) {
                    r[i] = j-i;
                    break;
                }
            }
        }
        return r;
    }

    public static int[] nextOrderGrowthDays(int[] s) {
        if(s == null || s.length ==0) return new int[0];
        int[] r = new int[s.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<s.length; i++) {
            while (!stack.isEmpty() && s[stack.peek()] < s[i]) {
                r[stack.peek()] = stack.isEmpty()? 0: i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return r;
    }

    public void test(int a,String b) {

    }
    public void test(String b, int a) {

    }
}
