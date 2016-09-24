package default1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Shiyi on 9/21/2016.
 */
public class MaxStack3 {
    private static class Int implements Comparable<Int>{
        int val;
        private static int index = 0;
        static {
            index++;
        }
        Int(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Int that) {
            return ((Integer)this.val).compareTo((Integer)that.val);
        }

        public boolean isEqual(Int that) {
            if (this.val == that.val && this.index == that.index)
                return true;
            else return false;
        }
        public String toString() {
            return val + " " + index;
        }
    }
    private Stack<Int> st;
    private Stack<Int> maxSt;
    public MaxStack3() {
        st = new Stack<>();
        maxSt = new Stack<>();
    }
    public int getMax() {
        if (maxSt.isEmpty())
            return Integer.MIN_VALUE;
        else
            return maxSt.peek().val;
    }
    public void push(int n) {
        Int newInt = new Int(n);
        st.push(newInt);
        if (n>getMax()) maxSt.push(newInt);
    }
    public int pop() {
        Int top = st.pop();
        if (top.isEqual(maxSt.peek()))
            maxSt.pop();
        return top.val;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Int i: st) {
            sb.append(i.val+" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".\\data\\input13forMaxStack2.txt");
        Scanner sc = new Scanner(file);
        //Scanner sc = new Scanner(System.in);
        MaxStack3 ms = new MaxStack3();
        int testCases = sc.nextInt();
        while(testCases-- >0) {
            int opType = sc.nextInt();
            if (opType == 1) {
                ms.push(sc.nextInt());
            }
            else if (opType == 2) {
                ms.pop();
            }
            else if (opType == 3) {
                System.out.println(ms.getMax());
            }
        }
        //System.out.println(ms.toString());
        sc.close();
    }


}
