package unionFind;

public interface UnionFind {

    boolean isConnection(int p,int q);

    void unionElements(int p,int q);

    int getSize();
}
