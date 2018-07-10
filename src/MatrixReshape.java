class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if ((nums.length * nums[0].length) != (r * c))
            return nums;
        int [][] outnums = new int[r][c];
        int x=0 , y=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                outnums[i][j] = nums[x][y];
                y++;
                if (y == nums[0].length){
                    y = 0;
                    x++;
                }
            }
        }
        return outnums;
    }
}