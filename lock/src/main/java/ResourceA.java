public class ResourceA {

    private boolean isReady = false;
    ResourceB resourceB;

    public synchronized int getI() throws InterruptedException {
        Thread.sleep(1000);
        return resourceB.returnI();
    }

    public synchronized int returnI() {
        return 1;
    }

    public void doSome(ResourceB resourceB) {
        while (!resourceB.isResourceBReady()) {
            System.out.println("Resource B waiting for resourceA will ready");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("ResourceA is ready");
        this.isReady = true;
    }

    public boolean isResourceAReady() {
        return this.isReady;
    }
}
