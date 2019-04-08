package dataStructureAndAlgorithm;

public class NearestCommonAncestor {
    public static void main(String[] args) {

    }

    public char nearestCommonAncestor(String s1, String s2, char c1, char c2){
        int length = s1.length();
        //获取根节点
        char root = s1.charAt(0);

        //c1或者c2有一个是根节点
        if(root == c1 || root == c2)
            return root;

        int rootLocation = 0;

        for(; rootLocation < length; rootLocation++){
            //找到root在中序序列的位置
            if(root == s2.charAt(rootLocation) )
                break;
        }

        boolean c1InLeft = false;
        boolean c2InLeft = false;

        for(int i = 0; i < rootLocation; i++){
            if(s2.charAt(i) == c1){
                c1InLeft = true;
            }
            if(s2.charAt(i) == c2){
                c1InLeft = true;
            }
        }

        //如果一左一右则返回root,采用异或
        if(c1InLeft^c2InLeft){
            return root;
        } else if(c1InLeft && c2InLeft){
            //两个都在左，继续递归
            return nearestCommonAncestor(s1.substring(1, rootLocation+1),
                    s2.substring(0, rootLocation), c1, c2);
        }else {
            return nearestCommonAncestor(s1.substring(rootLocation+1, length),
                    s2.substring(rootLocation+1, length), c1, c2);
        }
    }
}
