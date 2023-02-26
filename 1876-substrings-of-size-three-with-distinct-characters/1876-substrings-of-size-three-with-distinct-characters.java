class Solution {
    public int countGoodSubstrings(String s) {
        int[] hash = new int[26];
        int output = 0;
        int start = 0;
        int counter = 0;
        
        for(int end = 0; end < s.length(); end++){
            char curChar = s.charAt(end);
            hash[curChar - 'a']++;

            if((end - start) >= 2){
                char startChar = s.charAt(start);
                for(int i = 0; i < hash.length; i++){
                    if(hash[i] >= 2){
                        break;
                    }
                    if(hash[i] == 1) counter++;
                }
                if(counter == 3) output++;
                counter = 0;
                hash[startChar - 'a']--;
                start++;
            }
        }

        return output;
    }
}
