class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowelSet = new HashSet();
        vowelSet.add('a'); vowelSet.add('o'); vowelSet.add('i');
        vowelSet.add('u'); vowelSet.add('e');
        
        int count = 0;
        int maxCount = 0;
        int startWindow = 0;

        for(int endWindow = 0; endWindow < s.length(); endWindow++){
            char currentChar = s.charAt(endWindow);
            if(vowelSet.contains(currentChar)){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            if(endWindow >= k-1){
                if(vowelSet.contains(s.charAt(startWindow++))){
                    count--;
                }
            }
        }

        return maxCount;
    }
}