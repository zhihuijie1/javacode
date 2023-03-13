    public class ThreadDemo1 {
        static class Counter {
            public int count ;
            synchronized public void add() {
                while(true) {
                    System.out.println("add");
                }
            }
            synchronized public void print() {
                while(true) {
                    System.out.println("true");
                }
            }
            public void func() {
                while(true) {
                    System.out.println("func");
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Counter counter = new Counter();
            Thread t1 = new Thread(() -> {
                counter.add();
            });
            Thread t2 = new Thread(() -> {
                counter.print();
            });
            Thread t3 = new Thread(() -> {
                counter.func();
            });

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();
            System.out.println(counter.count);
        }
    }
