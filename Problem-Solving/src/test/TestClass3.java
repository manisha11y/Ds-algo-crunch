package test;

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
import java.util.*;
class TestClass3 {
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

    	Scanner s = new Scanner(System.in);
        int testcases = s.nextInt(); 
        int arrSize;
        int[] arr ;              
        int[] result = new int[testcases]; 
        int max = Integer.MIN_VALUE;
        int pos =0;
        int ptr;
        for(int i = 0; i< testcases; i++){
            arrSize =s.nextInt();
            arr = new int[arrSize];
            for(int j= 0; j< arrSize; j++){ //O(n) to decide max
                arr[j] = s.nextInt(); 
                if(arr[j] > max){
                     max = arr[j];
                     pos = j;
                } 
                              
            }

            for(int l = 0; l<arrSize; l++){ //O(n) to choose alternate combination
                if((pos-l)%2 ==0 && l!=pos){
                    max+=arr[l];
                    result[i]=max;
                }
            }
            // ptr = arrSize-1;

            // while(ptr >=0){
            //     result[i] += arr[ptr];
            //     ptr-=2;
            // }
        }

        for(int k =0; k< testcases; k++)
        {
            System.out.println(result[k]);
        }

    }
}

