package round1;

/**
 * Created by Shiyi on 9/22/2016.
 */
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.out;
public class TextEditor {
    private StringBuilder sb;
    private Stack<String> st;
    //maximum consecutive undo times: 100
    //private final int maxUndoTimes = 100;
    public TextEditor() {
        sb = new StringBuilder("");
        st = new Stack<>();
        st.push(sb.toString());
    }
    public void append(String s) {
        //if (st.size()>maxUndoTimes) //need dequeue operation, which is not supported by Stack;
        st.push(sb.toString());
        sb.append(s);
    }
    public void delete(int k) {
        //if (st.size()>maxUndoTimes) //need dequeue operation, which is not supported by Stack;
        st.push(sb.toString());
        int length = sb.length();
        sb.delete(length-k,length);
    }
    public void print(int k) {
        out.println(sb.charAt(k-1));
    }
    public void undo() {
        sb = new StringBuilder(st.pop());
    }

    public String toString() {
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor te = new TextEditor();
        int testCases = sc.nextInt();
        while(testCases-- >0) {
            int opType = sc.nextInt();
            if (opType == 1) {
                te.append(sc.next());
            }
            else if (opType == 2) {
                te.delete(sc.nextInt());
            }
            else if (opType == 3) {
                te.print(sc.nextInt());
            }
            else if (opType == 4) {
                te.undo();
            }
        }
        sc.close();
    }
}
