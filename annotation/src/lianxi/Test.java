package lianxi;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 0025 0:19
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args)throws Exception {
        Filter filter1 = new Filter();
        filter1.setId(10);//表示查询id为10的用户

        Filter filter2 = new Filter();
        filter2.setUserName("lucy");//表示模糊查询用户名为lucy的用户

        Filter filter3 = new Filter();
        filter3.setEmail("liu@sina.com,zh@163.com,111@qq.com");//查询邮箱为其中任意一个的用户

        String sql1 = query(filter1);
        String sql2 = query(filter2);
        String sql3 = query(filter3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

    }

    private static String query(Filter filter) throws Exception {
        StringBuffer sb = new StringBuffer();
        Class<? extends Filter> className = filter.getClass();
        boolean annotationPresent = className.isAnnotationPresent(Table.class);
        if(!annotationPresent){
            return null;
        }
        Table table = className.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where ").append("1=1 ");
        Field[] fields = className.getDeclaredFields();
        for(Field field:fields){
            boolean present = field.isAnnotationPresent(Column.class);
            if(!present){
                continue;
            }
            Column annotation = field.getAnnotation(Column.class);
            String columnName = annotation.value();
            //获取字段名
            String filedName = field.getName();
            String getFiledName="get"+filedName.substring(0,1).toUpperCase()+filedName.substring(1);
            Method nameMethod = className.getMethod(getFiledName);
            Object filedValue = nameMethod.invoke(filter);
            //博那个装sql
            if(filedValue==null || filedValue instanceof Integer &&(Integer) filedValue==0){
                continue;
            }
            sb.append(" and ").append(columnName);
            if(filedValue instanceof String ){
                if(((String) filedValue).contains(",")){
                    sb.append(" in (");
                    String[] split = ((String) filedValue).split(",");
                   for(String s:split){
                       sb.append("'").append(s).append("'").append(",");
                   }
                   sb.deleteCharAt(sb.length()-1).append(")").append(";");
                }else{
                    sb.append("=").append("'"+filedValue+"'").append(";");
                }
            }else if(filedValue instanceof Integer){
                sb.append("=").append(filedValue).append(";");
            }

        }
        return sb.toString();
    }
}
