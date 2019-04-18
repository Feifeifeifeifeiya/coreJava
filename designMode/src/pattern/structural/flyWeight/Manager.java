package pattern.structural.flyWeight;

/**
 * @ClassName Manager
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 14:46
 * @Version 1.0
 **/
public class Manager implements Employee {
    @Override
    public void report() {
        System.out.println(reportContent);
    }

    //哪个部门
    private String department;
    //报告的内容
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
