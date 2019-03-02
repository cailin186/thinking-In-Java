package threadpooltest.reject;

public class Task implements Runnable {

    protected String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " is running.");
            Thread.sleep(500);
        } catch (Exception e) {

        }
    }

}
