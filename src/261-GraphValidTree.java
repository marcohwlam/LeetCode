class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge : edges){
            if(unionFind.unionHasCycle(edge[0],edge[1])) return false;
        }
        return unionFind.getSize() == 1;
    }
    
    class UnionFind{
        private int Size;
        private int[] parent, rank;
        public UnionFind(int numOfEdges){
            Size = numOfEdges;
            parent = new int [numOfEdges];
            rank = new int [numOfEdges];
            for(int i = 0; i < numOfEdges; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x){
            while(parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }    
        
        public boolean unionHasCycle(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return true;
            Size--;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = parent[rootY];
            }
            else {
                if (rank[rootX] == rank[rootY]) {
                    rank[rootX]++; //increase rank (union by rank)
                }
                parent[rootY] = parent[rootX];
            }          
            return false; 
        }
        
        public int getSize(){
            return Size;
        }
    }
}
