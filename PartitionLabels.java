class Solution {
  
    /*
      Time : O(N)
      Space : O(1) | Hashmap of 26 chars
      Leetcode : YES
    */
  
    /*
      Approach :
      1. calculate end position of each char and keep it in a hashmap
      2. Iterate from the start, and assign end to current character's end index.
        Now we want validate each character in the partition is not repeated out side of the end,
      3. if we come across i == end means every char in [start, end] is not repeating outside partition.
        so add it's size to the output.
    */
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0) return result;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i< S.length(); i++){
            char c = S.charAt(i);
            map.put(c, i);
        }
        
        int start = 0; int end = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                result.put(end - start + 1);
                start = i+1;
            }
        }
        
        return result;
    }
} 
