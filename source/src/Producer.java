
public class Producer extends Thread {

    private CubbyHole c;
    private int id;
    private int[] vals = {1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2};//pinakas apo paragggelies
    private int[] vals2={3,3,4,3,4,3,3,3,2,4,4,4,4,3,3,3,4,3,4,3};
    //4=makaronada
    //3=tost
    //2=xumos
    //1=kafes

    public Producer(CubbyHole c, int id) {
        this.c = c;
        this.id = id;

    }

    @Override

    public void run() {

            //id=1 paragwgos upeuthinos gia pota
            //id=2 paragwgos upeuthinos gia faghta
            if ((id == 1)) {//an to id=1 kai oi times tou pinaka einai 1 h 2 tote pernei mono o A
                for(int i=0; i<vals.length; i++){
                c.put(vals[i]);
                    try {
                    sleep((int) (Math.random() * 10000));
                    System.out.println("o producer me "+id+" koimatai");
                } catch (InterruptedException e) {
                }
               
                }
            } else if ((id == 2) ) {//alliws o B
                for(int i=0; i<vals2.length; i++){
                c.put(vals2[i]);
                try {
                    sleep((int) (Math.random() * 10000));
                    System.out.println("o producer me "+id+" koimatai");
                } catch (InterruptedException e) {
                }
              
                }
             
               
                
            }
             

        

    }

}
