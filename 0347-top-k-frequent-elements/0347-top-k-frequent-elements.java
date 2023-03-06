class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[k];

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
            (a, b) -> a.getValue() - b.getValue()
        );

        int i = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(i++ < k){
                minHeap.offer(entry);

            }else if(entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        for(i = 0; i < k; i++){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}

/*
[1,1,1,2,2,3]
1 -> 3
2 -> 2
3 -> 1

Map <Integer, Integer> number -> freq

PQ, make the sorting based on the value in the HashMap

loop throug the hashMap and put k element in PQ

extract just the keys from that pq

return the value;
 */