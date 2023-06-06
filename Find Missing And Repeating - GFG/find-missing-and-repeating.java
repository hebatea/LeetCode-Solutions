//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    
    private void swap(int arr[], int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    
    int[] findTwoElement(int arr[], int n) {
        // code here
        int i = 0;
        
        while(i < n){
            if(arr[i] == arr[arr[i] - 1]){
                i++;
            }else{
                swap(arr, i, arr[i] - 1);
            }
        }
        
        int missing = 0, duplicate = 0;
        
        for( i = 0; i < n; i++){
            if(arr[i] != i + 1){
                missing = i + 1;
                duplicate = arr[i];
                return new int[]{duplicate, missing};
            }
        }
        return null;
    }
}