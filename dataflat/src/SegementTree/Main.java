package SegementTree;

public class Main {
    public static void main(String[] args) {
        Integer[] nums={-1,2,5,6,7,3};
        SegementTree<Integer> tree = new SegementTree<Integer>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(tree);
        Integer query = tree.query(0, 5);
        System.out.println(query);
    }
}
