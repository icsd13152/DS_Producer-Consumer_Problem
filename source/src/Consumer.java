
public class Consumer extends Thread {

    private CubbyHole c;
    private String id;

    public Consumer(CubbyHole c, String id) {

        this.c = c;
        this.id = id;
       
    }

    @Override
    public void run() {//methodos pou travaei apo cubbyhole o servitoros
        int x = 0;
        for (int i = 0; i < 40; i++) {
            if (id.equals("A")) {//
                System.out.println("o A servitoros phre to " + c.get());
            } else if (id.equals("B")) {
                System.out.println("o B servitoros phre to " + c.get());
            }
            try {
                int n=(int) (Math.random() * 3000);
                
                sleep(n);
                System.out.println("o servitors "+id+" koimatai");
            } catch (InterruptedException e) {
            }

        }
    }

}
