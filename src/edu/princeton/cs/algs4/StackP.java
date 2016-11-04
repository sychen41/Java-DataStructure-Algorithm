package edu.princeton.cs.algs4;
import warmUp.LinkedListP;
/**
 * Created by Shiyi on 9/20/2016.
 */
//public class StackP extends LinkedListP {
//    int a = pro; // this StackP can access public and protected field and methods from LinkedListP,
                    // but can NOT access the default (package private) and private;
//}

public class StackP {
    public static void main(String[] args) {
        LinkedListP<Integer> test = new LinkedListP<>();
        // can't access LinkedListP's protected field.
    }
}
