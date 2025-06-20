import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int value) {
        data = value;
        left = right = null;
    }
}

class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null)
            return new TreeNode(value);
        if (value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);
        return root;
    }

    public boolean isValidBST(TreeNode node) {
        return isValidBSTHelper(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;
        return isValidBSTHelper(node.left, min, node.data) &&
               isValidBSTHelper(node.right, node.data, max);
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
}

public class BSTFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        BST bst = new BST();
        for (int num : arr) {
            bst.root = bst.insert(bst.root, num);
        }

        System.out.print("Inorder Traversal: ");
        bst.inOrder(bst.root);
        System.out.println();

        if (bst.isValidBST(bst.root))
            System.out.println("The tree is a valid BST.");
        else
            System.out.println("The tree is NOT a valid BST.");

        sc.close();
    }
}
