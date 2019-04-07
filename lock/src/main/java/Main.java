public class Main {
    public static void main(String[] args) throws InterruptedException {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;
        MyThread myThread = new MyThread();
        MyThread1 myThread1 = new MyThread1();
        myThread.resourceA = resourceA;
        myThread1.resourceB = resourceB;
        myThread.start();
        System.out.println("myThread is started");
        myThread1.start();
        System.out.println("myThread1 is started");

    }
}

class MyThread extends Thread {
    ResourceA resourceA;
    @Override
    public void run() {
        try {
            System.out.println(resourceA.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread1 extends Thread {
    ResourceB resourceB;

    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}




