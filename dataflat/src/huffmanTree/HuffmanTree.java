package huffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName HuffmanTree
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/15 0015 21:45
 * @Version 1.0
 **/
public class HuffmanTree {
    //给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度达到最小，称这样的二叉树为最优二叉树，
    //也称为哈夫曼树(Huffman Tree)。哈夫曼树是带权路径长度最短的树，权值较大的结点离根较近。
    public static void main(String[] args) {
        int[] arr =new int[]{3,7,8,29,5,11,23,14};
        Node node = crateHuffmanTree(arr);
        System.out.println(node);
    }

    //创建赫夫曼树
    public static Node crateHuffmanTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value:arr){
            nodes.add(new Node(value));
        }
        //循环处理
        while (nodes.size()>1){
            //先排序
            Collections.sort(nodes);
            //取出权值最小的两个数创建一个新的节点作为他们的根节点生成一个新的二叉树
            Node left = nodes.get(nodes.size()-1);
            Node right = nodes.get(nodes.size()-2);
            //创建一个新的二叉树并且加入列表
            nodes.add(new Node(left.getValue()+right.getValue()));
            //删除取出来的那两个数
            nodes.remove(left);
            nodes.remove(right);
        }
        //因为最后就剩下一个数
        return nodes.get(0);
    }
}
