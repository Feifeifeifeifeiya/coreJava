package pattern.creational.simpleFactory;

public class VideoFactory {

//    public static Video getNewClass(String type){
//        if("java".equals(type)){
//            return new JavaVideo();
//        }
//        if("python".equals(type)){
//            return new PythonVideo();
//        }
//        return null;
//    }
public static Video getNewClass(Class c){
    Video video=null;
    try {
        video=(Video)Class.forName(c.getName()).newInstance();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return video;
    }
}
