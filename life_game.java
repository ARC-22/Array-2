// Time Complexity : O(m*n)
// Space Complexity : O(1) // since modifying given space 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0){
            return;
        }

        m = board.length;
        n = board[0].length;

        for(int i =0; i<m; i++){
            for(int j= 0; j<n; j++){
                int liveCount = getLiveCount(board, i, j);
                // if cell is live
                if(board[i][j] == 1){
                    if(liveCount < 2 || liveCount > 3){
                        board[i][j] = 2; // make cell dead
                    }
                }
                else{ 
                    if(liveCount == 3){
                        board[i][j] = 3; // make cell alive
                    }
                }

            }
        }

        for(int i =0; i < m; i++){
            for(int j= 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveCount(int [][]board, int row, int col){
        int cnt=0;
        int dirs[][] = {{-1,-1}, {-1,0}, {-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];                                            // previously cell was alive
            if(nr >=0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                cnt++;
            }
        }
        return cnt;
    }    

}