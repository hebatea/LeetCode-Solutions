class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap();
        String result = "";

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(map.entrySet());

        Map.Entry<Character, Integer> prev = null;

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result += current.getKey();
            current.setValue(current.getValue() - 1);

            if(prev != null && prev.getValue() != 0){
                maxHeap.offer(prev);
            }

            prev = current;
        }

        return result.length() == s.length()? result: "";
    }
}