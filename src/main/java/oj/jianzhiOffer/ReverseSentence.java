package oj.jianzhiOffer;

/**
 * Created by Damon on 2017/7/19.
 */
public class ReverseSentence {
    public static void main(String[] args) {

    }

    public String ReverseSentence(String str) {
        String trim = str.trim();
        String a = "";
        if("".equals(str.trim())){
            return str;
        }
        String[] strings = str.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = strings.length-1 ; i>=0;i--) {
            if(i == 0){
                sBuilder.append(strings[i]);
            }else {
                sBuilder.append(strings[i]);
                sBuilder.append(" ");
            }
        }
        return sBuilder.toString();
    }
}
