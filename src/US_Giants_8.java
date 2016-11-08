import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Edmond on 11/7/16.
 */
public class US_Giants_8 {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }

    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Map<String, Integer> map = new HashMap<>();
        map.put(start, 1);
        if (dict.contains(start)) {
            dict.remove(start);
        }
        while (!q.isEmpty()) {
            String top = q.poll();
            int length = top.length();
            StringBuilder strTry;
            int level = map.get(top);
            for (int i = 0; i < length; i++) {
                strTry = new StringBuilder(top);
                for (char c = 'a'; c <= 'z'; c++) {
                    strTry.setCharAt(i, c);
                    String tmp = strTry.toString();
                    if (tmp.equals(top)) {
                        continue;
                    }
                    if (tmp.equals(end)) {
                        return level + 1;
                    }
                    if (dict.contains(tmp)) {
                        map.put(tmp, level + 1);
                        q.offer(tmp);
                        dict.remove(tmp);
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 18. Subsets II.
     * @param nums: A set of numbers.
     * @return A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        Set<ArrayList<Integer>> result = new HashSet<>();

        if (nums == null) {
            return new ArrayList<>(result);
        }
        ArrayList<Integer> list = new ArrayList<>();

        return new ArrayList<>(result);
    }

    private void solveSubsetWithDup(int[] nums, Set<ArrayList<Integer>> result,
                                    ArrayList<Integer> list, int start) {

    }
}
