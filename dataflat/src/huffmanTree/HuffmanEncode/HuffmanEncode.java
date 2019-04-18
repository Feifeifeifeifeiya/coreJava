package huffmanTree.HuffmanEncode;

import java.util.*;

/**
 * @ClassName HuffmanEncode
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/15 0015 22:21
 * @Version 1.0
 **/
public class HuffmanEncode {
    public static void main(String[] args) {
        String msg = "can you can a can as can canner can a can";
        byte[] bytes = msg.getBytes();
        byte[] b = huffmanZip(bytes);
    }

    //赫夫曼编码压缩的方法
    private static byte[] huffmanZip(byte[] bytes) {
        //1统计每个byte出现的次数，并且放入到集合中
        List<Node> nodes = getNodes(bytes);
        //2创建一个赫夫曼树
        Node tree = createHuffmamTree(nodes);
        //3创建一个赫夫曼编码表
        Map<Byte,String> huffCode = getConde(tree);
        //编码
        return bytes;
    }

    static StringBuilder sb = new StringBuilder();
    //3根据霍夫曼编码创建编码表,从根节点开始，向左是0，向右是1，然后递归这个霍夫曼树
    private static Map<Byte,String> getConde(Node tree) {
        if (tree == null){
            return null;
        }
        getConde(tree.getLeft(),"0",sb);
        getConde(tree.getRight(),"1",sb);
        return null;
    }

    private static void getConde(Node left, String s, StringBuilder sb) {
    }

    //2创建赫夫曼树
    private static Node createHuffmamTree(List<Node> nodes) {

        while (nodes.size()>1){
            Collections.sort(nodes);
            //取出最小的作为左子树
            Node left = nodes.get(nodes.size()-1);
            //取出第二小的作为左子树
            Node right = nodes.get(nodes.size()-2);
            Node parent = new Node(null,left.getWeight()+right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(right);
            nodes.remove(left);
            nodes.add(parent);
        }
        return nodes.get(0);


    }

    //把byte数组转化为node集合
    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        //创建一个map统计每一个byte出现的次数
        HashMap<Byte, Integer> counts = new HashMap<>();
        for(byte b:bytes){
            Integer count = counts.get(b);
            if(count==null){
                counts.put(b,1);
          }else {
                counts.put(b,count+1);
            }
        }
        //把每一个键值对转化为node对象
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            Node node = new Node();
            node.setData(entry.getKey());
            node.setWeight(entry.getValue());
            nodes.add(node);
        }
        System.out.println(nodes);
        return nodes;
    }
}
