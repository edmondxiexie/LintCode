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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return new ArrayList<>(result);
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        solveSubsetWithDup(nums, result, list, 0);
        return new ArrayList<>(result);
    }

    private void solveSubsetWithDup(int[] nums, ArrayList<ArrayList<Integer>> result,
                                    ArrayList<Integer> list, int start) {
        if (!result.contains(list)) {
            result.add(new ArrayList<>(list));
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            solveSubsetWithDup(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 16 Permutations II.
     * @param nums: A list of integers.
     * @return A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        int[] record = new int[nums.length];
        solve(nums, record, result, list);
        return result;
    }

    private void solve(int[] nums, int[] record, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length && !result.contains(list)) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (record[i] == 1) {
                continue;
            }
            list.add(nums[i]);
            record[i] = 1;
            solve(nums, record, result, list);
            record[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);

        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) {
                p2++;
            }
            while (uglys.get(p3) * 3 <= lastNumber) {
                p3++;
            }
            while (uglys.get(p5) * 5 <= lastNumber) {
                p5++;
            }

            uglys.add(Math.min(
            Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
            uglys.get(p5) * 5
            ));
        }
        return uglys.get(n - 1);
    }

}
