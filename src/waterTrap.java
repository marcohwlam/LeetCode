public class waterTrap {
    public int trap(int[] height) {
        int l = 0, r = height.length -1;
        int max_height = 0;
        int vol = 0;
        int len = height.length;
        if(height == null || len == 0) return 0;
        while(l < r){
            max_height = Math.min(height[l], height[r]) > max_height ? Math.min(height[l], height[r]) : max_height;
            vol = height[l] >= height[r] ? vol + (max_height - height[r--]) : vol + (max_height - height[l++]);
        }

        return vol;
    }
}
