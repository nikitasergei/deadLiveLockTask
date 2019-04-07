public class ResourceB {

    private boolean isReady = false;
    ResourceA resourceA;

    public synchronized int getI() {
        return resourceA.returnI();
    }

    public synchronized int returnI() {
        return 1;
    }

    public void doSome(ResourceA resourceA) {
        while (!resourceA.isResourceAReady()) {

            System.out.println("ResourceA waiting for resourceA will ready");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("ResourceB is ready");

        this.isReady = true;
    }

    public boolean isResourceBReady() {
        return this.isReady;
    }

}
