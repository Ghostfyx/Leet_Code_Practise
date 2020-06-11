package daily_practise.W2_202006;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author: fanyeuxiang
 * @createDate: 2020-06-11 13:15
 */
public class InvertTree_226 {

    /**
     *  使用递归的方式交换左右子树
     * @param root
     * @return
     */
    public MergeTrees_617.TreeNode invertTree(MergeTrees_617.TreeNode root) {
        if (null == root) return null;
        MergeTrees_617.TreeNode right = invertTree(root.right);
        MergeTrees_617.TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 层序遍历的思想
     *
     * @param root
     * @return
     */
    public MergeTrees_617.TreeNode invertTree2(MergeTrees_617.TreeNode root) {
        if (null == root) return null;
        Queue<MergeTrees_617.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            MergeTrees_617.TreeNode currentRoot = queue.poll();
            MergeTrees_617.TreeNode temp = currentRoot.left;
            currentRoot.left = currentRoot.right;
            currentRoot.right = temp;
            if (currentRoot.left != null) queue.add(currentRoot.left);
            if (currentRoot.right != null) queue.add(currentRoot.right);
        }
        return root;
    }





}
