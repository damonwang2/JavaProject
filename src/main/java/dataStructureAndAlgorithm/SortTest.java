package dataStructureAndAlgorithm;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,0};
        quickSort(a, 0, a.length-1);
        for (int i : a){
            System.out.print(i + "");
        }
        System.out.println();

        a = new int[]{1,2,3,4,5,6,7,8,9,0};
        mergeSort(a, 0, a.length-1);
        for (int i : a){
            System.out.print(i + "");
        }
        System.out.println();

        a = new int[]{1,2,3,4,5,6,7,8,9,0,};
        heapSort(a);
        for (int i : a){
            System.out.print(i + "");
        }
        System.out.println();
    }

    public static void quickSort(int[] a, int low, int high){
        //分治算法：将原数组划分为两部分
        if(low < high){
            //确定pivot最终的位置，然后将数组划分为两部分递归计算
            int pivotPos = partition(a, low, high);
            quickSort(a, low, pivotPos-1);
            quickSort(a, pivotPos+1, high);
        }
    }

    public static int partition(int[] a, int low, int high){
        int pivot = a[low];

        while (low < high){
            //从右边选出比pivot小的，放在左边
            while (low < high && a[high] >= pivot)
                high--;
            a[low] = a[high];

            //从左边选出比pivot大的，放在右边
            while (low < high && a[low] <= pivot)
                low++;
            a[high] = a[low];
        }
        a[low] = pivot;

        return low;
    }

    public static void mergeSort(int[] a, int low, int high){
        //分治算法：将原数组划分为两部分
        if(low < high){
            //划分为相同大小的两部分，经过mergeSort后是两个内部有序的子数组，
            //然后调用merge就可以合成一个有序数组了
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high){
        //需要额外的空间，这里可以优化，只需要high-low+1的长度
        //copyA保存了a的副本，后面就可以直接对a进行赋值操作
        int[] copyA = Arrays.copyOf(a, a.length);
        int i = low;
        int j = mid+1;
        int k = low;
        while (i <= mid && j <= high){
            if(copyA[i] < copyA[j]){
                a[k++] = copyA[i++];
            }else {
                a[k++] = copyA[j++];
            }
        }
        while (i <= mid){
            a[k++] = copyA[i++];
        }
        while (j <= high){
            a[k++] = copyA[j++];
        }
    }

    public static void heapSort(int[] a){
        //思路：构建最大堆，每次取出堆顶，然后维护堆。这样取出的数字就是从大到小的有序序列。

        //构建最大堆：从中间的元素开始向下调整
        for(int i = a.length/2-1; i >= 0; i--){
            adjustDown(a, i, a.length-1);
        }

        //取出堆顶交换数组最后，并维护堆
        //这里i=a.length-1是堆最后一个节点的父节点的索引，不信你画个图
        for(int i = a.length - 1; i > 0; i--){
            //交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            adjustDown(a, 0, i-1);
        }
    }

    public static void adjustDown(int[] a, int i, int end){
        //保存当前值
        int temp = a[i];

        //沿i较大的子节点一直向下交换，直到出界或者后面的都比当前节点小
        for(int j = 2*i+1; j <= end; j *= 2){
            //j是两个孩子中关键字大的那个孩子的索引
            if(j+1 <= end && a[j] < a[j+1]){
                j++;
            }
            //a[i]值保存在temp中，比a[j]大则不用维护堆了，已经好了
            if(temp >= a[j]){
                break;
            }else {
                a[i] = a[j];
                i = j;
            }
        }
        //现在i已经到了最底层，把最开始的值赋给它
        a[i] = temp;
    }
}

