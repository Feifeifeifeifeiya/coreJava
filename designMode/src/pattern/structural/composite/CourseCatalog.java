package pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CourseCatalog
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 16:27
 * @Version 1.0
 **/
public class CourseCatalog extends CatalogComponent {
    private List<CatalogComponent> items=new ArrayList<>();
    private String name;
    private Integer level;
    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for(CatalogComponent catalogComponent:items){
            if(this.level!=null){
                for(int i=0;i<this.level;i++){
                    System.out.print("  ");
                }
            }
            System.out.print("  ");
            catalogComponent.print();
        }
    }

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }
}
