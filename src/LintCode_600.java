import java.util.*;

/**
 * Created by Edmond on 2/4/17.
 */
public class LintCode_600 {
    /**
     * 616 Course Schedule II.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (numCourses == 0) {
            return new int[0];
        }

        int[] ins = new int[numCourses];
        Map<Integer, HashSet<Integer>> outs = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            outs.put(i, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            ins[cur]++;
            outs.get(pre).add(cur);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < ins.length; i++) {
            if (ins[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index] = course;
            index++;
            for (int out : outs.get(course)) {
                ins[out]--;
                if (ins[out] == 0) {
                    queue.offer(out);
                }
            }
        }
        if (index == numCourses) {
            return result;
        }
        return new int[0];
    }
}
