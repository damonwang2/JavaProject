package onlineExamination.meililianhe;

public class Main3167 {

    public static void generateLIS(int arr[],int dp[]) {
        int k=0;
        int index=0;
        int len=0;
        for(int i=0;i<arr.length;i++)
        {
            if(dp[i]>len)
            {
                len=dp[i];
                index=i;
                //找到递增子序列中的最后一个元素[10,22,33,41,60,80]中的80，
            }
        }
        int subArr[]=new int[len];
        subArr[k++]=arr[index];
        for(int j=index-1;j>=0;j--)
        {
            if((dp[index]==dp[j]+1)&&(arr[index]>arr[j]))
            {
                //从后向前,将属于递增子序列的元素加入到subArr中。
                subArr[k++]=arr[j];
                index=j;
            }
        }
        for(int j=subArr.length-1;j>=0;j--)
        {
            System.out.print(subArr[j]+" ");
        }

    }
}
