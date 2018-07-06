package LeetCode;

import javafx.util.Pair;

import java.util.*;

public class Solution127 {

    /**
     * 规定了所有的单词都相同的长度，只有小写，没有重复，不为空
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {


        LinkedList<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.addLast(new Pair<>(beginWord, 1));   //初始为1

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

        // BFS
        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.removeFirst();
            String currentWord = pair.getKey();
            int step = pair.getValue();

            char[] currentChars = currentWord.toCharArray();
            // 判断当前是否可以直接变化到最终结果
            int diff = calDiff(currentWord, endWord);
            if(diff < 2 && wordList.contains(endWord)){
                return step + diff;
            }

            //直接替换每个位置的字符，进行比较
            for(int i = 0; i < currentWord.length(); i ++){
                char mychar = currentChars[i];
                for(char j = 'a'; j <= 'z'; j ++){
                    if(mychar == j) continue;
                    currentChars[i] = j;
                    String nextString = new String(currentChars);
                    if(wordList.contains(nextString) && !visited.containsKey(nextString)){
                        visited.put(nextString, true);
                        queue.addLast(new Pair<String, Integer>(nextString, step+1));
                    }
                    currentChars[i] = mychar; //还原回去
                }
            }
        }
        return 0;
    }

    // 计算两个字符的差异
    private static int calDiff(String currentWord, String endWord){
        int diff = 0;
        for(int i = 0; i < currentWord.length(); i ++){
            if(currentWord.charAt(i) != endWord.charAt(i)) diff ++;
            if(diff == 2) break;
        }
        return diff;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(ladderLength(beginWord, endWord, list));

        List<String> list1 = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
        System.out.println(ladderLength(beginWord, endWord, list1));
    }
}
