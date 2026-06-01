class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1; // beginWord counts as the first step

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process all words at the current transformation level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return steps;
                }
                // Generate all neighbors (one-letter transformations)
                for (String neighbor : getNeighbors(word, dict)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            steps++;
        }

        return 0; // no path found
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                arr[i] = c;
                String newWord = new String(arr);
                if (dict.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            arr[i] = original; // restore for next position
        }

        return neighbors;
    }
}
