class Pair{
    String word;
    int level;

    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        if(beginWord == endWord)return 1;

        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(q.size()>0){
            String word = q.peek().word;
            if(word.equals(endWord))return q.peek().level;
            for(int i=0;i<word.length();i++){
                 
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String relatedWord = new String(charArray);
                    if(set.contains(relatedWord)){
                        q.add(new Pair(relatedWord, q.peek().level + 1));
                        set.remove(relatedWord);
                    }
                }
            }
            q.remove();
        }
        return 0;
        
    }
}
