class Solution {
    public int row(int [][]mat, int row){
        int sum=0;
        int m = mat[0].length;

        for(int i=0;i<m;i++) sum += mat[row][i];
        return sum;
    }

    public int col(int [][]mat, int col){
        int sum = 0;
        int n = mat.length;

        for(int i=0;i<n;i++)
        {
            sum += mat[i][col];
        }
        return sum;
    }

    public int numSpecial(int[][] mat) {
        int ctr=0;
        int m = mat[0].length;
        int n = mat.length;

     
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1)
                {
                    if((row(mat , i) + col(mat , j)) < 3) ctr++;
                }
            }
        }
        return ctr;
    }
}