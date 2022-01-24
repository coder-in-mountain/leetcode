import java.util.*;
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) return new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>(Arrays.asList(new String[]{beginWord}));
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>(Arrays.asList(new String[]{beginWord}));

        int step = 0, minSteps = -1;

        while (!queue.isEmpty()) {
            int n = queue.size();
            step++;
            while (n-- > 0) {
                String w = queue.poll();
                if (minSteps > 0) {
                    continue;
                }
                if (w.equals(endWord)) {
                    minSteps = step;
                    continue;
                }
                char[] chs = w.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != old) {
                            chs[i] = c;
                            String str = new String(chs);
                            if (dict.contains(str) && !visited.contains(str)) {
                                parents.computeIfAbsent(w, key -> new ArrayList<String>()).add(str);
                                queue.offer(str);
                                if (!str.equals(endWord))
                                    visited.add(str);
                            }
                        }
                    }
                    chs[i] = old;
                }
            }
        }
        return restoreTransformationPath(beginWord, endWord, minSteps, parents);
    }

    List<List<String>> restoreTransformationPath(String begin, String end, int steps, Map<String, List<String>> parents) {
        LinkedList<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(new String[]{begin}));

        while (steps-- > 0) {
            int n = queue.size();
            while (n-- > 0) {
                List<String> list = queue.peek();
                String w = list.get(list.size() -1);

                if (w.equals(end)) {
                    continue;
                }else{
                    queue.poll();
                }

                for (String p : parents.get(w)) {
                    List<String> newList = new ArrayList<>(list);
                    newList.add(p);
                    queue.offer(newList);
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        t("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
    }

    static void t(String begin, String end, List<String> dict) {
        for (String w : dict) {
            System.out.print(w + ", ");
        }
        System.out.println();
        System.out.println("Begin Word : " + begin + ", End Word : " + end);

        List<List<String>> paths = new Solution().findLadders(begin, end, dict);

        System.out.println("Find " + paths.size() + " total paths");
        for (List<String> list : paths) {
            System.out.println(list);
        }
    }
}