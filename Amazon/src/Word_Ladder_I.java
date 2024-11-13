import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Word_Ladder_I {
    int ladderLength(String beginWord, String endWord, String[] wordList) {
        HashSet<String> myset = new HashSet<>();
        boolean isPresent = false; //Checks if endWord is present in Dict
        //Insert all words from Dict in myset
        for(String word: wordList)
        {
            if(endWord.compareTo(word)==0)
                isPresent = true;
            myset.add(word);    //Insert word in Dict
        }
        if(isPresent==false)    //endWord is not present in Dict
            return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int depth = 0;

        while(!q.isEmpty())
        {
            depth+=1;
            int lsize = q.size();   //No of elements at a level
            while(lsize-- > 0)
            {
                String curr = q.peek();
                q.poll();
                //check for all possible 1 depth words
                for(int i=0;i<curr.length();++i)  //For each index
                {
                    char[] temp = curr.toCharArray();
                    for(char c='a';c<='z';++c)  //Try all possible chars
                    {
                        temp[i] = c;
                        if(curr.compareTo(temp.toString())==0)
                            continue;   //Skip the same word
                        if((temp.toString()).compareTo(endWord)==0)
                            return depth+1; //endWord found
                        if(myset.contains(temp.toString()))
                        {
                            q.add(temp.toString());
                            myset.remove(temp.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }
}
