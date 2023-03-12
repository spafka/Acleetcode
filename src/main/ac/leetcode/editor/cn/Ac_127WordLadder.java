package leetcode.editor.cn;

//A transformation sequence from word beginWord to word endWord using a
//dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
// 
//
// 
// Every adjacent pair of words differs by a single letter. 
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need 
//to be in wordList. 
// sk == endWord 
// 
//
// Given two words, beginWord and endWord, and a dictionary wordList, return 
//the number of words in the shortest transformation sequence from beginWord to 
//endWord, or 0 if no such sequence exists. 
//
// 
// Example 1: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
//> "dog" -> cog", which is 5 words long.
// 
//
// Example 2: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no 
//valid transformation sequence.
// 
//
// 
// Constraints: 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord, endWord, and wordList[i] consist of lowercase English letters. 
// beginWord != endWord 
// All the words in wordList are unique. 
// 
//
// Related Topics广度优先搜索 | 哈希表 | 字符串 
//
// 👍 1210, 👎 0 
//
//
//
//


import java.util.*;

/**
 * 2023-03-12 15:19:45
 */
public class Ac_127WordLadder {
    public static void main(String[] args) {
        Solution solution = new Ac_127WordLadder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> wordSet = new HashSet<>(wordList);
            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
                return 0;
            }
            wordSet.remove(beginWord);

            // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
            int step = 1;
            while (!queue.isEmpty()) {
                int currentSize = queue.size();
                for (int i = 0; i < currentSize; i++) {
                    // 依次遍历当前队列中的单词
                    String currentWord = queue.poll();
                    // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                    if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                        return step + 1;
                    }
                }
                step++;
            }
            return 0;
        }

        /**
         * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
         *
         * @param currentWord
         * @param endWord
         * @param queue
         * @param visited
         * @param wordSet
         * @return
         */
        private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                                 Queue<String> queue, Set<String> visited, Set<String> wordSet) {
            char[] charArray = currentWord.toCharArray();
            for (int i = 0; i < endWord.length(); i++) {
                // 先保存，然后恢复
                char originChar = charArray[i];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (k == originChar) {
                        continue;
                    }
                    charArray[i] = k;
                    String nextWord = String.valueOf(charArray);
                    if (wordSet.contains(nextWord)) {
                        if (nextWord.equals(endWord)) {
                            return true;
                        }
                        if (!visited.contains(nextWord)) {
                            queue.add(nextWord);
                            // 注意：添加到队列以后，必须马上标记为已经访问
                            visited.add(nextWord);
                        }
                    }
                }
                // 恢复
                charArray[i] = originChar;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}