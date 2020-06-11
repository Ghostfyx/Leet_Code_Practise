# 226. InvertTree

## 1. 解题思路

### 1.1 递归思想

从根节点开始向下遍历，直到遍历到叶子节点，转换左右叶子节点

<img src="https://pic.leetcode-cn.com/0f91f7cbf5740de86e881eb7427c6c3993f4eca3624ca275d71e21c5e3e2c550-226_2.gif" style="zoom:67%;" />

### 1.2 迭代思想

这个方法的思路就是，我们需要交换树中所有节点的左孩子和右孩子。因此可以创一个队列来存储所有左孩子和右孩子还没有被交换过的节点。开始的时候，只有根节点在这个队列里面。只要这个队列不空，就一直从队列中出队节点，然后互换这个节点的左右孩子节点，接着再把孩子节点入队到队列，对于其中的空节点不需要加入队列。最终队列一定会空，这时候所有节点的孩子节点都被互换过了，直接返回最初的根节点就可以了。

**优点：**一边迭代一边转换左右节点。

## 2. 解题代码

### 2.1 递归

```java
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
```

### 2.2 迭代

```java
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
```

