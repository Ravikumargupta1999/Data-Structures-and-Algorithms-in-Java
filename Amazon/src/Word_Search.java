// https://leetcode.com/problems/word-search/submissions/
// https://practice.geeksforgeeks.org/problems/word-search/1/?company[]=Amazon&company[]=Amazon&page=1&category[]=Graph&query=company[]Amazonpage1company[]Amazoncategory[]Graph

public class Word_Search {
    public static boolean isWordExist(char[][] board, String word)
    {
        boolean found = false;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(word.charAt(0) == board[i][j])
                {
                    if(findWord(i,j,0,word,board))
                        return true;
                }
            }
        }
        return found;
    }
    static boolean findWord(int row,int col,int ind,String word,char[][] board)
    {
        if( ind ==  word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length)
            return false;
        if(ind ==  word.length()-1 && board[row][col] == word.charAt(ind))
            return true;
        if(board[row][col] == word.charAt(ind))
        {
            char ch = board[row][col];
            board[row][col] = '.';
            boolean found = findWord(row+1,col,ind+1,word,board)
                    || findWord(row-1,col,ind+1,word,board)
                    || findWord(row,col+1,ind+1,word,board)
                    || findWord(row,col-1,ind+1,word,board);
            board[row][col] = ch;
            if(found)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] ch = {{'b','a','c','d','d','b'}};
//                {'s','f','c','s'},
//                {'a','d','e','e'}};

          String word = "bd";
          System.out.println(isWordExist(ch,word));
    }
}
