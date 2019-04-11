class Solution {
   //NlogN
    public int[][] kClosestArraySort(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
    public int[][] kClosestHeapSort(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] left, int[] right) {
                return (right[0] * right[0] + right[1] * right[1]) 
                    - (left[0] * left[0] + left[1] * left[1]);
            }
        });
        for(int[] point : points){
            heap.add(point);
            if(heap.size() > K) 
                heap.poll();
        }
        int[][] result = new int[K][2];
        while(K> 0){
            result[--K] = heap.poll();
        }
        return result;
    }
    //NlogK
    public int[][] kClosestQuickSork(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while(l <= r){
            int mid = helper(points, l, r);
            if(mid == K) break;
            if(mid < K) l = mid + 1;
            else r = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    //N
    private int helper(int[][] points, int l, int r){
        int[] pivot = points[l];
        while(l < r){
            while(l < r && compare(points[r], pivot) >= 0) 
                r--;
            points[l] = points[r]; 
            while(l < r && compare(points[l], pivot) <= 0) 
                l++;
            points[r] = points[l]; 
        }
        points[l] = pivot;
        return l;
    }
    
    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
