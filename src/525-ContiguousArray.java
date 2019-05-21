class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countIndexMap = new HashMap<>();
        countIndexMap.put(0, -1); //the number of 1s - the number of 0s equals to 0, and the index we can get this key is -1.
        int maxlen = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            count = count + (nums[i] == 1 ? 1 : -1); //count = the number of 1s - the number of 0s
            if(countIndexMap.containsKey(count)){
                maxlen = Math.max(maxlen, i - countIndexMap.get(count));
            }else{
                countIndexMap.put(count, i);
            }
        }
        return maxlen;
    }
}
