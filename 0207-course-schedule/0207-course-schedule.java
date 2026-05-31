class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, List<Integer>[] graph, int[] state) {

        if (state[course] == 1) {
            return false; // cycle found
        }

        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;

        for (int next : graph[course]) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        state[course] = 2;

        return true;
    }
}