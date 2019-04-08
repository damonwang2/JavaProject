package dataStructureAndAlgorithm;

public class BinarySearch {
    public static void main(String[] args) {

    }

    /**
     * 在有序不重复数组array中查找target，有则返回target所在的index，没有返回-1
     * 如果target不存在，退出while循环时，low 比 high 大 1，且array[low] > target, array[high] < target
     */
    public static int binarySerach(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // 这里必须是 <=，因为low和high相等时，array[mid]和target可能相等
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 查找第一个大于等于target的元素
     */
    static int getFirstEqualLarger(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // 思路和上面类似
        // 退出while循环时，low 比 high 大 1，且array[low] >= target, array[high] < target
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 查找最后一个小于target的元素
     */
    static int getLastSmaller(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // 思路和上面类似
        // 退出while循环时，low 比 high 大 1，且array[low] >= target, array[high] < target
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    /**
     *查找最后一个小于等于target的元素
     */
    static int getLastEqualOrSmaller(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // 退出while循环时，low比high大1
        // array[low]是第一个大于target的数，array[high]是最后一个小于等于target的数
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    /**
     *查找第一个大于target的元素
     */
    static int getFirstGreater(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // 退出while循环时，low比high大1
        // array[low]是第一个大于target的数，array[high]是最后一个小于等于target的数
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * 在有序数组array中查找target，如果有则返回第一个target的index，没有返回-1
     */
    static int getFirstEqual(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // 第一个target出现的位置处于小于和等于的界限
        // 所以我们把等于和大于一样处理，我们合并为 >=
        // 退出while循环时，array[low]就是第一个 >= target的数，array[high]就是最后一个 < target的数
        // 我们只知道array[low] >= target，是否等于需要进一步判断
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        if (low < array.length && array[low] == target) {
            return low;
        }

        return -1;
    }

    /**
     * 在有序数组array中查找target，如果有则返回最后一个target的index，没有返回-1
     */
    public static int getLastEqual(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (high >= 0 && array[high] == target) {
            return high;
        }

        return -1;
    }



}
