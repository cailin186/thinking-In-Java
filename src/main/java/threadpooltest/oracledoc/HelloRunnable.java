package threadpooltest.oracledoc;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hellorunnable");
    }

    public static void main(String[] args) {
        // 从面向接口编程的角度讲,实例化当前类还是runnable接口的属性,new thread的构造函数就是接受一个runnable的实例,是典型的面向接口编程
        (new Thread(new HelloRunnable())).start();
        (new Thread(new HelloRunnable())).start();



    }
}
