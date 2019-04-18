public class MyThreadlocal extends ThreadLocal{
    private static final ThreadLocal<Object> threadlocal=new ThreadLocal<>();

    /**
     * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法的值
     */
    @Override
    protected Object initialValue() {
        System.out.println("调用get方法时，当前线程共享变量没有设置，调用initaValue获取默认值！");
        return super.initialValue();
    }

    @Override
    public Object get() {
        return super.get();
    }

    @Override
    public void set(Object value) {
        super.set(value);
    }

    @Override
    public void remove() {
        super.remove();
    }


}
