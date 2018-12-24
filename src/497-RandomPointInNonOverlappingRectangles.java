class Solution {
    int[][] rects;
    List<Integer> psum = new ArrayList<>();
    int total = 0;
    Random rand = new Random();
    public Solution(int[][] rects) {
        this.rects = rects;
        for(int[] rect : rects){
            total += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            psum.add(total);
        }
    }
    
    public int[] pick() {
        int target = rand.nextInt(total);
        int hi = rects.length -1, lo = 0;
        while(hi != lo){
            int mid = lo + (hi - lo) / 2;
            if(target >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        int[] rect = rects[lo];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int base = psum.get(lo) - width * height;
        return new int[]{rect[0] + (target - base) % width, rect[1] + (target - base) / width};
    }
}
