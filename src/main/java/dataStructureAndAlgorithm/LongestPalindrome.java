package dataStructureAndAlgorithm;

public class LongestPalindrome {
    private static String res = "";
    private static int max = 0;

    public static void main(String[] args) {
        String string = "abcbad";
        String longestPal = longestPalindrome(string);
        System.out.println(longestPal);

        String longestPal2 = longestPalindrome2(string);
        System.out.println(longestPal2);

        String longestPal3 = manacher(string);
        System.out.println(longestPal3);

    }

    public static String longestPalindrome(String str){
        if (str.length() <= 1) {
            return str;
        }

        for(int i = 0; i < str.length() - 1; i++){
            checkPalindromeExpand(str, i, i);
            checkPalindromeExpand(str, i, i+1);
        }
        return res;
    }

    public static void checkPalindromeExpand(String str, int low, int high){
        // 中心点已经计算过，从中间往两边扩展，如果相等（能继续构成回文子串）则继续扩展
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)){
            if (high - low + 1 > res.length()) {
                //substring不包括后面的字符，而算法设计上市包括，所以要加1
                res = str.substring(low, high+1);
            }
            low--;
            high++;
        }
    }

    public static String longestPalindrome2(String s) {
        int n=s.length();
        String res = "";
        boolean[][] pal=new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        int maxLen=0;

        // 两重循环
        // 第一重i= 0->n-1,第二重j=i-0，当前计算依赖的计算都已经完成
        for (int i = 0; i < n; i++) {
            // i作为终点
            // j作为起点
            for(int j = i; j >= 0; j--){
                //之前的范围是回文串且当前两个点相等
                //i-j=0时，只有一个字符，当前字符串肯定相等
                //i-j=1时，其子串为空，只需要判断当前字符串
                if ( (i-j<2 || pal[j+1][i-1]) && s.charAt(j)==s.charAt(i) ){
                    pal[j][i]=true;
                    if(i -j +1 > maxLen){
                        maxLen = i -j +1;
                        res = s.substring(j, i+1);
                    }
                }
            }
        }
        return res;
    }

    public static String manacher(String str){
        String res = "";
        StringBuffer sb = new StringBuffer("#");
        for(char c : str.toCharArray()){
            sb.append(c+"#");
        }
        int newLength = sb.length();
        String newStr = sb.toString();
        int[] radius = new int[newLength];
        int maxRight = 0;
        int pos = 0;
        int maxLen=0;

        for(int i = 0; i < newLength; i++){
            //获取当前的最大对称半径
            //i是当前点，i-1是之前已经求过的点
            if(i < maxRight){
                int j = i - 1;
                radius[i] = Math.min(radius[2*pos-i], maxRight-i);
            }else {
                radius[i] = 0;
            }

            while (i - radius[i] - 1 >= 0 && i+radius[i] + 1 < newLength && newStr.charAt(i+radius[i]+1) == newStr.charAt(i-radius[i]-1) ){
                radius[i]++;
            }
            if(i + radius[i] > maxRight){
                maxRight = i + radius[i];
                pos = i;
            }

            if(radius[i] > maxLen){
                maxLen = radius[i];
                //i-maxLen是回文子串中最左边的字符位置，且最左边一定是一个'#'
                //而原数组的最左边经过变换是被'#'包围的，如“#a#a#”把“aa”全包围，求a的索引需要向上取整
                int start = (int) Math.ceil( (i-maxLen) / 2.0);
                res = str.substring(start, start + maxLen);
                System.out.println(res);
            }
        }

        return res;
    }
}
