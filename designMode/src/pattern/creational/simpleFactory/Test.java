package pattern.creational.simpleFactory;

public class Test {
    public static void main(String[] args) {
//        Video video = VideoFactory.getNewClass("java");
//        if(video==null){
//            return;
//        }
//        video.produce();
        Video video = VideoFactory.getNewClass(PythonVideo.class);
        video.produce();
    }
}
