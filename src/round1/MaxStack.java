package round1;

import java.util.Stack;

/**
 * Created by Shiyi on 9/20/2016.
 */
public class MaxStack extends Stack {
    private int max = 0;
    private int size = 0;
    public int getMax() {return max;}
    public int getSize() {return size;}

    public void push(int item) {
        size++;
        if (item > max) {
            super.push(2*item-max);
            max = item;
        } else {
            super.push(item);
        }
    }
    public Integer pop() {
        if ((Integer)super.peek()>max) {
            int temp = max;
            max = 2*max - (Integer)super.pop();
            return temp;
        }
        else {
            return (Integer)super.pop();
        }
    }
    public void printMaxStack() {
        for(Object i: this)
            System.out.println((Integer)i);
    }

    public static void main(String[] args) {
        MaxStack st = new MaxStack();
        st.push(-10);
        System.out.println(st.getMax());
        /*
        st.push(-4);
        st.push(-20);
        st.push(-3);
        st.push(2);
        for(int i =0;i<st.getSize();i++)
            System.out.println(st.pop());
        */
    }
}
