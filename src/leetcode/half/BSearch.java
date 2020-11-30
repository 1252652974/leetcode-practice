package leetcode.half;

/**
 * @ClassName bsearch
 * @Description: TODO
 * @Author liang_liu
 * @Date 2020/6/30
 * @Version V1.0
 **/
public class BSearch {
    public static void main(String[] args) {
        int arrs[] = {1,2,3,5,7,8,9,12,4,77,89};
        System.out.println(bSrach(arrs, 9));
    }

    private static int bSrach(int[] arrs, int target) {
        int start = 0;
        int end = arrs.length - 1;
        while (start<=end) {
            int mid = start + ((end - start) >> 1);
            if (arrs[mid] > target) {
                end = mid;
            } else if (arrs[mid] < target) {
                start = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
