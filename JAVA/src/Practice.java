
class A implements Runnable {

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("T1");
    }
}

class B extends Thread {

    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("T2");
    }
}

class Practice {
    public static void main(String[] args) throws InterruptedException {
        Runnable obj = new A();
        B b = new B();
        Thread t1 = new Thread(obj);
        t1.start();
        b.start();
        t1.join();
        System.out.println("hiii");
    }
}
