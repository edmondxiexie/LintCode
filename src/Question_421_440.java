/**
 * Created by Edmond on 1/20/17.
 */
public class Question_421_440 {
    /**
     * 437. Copy Books.
     * @param pages
     * @param k
     * @return
     */
    public int copyBooks(int[] pages, int k) {
        int start = 1;
        int end = 0;
        for (int page : pages) {
            end += page;
        }
        int min = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int people = 1;
            int sum = 0;
            for (int page : pages) {
                while (sum + page > mid) {
                    people++;
                    sum = 0;
                    if (people > k) {
                        break;
                    }
                }
                sum += page;
            }
            if (people == k) {
                min = mid;
                end = mid - 1;
            } else if (people > k) {
                start = mid + 1;
            } else {
                min = mid;
                end = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Question_421_440 q = new Question_421_440();
        int[] nums = {1, 2};
        System.out.println(q.copyBooks(nums, 5));
    }
}
