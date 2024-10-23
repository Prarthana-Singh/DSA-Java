/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode>queue = new LinkedList<>();
        List<Integer>levelSum = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            int cursum = 0;
            for(int i=0;i<n;i++){
                TreeNode cur = queue.poll();
                cursum+= cur.val;
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            levelSum.add(cursum);
        }
// Step-2: Update each node value with the cousin sum
        queue.add(root);
        root.val = 0;  // root has no cousins
        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                // levelSum of currentLevel - siblingSum
                int siblingSum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);

                if (curr.left != null) {
                    curr.left.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.right);
                }
            }
            level++;
        }
        return root;
    }
}
