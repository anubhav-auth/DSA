//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");

            Solution obj = new Solution();

            String encodedString = obj.encode(s);
            String decodedStrings[] = obj.decode(encodedString);

            for (String x : decodedStrings) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public String encode(String s[]) {
        
        String a = "";
        
        for(String b: s){
            a += "\u200F" + b;
        }
        
        return a;
        
    }

    public String[] decode(String s) {
        return s.split("\u200F");
    }
}








