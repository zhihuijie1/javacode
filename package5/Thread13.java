package P1.package5;

// 线程间的通讯
public class Thread13 {
    // 商品内部类
    public static class Product {
        private String brand;
        private String name;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Product p = new Product();
        productThread productThread = new productThread(p);
        CustomerThread customerThread = new CustomerThread(p);
        productThread.start();
        customerThread.start();
    }

}

// 生产者线程
class productThread extends Thread {
    Thread13.Product p;

    public productThread(Thread13.Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                p.setBrand("费列罗");
                p.setName("巧克力");
                System.out.println("生产者生产了: " + p.getBrand() + " " + p.getName());
            } else {
                p.setBrand("青岛");
                p.setName("啤酒");
                System.out.println("生产者生产了: " + p.getBrand() + " " + p.getName());
            }
        }
    }
}

// 消费者线程
class CustomerThread extends Thread {
    Thread13.Product p;

    public CustomerThread(Thread13.Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("消费者消费了: " + p.getBrand() + " " + p.getName());
        }
    }
}