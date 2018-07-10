public class Rob {
    public int rob(int[] nums) {
        int last = 0, now = 0, temp;
        for (int money:nums) {
            temp = Math.max(last + money, now);
            last = now;
            now = temp;
        }
        return now;
    }
}
