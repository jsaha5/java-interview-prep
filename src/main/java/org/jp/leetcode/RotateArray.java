package org.jp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RotateArray {
    public static void main(String[] args) {

        Integer[] arr = {44, 41, 12, 42, 71, 45, 28, 65, 75, 93, 66, 66, 37, 6, 24, 59};
       // rotateArray(arr);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        rotateArray(list,18);



    }

    private static void rotateArray(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int next = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = next;
        }
    }
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(B>A.size())
            B=B%A.size();
        for (int i = 0; i < A.size(); i++) {
            if(B+i>=A.size())
                ret.add(A.get(i+B-A.size()));
            else
                ret.add(A.get(i + B));
        }

        return ret;
    }

}
