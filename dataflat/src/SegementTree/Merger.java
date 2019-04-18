package SegementTree;

public interface Merger<E> {
    //只定义一个方法，讲两个元素融合成一个元素
    E merge(E a,E b);
}
