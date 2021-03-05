class Solution {
  
    /*
        Time : O(2N) ~ O(N)
        Space : O(1) | Map of 26 characters
    */
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        
        for(int i = 0; i < tasks.length; i++){
            if(!freqMap.containsKey(tasks[i])){
                freqMap.put(tasks[i], 0);
            }
            
            int count = freqMap.get(tasks[i]);
            count++;
            maxFreq = Math.max(maxFreq, count);
            map.put(tasks[i], count);     
        }
        
        for(int val : freqMap.values()){
            if(val == maxFreq){
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int empty = (n - (maxFreq - 1)) * partitions;
        int available = tasks.length - maxFreq * maxCount;
        int idle = Math.max(0, empty - available);
        
        return tasks.length + idle;
        
    }
}
