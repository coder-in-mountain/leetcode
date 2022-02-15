public class Solution {
       public int ladderLength(String beginWord, String endWord, List<String> wordList) {
           if (wordList == null || wordList.size() == 0) return 0;
           Set<String> set = new HashSet<>(wordList);
           if (!set.contains(endWord)) return 0;
           set.remove(beginWord);

           Set<String> visited = new HashSet<>();
           Queue<String> queue = new LinkedList<>();

           int steps = 0;
           queue.offer(beginWord);
           visited.add(beginWord);

           while (!queue.isEmpty()) {
               int n = queue.size();
               steps++;
               while (n-- > 0) {
                   String w = queue.poll();
                   char[] chs = w.toCharArray();
                   for (int i = 0; i < w.length(); i++) {
                       char old = chs[i];
                       for (char ch = 'a'; ch <= 'z'; ch++) {
                           chs[i] = ch;
                           String v = new String(chs);
                           if (!visited.contains(v) && set.contains(v)) {
                               if (endWord.equals(v)) {
                                   return steps + 1;
                               }
                               queue.offer(v);
                               visited.add(v);
                           }

                       }
                       chs[i] = old;
                   }
               }
           }

           return 0;
       }
   }