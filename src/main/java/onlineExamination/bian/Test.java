package onlineExamination.bian;

public class Test {

    private static int count = 2;

    private static Integer result;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node2.left = node1;
        node2.right = node4;
        node4.left = node3;
        node4.right = node6;
        node6.left = node5;
        node6.right = node7;

//        secondLargest(node2);
        inorder(node2);
        System.out.println(result);
    }

    private static void secondLargest(Node node) {
//        System.out.println(node.value);
        if (node == null) {
            return;
        }
        secondLargest(node.right);
        count++;
        if (count < 2) {
            System.out.println(node.value);
        } else {
            result = node.value;
            return;
        }

            secondLargest(node.left);

    }
    private static void inorder(Node root) {
        if (root == null) {
            return;
        }

        // 遍历 右子节点
        if (result == null) {
            inorder(root.right);
        }
        // 计数，若 当前节点是第k个节点，结束递归，并记录 当前节点的值
        System.out.println(root.value);
        if (--count == 0) {
            result = root.value;
            return;
        }
        // 遍历 左子节点

        if (result == null) {
            inorder(root.left);
        }
    }

    private static class Node {
        int value;

        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
