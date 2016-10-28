package default1;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public PerformOperation is_odd() {
        //return num -> {if (num%2 == 0) return false;
        //                else return true;};
        return new PerformOperation() {
            public boolean check(int a) {
                if (a%2==0) return false;
                else return true;
            }
        };
    }
    public PerformOperation is_prime() {
        /*
        return num -> {
            if (num==0 ||num==1) return false;
            for(int i=2;i<=num/2;i++)
                if (num%i == 0)
                    return false;
            return true;
        };
        */
        return new PerformOperation() {
            public boolean check(int a) {
                return new BigInteger(""+a).isProbablePrime(5);
            }
        };
    }
    public PerformOperation is_palindrome() {
        /*
        return num -> {
            String s = ""+num;
            String rev = "";
            for(int i=s.length()-1;i>=0;i--) {
                rev += s.charAt(i);
            }
            if (s.equals(rev)) return true;
            else return false;
        };
        */
        return new PerformOperation() {
            public boolean check(int a) {
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                String original = sb.toString();
                sb = sb.reverse();
                return original.equals(sb.toString());
            }
        };
    }
}

public class LambdaPrac {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.is_odd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.is_prime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.is_palindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}