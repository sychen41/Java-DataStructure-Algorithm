package round1;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Shiyi on 9/20/2016.
 */
public class MaxStack2 {
    private Stack<Integer> st;
    private int max;
    private int size;
    private static boolean firstElementPush;
    static {
        firstElementPush = true;
    }
    public MaxStack2() {
        st = new Stack<>();
        max = 0;
        size = 0;
    }
    public int getMax() throws Exception {
        if (size != 0)
            return max;
        else
            throw new Exception("Max Stack is empty, max is undefined");
    }
    public int getSize() {return size;}
    public void push(int num) {
        size++;
        if (firstElementPush) {
            max = num;
            st.push(num);
            firstElementPush = false;
        } else {
            if (num > max) {
                st.push(2*num - max);
                max = num;
            } else {
                st.push(num);
            }
        }
    }
    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("Max Stack is empty. Can NOT pop");
        }
        size--;
        if (size == 0) {
            firstElementPush = true;
            return st.pop();
        } else {
            if (st.peek() > max) {
                int oldMax = max;
                max = 2*max - st.pop();
                return oldMax;
            } else {
                return st.pop();
            }
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int tempMax = max;
        for(int i: st) {
            if (i>tempMax) {
                int tempOldMax = tempMax;
                tempMax = 2*tempMax - i;
                sb.append(tempOldMax + " ");
            } else {
                sb.append(i + " ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {//I am too lazy...
        File file = new File(".\\data\\input00forMaxStack2.txt");
        Scanner sc = new Scanner(file);
        //Scanner sc = new Scanner(System.in);
        MaxStack2 ms = new MaxStack2();
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
        System.out.println(ms.toString());
    }
}
