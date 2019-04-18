package pattern.behavioral.chainofresponsibility;

/**
 * @ClassName Approver
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:19
 * @Version 1.0
 **/
public abstract class Approver {
    protected Approver approver;

    public void setNextApprover(Approver approver){
        this.approver=approver;
    }

    public abstract void deploy(Course course);
}
