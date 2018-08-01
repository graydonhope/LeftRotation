import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {
       public static int[] rotLeft(int[] a, int d) {
        // Complete the rotLeft function below. 
        int rotations = d;
        int length = a.length;
        int[] array_copy = new int[length];
        System.arraycopy(a, 0, array_copy, 0, length );

        if(rotations > length){
            for(int i = 0; i < rotations; i++){
                int next = (i - rotations) % length;
                if (next < 0){
                    next += length;
                }
                int temp = a[next];
                array_copy[next]  = a[i%length];
            }
        }
        else if(length > rotations){
            for(int i = 0; i < length; i++){
                int next = (i - rotations) % length;

                if (next < 0){
                    next += length;
                }

                int temp = a[next];
                array_copy[next]  = a[i%length];
            }
        }

        return array_copy;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}