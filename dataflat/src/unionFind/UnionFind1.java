package unionFind;
//第一版并查集  quick find
public class UnionFind1 implements UnionFind {

    private int[] id;

    public UnionFind1(int size){
        id=new int[size];
        for(int i=0;i<id.length;i++){
            id[i]=i;
        }
    }

    private int find(int p){
        if(p<0||p>id.length){
            throw new IllegalArgumentException("我不想多说了");
        }
        return id[p];
    }

    @Override
    public boolean isConnection(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        if(find(p)==find(q)){
            return;
        }
        for(int i=0;i<id.length;i++){
            if(id[i]==find(p)){
                id[i]=find(q);
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
