// https://www.hackerrank.com/challenges/java-vistor-pattern
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {

    private int sum = 0;

    @Override
    public int getResult() {
        // implement this
        return sum;
    }

    @Override
    public void visitNode(TreeNode node) {
        // do nothing
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private static final int M = 1000000007;

    @Override
    public int getResult() {
        return (int) product;
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % M;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonleafEvenDepthSum = 0;
    private int greenLeavesSum = 0;

    @Override
    public int getResult() {
        return Math.abs(nonleafEvenDepthSum - greenLeavesSum);
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonleafEvenDepthSum += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class Solution {
    private class GraphTree {
        int[] values;
        Color[] colors;
        HashMap<Integer, HashSet<Integer>> map; // neighbor map

        GraphTree(int numNodes) {
            values = new int[numNodes]; // given: each value >= 1 && <= 1000
            colors = new Color[numNodes]; // given: each color is in the set {0, 1}
            map = new HashMap<>(numNodes);
            for (int i = 0; i < numNodes; i++) {
                map.put(i + 1, new HashSet<>());
            }
        }

        void addNeighborOf(Integer node, Integer newNeighbor) {
            HashSet<Integer> neighbors = map.get(node); // neighbors != null
            neighbors.add(newNeighbor);
        }

        // remove treeNum's parent from its neighbors, only with its children left
        void removeParentMappings(Integer rootNodeNum) {
            for (Integer treeNum : map.get(rootNodeNum)) {
                map.get(treeNum).remove(rootNodeNum);
                removeParentMappings(treeNum);
            }
        }
    }

    static Tree solve() {
        // read the tree from STDIN and return its root as a return value of this function
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt(); // given: 2 <= numNodes <= 100_000
        GraphTree graphTree = new Solution().new GraphTree(numNodes);
        int i;
        for (i = 0; i < numNodes; i++) {
            graphTree.values[i] = scanner.nextInt();
        }
        for (i = 0; i < numNodes; i++) {
            graphTree.colors[i] = scanner.nextInt() == 1 ? Color.GREEN : Color.RED;
        }
        for (i = 1; i <= numNodes - 1; i++) {
            int u = scanner.nextInt(); // given: each u,v >= 1 && <= numNodes
            int v = scanner.nextInt();

            // edge pair <u, v> is undirected,
            // so we create both (u, u's neighbors) and (v, v's neighbors) in the map
            // to make sure that every node mentioned in the input
            // has its complete neighbors in the map
            graphTree.addNeighborOf(u, v); // add u's neighbor v to map
            graphTree.addNeighborOf(v, u); // add v's neighbor u to map
        }
        scanner.close();
        // Now map contains at most numNodes entries with each entries being <node, neighbors>,
        // neighbors may contain the node's parent.

        // Remove the parent mapping (pointing to the parent of a node) in the map
        graphTree.removeParentMappings(1);
        // Now map contains only the children of the nodes: <node, children>

        TreeNode root = new TreeNode(graphTree.values[0], graphTree.colors[0], 0);
        addChildren(root, 1, graphTree);
        return root;
    }

    // recursively add children of the TreeNode parent whose number is parentNum
    // parentNum is used as a key in the neighbor map
    // pre: parent is not a leaf
    // post: a TreeNode or a TreeLeaf is added to the TreeNode parent
    private static void addChildren(TreeNode parent, Integer parentNum, GraphTree graphTree) {
        for (Integer treeNum : graphTree.map.get(parentNum)) {
            // for each children, check if it is a leaf or a non-leaf
            HashSet<Integer> grandchildren = graphTree.map.get(treeNum);
            if (grandchildren.isEmpty()) {
                // no grandchildren, treeNum is a leaf
                TreeLeaf leaf = new TreeLeaf(graphTree.values[treeNum - 1],
                        graphTree.colors[treeNum - 1], parent.getDepth() + 1);
                parent.addChild(leaf);
            } else {
                // treeNum is a non-leaf
                TreeNode node = new TreeNode(graphTree.values[treeNum - 1],
                        graphTree.colors[treeNum - 1], parent.getDepth() + 1);
                parent.addChild(node);

                // recursively add the children of this node
                addChildren(node, treeNum, graphTree);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
