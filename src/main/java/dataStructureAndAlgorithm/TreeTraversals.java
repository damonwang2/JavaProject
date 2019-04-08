package dataStructureAndAlgorithm;

import java.util.*;

public class TreeTraversals {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String pre = "ABDEFC";
        String in = "DBFEAC";
        String post = "";
        String level = "";

        TreeNode root = CreateTreeByPreAndIn(pre, in);
        System.out.println(TraversalsByPost(root));

        System.out.println(TraversalsByInByLoop(root));
    }

    static TreeNode CreateTreeByPreAndIn(String pre, String in){
        if(pre.equals("") && in.equals("")){
            return null;
        }
        int indexOfRootAtIn = 0;
        int length = pre.length();
        for(; indexOfRootAtIn < length; indexOfRootAtIn++){
            // 找出
            if(in.charAt(indexOfRootAtIn) == pre.charAt(0)){
                break;
            }
        }
        TreeNode root = new TreeNode(in.charAt(indexOfRootAtIn));
        root.left = CreateTreeByPreAndIn(pre.substring(1, indexOfRootAtIn + 1), in.substring(0, indexOfRootAtIn));
        root.right = CreateTreeByPreAndIn(pre.substring(indexOfRootAtIn + 1, length), in.substring(indexOfRootAtIn + 1, length));

        return root;
    }

    static TreeNode CreateTreeByInAndPost(String in, String post){
        if(post.equals("") && in.equals("")){
            return null;
        }
        int indexOfRootAtIn = 0;
        int length = post.length();
        for(; indexOfRootAtIn < length; indexOfRootAtIn++){
            //��ȡ���ڵ����������е�ֵ
            if(in.charAt(indexOfRootAtIn) == post.charAt(length-1)){
                break;
            }
        }
        TreeNode root = new TreeNode(in.charAt(indexOfRootAtIn));
        root.left = CreateTreeByInAndPost(in.substring(0, indexOfRootAtIn), post.substring(0, indexOfRootAtIn));
        root.right = CreateTreeByInAndPost(in.substring(indexOfRootAtIn + 1, length), post.substring(indexOfRootAtIn, length-1));

        return root;
    }

    static TreeNode CreateTreeByInAndLevel(String in, String level){
        if(level.equals("") && in.equals("")){
            return null;
        }
        int indexOfRootAtIn = 0;
        int length = in.length();
        for(; indexOfRootAtIn < length; indexOfRootAtIn++){
            //��ȡ���ڵ����������е�ֵ
            if(in.charAt(indexOfRootAtIn) == level.charAt(0)){
                break;
            }
        }

        //����Ĺؼ���������ø��ڵ������������й��������������������Ĳ�������
        String leftTreeOfIn = in.substring(0, indexOfRootAtIn);
        String rightTreeOfIn = in.substring(indexOfRootAtIn+1, length);

        StringBuffer leftTreeOfLevel = new StringBuffer();
        StringBuffer rightTreeOfLevel = new StringBuffer();
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < leftTreeOfIn.length(); i++){
            set.add(leftTreeOfIn.charAt(i));
        }
        for(int i = 1; i < length; i++){
            if(set.contains(level.charAt(i))){
                leftTreeOfLevel.append(level.charAt(i));
            }else {
                rightTreeOfLevel.append(level.charAt(i));
            }
        }
        TreeNode root = new TreeNode(level.charAt(0));
        root.left = CreateTreeByInAndLevel(leftTreeOfIn, leftTreeOfLevel.toString());
        root.right = CreateTreeByInAndLevel(rightTreeOfIn, rightTreeOfLevel.toString());

        return root;
    }

    static String TraversalsByPre(TreeNode root){
        if(root == null)
            return "";
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(root.val);
        stringBuffer.append(TraversalsByPre(root.left));
        stringBuffer.append(TraversalsByPre(root.right));

        return stringBuffer.toString();
    }

    static String TraversalsByInByLoop(TreeNode root){
        if(root == null)
            return "";
        StringBuffer stringBuffer = new StringBuffer();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        //rootΪnull��stackΪ�����˳�ѭ������ʼstackΪ�գ����ʵ�Ҷ�ӽڵ�ĺ��ӽڵ���Ϊnull
        while (root != null || (!stack.isEmpty()) ){
            //δ��������
            if(root != null){
                //����߽ڵ�Ϊ��һ�����ʵĽڵ�
                stack.push(root);
                root = root.left;
            }else {
                //root��������null����stackȡ�ڵ�
                root = stack.pop();

                //����
                stringBuffer.append(root.val);

                root = root.right;
            }
        }

        return stringBuffer.toString();
    }

    static String TraversalsByIn(TreeNode root){
        if(root == null)
            return "";
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(TraversalsByIn(root.left));
        stringBuffer.append(root.val);
        stringBuffer.append(TraversalsByIn(root.right));

        return stringBuffer.toString();
    }

    static String TraversalsByPost(TreeNode root){
        if(root == null)
            return "";
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(TraversalsByPost(root.left));
        stringBuffer.append(TraversalsByPost(root.right));
        stringBuffer.append(root.val);

        return stringBuffer.toString();
    }

    static String TraversalsByLevel(TreeNode root){
        StringBuffer stringBuffer = new StringBuffer();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while ( !queue.isEmpty() ){
            TreeNode cur = queue.poll();
            stringBuffer.append(cur.val);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
        return stringBuffer.toString();
    }

}

class TreeNode{
    char val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(char val){
        this.val = val;
    }
}