class Solution {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0, len = A.length;
        for(int i = 0; i < len; i++){
            if(stack.empty() ||  A[stack.peek()] > A[i])
                stack.add(i);
        }
        for(int i = len - 1; i > ret; i--){
            while(!stack.empty() && A[stack.peek()] <= A[i]){
                ret = Math.max(ret, i - stack.pop());
            }            
        }
        return ret;
    }
}
