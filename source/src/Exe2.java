
public class Exe2 {

    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producer p1 = new Producer(c, 1);
        p1.setName("barista");//metanomasia tou thread
        Producer p2 = new Producer(c, 2);
        p2.setName("chef");
        Consumer c1 = new Consumer(c,"A");
        c1.setName("A");
        Consumer c2 = new Consumer(c,"B");
        c2.setName("B");
        p1.start();  
        c1.start();
        p2.start();
        c2.start();
       

    }

}
