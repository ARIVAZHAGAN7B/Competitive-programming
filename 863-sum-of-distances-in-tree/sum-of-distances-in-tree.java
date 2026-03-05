import java.util.*;

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] answer = new int[n];
        int[] count = new int[n]; // subtree sizes

        // First DFS: compute subtree sizes and answer[0]
        dfs1(0, -1, graph, answer, count);

        // Second DFS: reroot to compute all answers
        dfs2(0, -1, graph, answer, count, n);

        return answer;
    }

    private void dfs1(int node, int parent, List<Integer>[] graph, int[] answer, int[] count) {
        count[node] = 1;
        for (int nei : graph[node]) {
            if (nei == parent) continue;
            dfs1(nei, node, graph, answer, count);

            count[node] += count[nei];
            answer[node] += answer[nei] + count[nei];
        }
    }

    private void dfs2(int node, int parent, List<Integer>[] graph, int[] answer, int[] count, int n) {
        for (int nei : graph[node]) {
            if (nei == parent) continue;

            // move root from node -> nei
            answer[nei] = answer[node] - count[nei] + (n - count[nei]);

            dfs2(nei, node, graph, answer, count, n);
        }
    }
}