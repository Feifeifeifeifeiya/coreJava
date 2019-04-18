package pattern.behavioral.observer;

/**
 * @ClassName Question
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 14:08
 * @Version 1.0
 **/
public class Question {
    private String userName;
    private String questionContent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuestionContent() {

        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
