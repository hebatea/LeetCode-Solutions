class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList();

        for(int i = 0; i < intervals.length; i++){
            int[] curInterval = intervals[i];
            int curStart = curInterval[0];
            int curEnd = curInterval[1];
            int newStart = newInterval[0];
            int newEnd =  newInterval[1];

            if(curStart > newEnd){
                output.add(newInterval);
                newInterval = curInterval;
            }
            else if(curEnd < newStart) 
                 output.add(curInterval);
            else{
                newInterval[0] = Math.min(newStart, curStart);
                newInterval[1] = Math.max(newEnd, curEnd);
            }   
        }

        output.add(newInterval);

        return output.toArray(new int[output.size()][]);
    }
}