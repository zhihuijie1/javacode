package P4;

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
       Thread t = new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i < 19; i++) {
                   final int a = i;
                   Thread tt = new Thread(new Runnable() {
                       @Override
                       public void run() {
                           System.out.println(a);
                       }
                   });
                   tt.start();
                   try {
                       tt.join();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               System.out.println("19");
           }
       });
       t.start();
       t.join();

        System.out.println("ok");
    }
}
