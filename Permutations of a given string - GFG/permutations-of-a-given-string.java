//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> result = new ArrayList();
        char tempArray[] = S.toCharArray();
 
        Arrays.sort(tempArray);
 
        S =  new String(tempArray);
        boolean used[] = new boolean[S.length()];
        backtrack(result, S, "", used);
        Collections.sort(result);
        return result;
    }
    
    void backtrack(List<String> result, String str, String temp, boolean[] used){
        if(temp.length() == str.length()){
            result.add(temp);
            return;
        }
             
        for(int i = 0; i < str.length(); i++){
            if(used[i] || i> 0 && !used[i-1] && str.charAt(i) == str.charAt(i-1)) continue;
            used[i] = true;
            backtrack(result, str, temp+str.charAt(i), used);
            used[i] =false;
        }
    }
}
/*
    A        B   C
  B  C    A   C
 C    B   B    A
 
 
    
*/