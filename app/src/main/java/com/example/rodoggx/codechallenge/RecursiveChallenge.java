package com.example.rodoggx.codechallenge;

import java.util.Arrays;
import java.util.Collections;

public class RecursiveChallenge {

    public static void main(String[] args) {

        String str = "Apple launched Iphone X yesterday";
        //split string by space and store as array
        String[] arr = str.split(" ");
        //sort array in reverse order
        Arrays.sort(arr, Collections.reverseOrder());
        //store array from myString method as a string
        String sb = myString(arr);
        //print string
        System.out.println(sb);

    }
    private static String myString(String[] myArray) {
        //new stringbuilder instance
        StringBuilder sb = new StringBuilder();
        //for each item in the array, append string with a delimiter and item
        for (int i = 0; i < myArray.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            String item = myArray[i];
            sb.append(item);
        }
        return sb.toString();
    }
}
