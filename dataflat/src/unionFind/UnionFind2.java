package unionFind;
//第二版并查集 quick union
public class UnionFind2 implements UnionFind{

    private int[] parent;

    public UnionFind2(int size){
        parent=new int[size];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }

    //不停的往根节点去找
    private int find(int p){
        while (p!=parent[p]){
            p=parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnection(int p, int q) {
        if(find(p)==find(q)){
            return true;
        }
        return false;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot){
            return;
        }
        parent[pRoot]=qRoot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
