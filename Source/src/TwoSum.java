import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Create by swtywang on 2020-05-17 22:31
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = {3,3,3,3};
        int targetNum = 6;
        int[] result1 = TwoSumResolution1(array, targetNum);
        int[] result2 = TwoSumResolution2(array, targetNum);
        int[] result3 = TwoSumResolution3(array, targetNum);
        for (int a : result2) {
            System.out.println(a);
        }
    }

    private static int[] TwoSumResolution3(int[] array, int targetNum) {
        int[] copyArray = array.clone();
        Arrays.sort(copyArray);
        int beginFlag = 0;
        int endFlag = array.length - 1;
        while (beginFlag < endFlag) {
            if (copyArray[beginFlag] + copyArray[endFlag] == targetNum) {
                int firstIndex = Arrays.binarySearch(array, copyArray[beginFlag]);
                int secondIndex = Arrays.binarySearch(array, Arrays.binarySearch(array, firstIndex+1, array.length-1,copyArray[endFlag]));
                return new int[]{firstIndex, secondIndex};
            } else if (copyArray[beginFlag] + copyArray[endFlag] < targetNum) {
                beginFlag++;
            } else {
                endFlag--;
            }
        }
        return new int[]{-1, -1};

    }

    /**
     * HashMap
     *
     * @param array
     * @param targetNum
     * @return
     */
    private static int[] TwoSumResolution2(int[] array, int targetNum) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(targetNum - array[i])) {
                return new int[]{map.get(targetNum - array[i]),i};
            }
            map.put(array[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 暴力搜索
     *
     * @param array
     * @param targetNum
     * @return
     */
    private static int[] TwoSumResolution1(int[] array, Integer targetNum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetNum) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


}
