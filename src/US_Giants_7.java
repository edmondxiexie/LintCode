/**
 * Created by Edmond on 11/3/16.
 */
public class US_Giants_7 {
    /**
     * 73. Construct Binary Tree from Preorder and Inorder Traversal.
     * @param preorder : A list of integers that preorder traversal of a tree
     * @param inorder : A list of integers that inorder traversal of a tree
     * @return Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);

        int inMid = inStart;
        while (inMid <= inEnd) {
            if (inorder[inMid] == val) {
                break;
            }
            inMid++;
        }

        root.left = construct(preorder, preStart + 1, preStart + (inMid - inStart), inorder, inStart, inMid - 1);
        root.right = construct(preorder, preStart + (inMid - inStart) + 1, preEnd, inorder, inMid + 1, inEnd);
        return root;
    }
}
