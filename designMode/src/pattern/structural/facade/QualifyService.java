package pattern.structural.facade;
//积分校验系统
public class QualifyService {

    public boolean isAvailable(PointGift pointGift){
        System.out.println("校验"+pointGift.getName()+"积分资格通过");
        return true;
    }


}
