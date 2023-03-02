class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
              boolean res =  backtrack(board, word, 0, i, j);
              if(res) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col){
        if(index == word.length()) return true;
        if(row < 0 ||col < 0 || row >= board.length || col >= board[0].length ||word.charAt(index) != board[row][col]) return false;
        
        board[row][col] += 100;
        boolean exsit = false;
        exsit = backtrack(board, word, index + 1, row + 1, col)||
        backtrack(board, word, index + 1, row - 1, col)||
        backtrack(board, word, index + 1, row, col + 1)||
        backtrack(board, word, index + 1, row, col - 1);
        board[row][col] -= 100;
        return exsit;
    }
}