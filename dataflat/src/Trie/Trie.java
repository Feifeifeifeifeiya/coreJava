package Trie;

import java.util.TreeMap;

public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;
        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public int getSize(){
        return size;
    }

    //向trie中添加字符串
    public void add(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur=cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    //查询单词word是否在trie中
    public boolean contains(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return cur.isWord;
    }

    //查询在trie中是否存在前缀prefix
    public boolean containsPre(String prefix){
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return true;
    }

    //匹配单词d..r类型的.代表是任意字符
    public boolean search(String word){
        return match(root,word,0);
    }

    private boolean match(Node node,String word,int index){
        if(index==word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c!='.'){
            if(node.next.get(c)==null){
                return false;
            }
            return match(node.next.get(c),word,index+1);
        }else {
            for(char nextChar:node.next.keySet()){
                if(match(node.next.get(nextChar),word,index+1)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
