class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, Double> dMap = new HashMap();
        int i = 0;
        for(int[] p: points){
            double diff = Math.sqrt((p[0] * p[0]) + (p[1] * p[1]));
            dMap.put(i++, diff);
        }

        PriorityQueue<Map.Entry<Integer, Double>> maxHeap = new PriorityQueue<Map.Entry<Integer, Double>>(new Comparator<Map.Entry<Integer, Double>>(){
            public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2){
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        for(Map.Entry<Integer, Double> entry: dMap.entrySet()){
            maxHeap.offer(entry);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        i = 0;
        while(!maxHeap.isEmpty()){
            Map.Entry<Integer, Double> polledItem = maxHeap.poll();
            // int val = 
            result[i++] = points[polledItem.getKey()];
        }

        return result;
    }
}

/*
Map -> Index, distance

Pq maxHeap-> store based on Distance 

save k items

return res
 */