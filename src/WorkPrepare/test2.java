package WorkPrepare;

public class test2 {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (obj1){
                System.out.println("thread1 start lock1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (obj2){
                    System.out.println("thread1 start lock2");
                }
            }
            System.out.println("thread1 end");
        }).start();


        new Thread(() -> {
            synchronized (obj2){
                System.out.println("thread2 start lock2");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (obj1){
                    System.out.println("thread2 start lock1");
                }
            }
            System.out.println("thread2 end");
        }).start();

    }
}

