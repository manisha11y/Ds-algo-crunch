package test;

import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        //Scanner
        Scanner s = new Scanner(System.in);
        TestClass tc = new TestClass();
        Integer testcases = s.nextInt(); 
        int books; 
        int time; 
        int max = 0;
        int[] result = new int[testcases];
        for(int i = 1 ; i <= testcases; i++){
             books = s.nextInt(); 
             time = s.nextInt(); 
             result[i] = tc.calculateMax(books, time, 1, max);
             

        }

        for(int j = 1; j <= testcases; j++){
            System.out.println(result[j]);
        }

        

    }

    public int calculateMax(int books, int time, int i, int sum){
        if(i > books){
            return sum;
        }
        return Integer.max(calculateMax(books, time, i+2, sum+10), 
        calculateMax(books, time, i+1, sum+10));
    }
}
