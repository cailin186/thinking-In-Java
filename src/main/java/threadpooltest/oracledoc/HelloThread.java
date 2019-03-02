package threadpooltest.oracledoc;

public class HelloThread extends Thread {
    @Override
    public void run() {
      testDebug();
    }

    public static void main(String[] args) {
        new HelloThread().start();
    }

}

