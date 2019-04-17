
public class CubbyHole {

    private int[] contents = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private boolean bufferEmpty = true;
    private boolean bufferFull = false;
    private final int size = 10;
    private int counter = 0;
    private int counter2 = 0;

    public synchronized int get() {
        int x = 0;
        while (bufferEmpty == true) {
            try {
                wait();//koimatai mexri na mpei kati sto trapezi
            } catch (InterruptedException e) {
            }
        }

        //elegxos gia to an to thread A kai an to cubbyhole exei timh 1 h 2 wste o A na pernei 1 h 2
        if ((Thread.currentThread().getName().equals("A")) && (contents[counter2] == 1 || contents[counter2] == 2)) {

            x = contents[counter2];//pernw thn timh
            contents[counter2] = 0;//mhdenizw thn sugkekrimenh timh sthn sugkekrimenh thesi wste na mpei allo stoixeio meta
            counter2++;//auksanaw na paw se epomenh thesi

            bufferFull = false;//to trapezi exei pragma panw

        } else if ((Thread.currentThread().getName().equals("B")) && (contents[counter2] == 3 || contents[counter2] == 4)) {//omoiws
            //counter--;
            x = contents[counter2];
            contents[counter2] = 0;
            counter2++;

            bufferFull = false;

        }
        if (counter2 == size)//metrhths wste na mhdenizei to counter2 gia na mn kseperasei to megethos tou pinaka pou einai 10
        {
            counter2 = 0;
        }
        int f = 0;
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] == 0) {
                bufferEmpty = true;//metrhths gia to an to trapezi einai adeio
                f++;

            } else {
                bufferEmpty = false;
            }
        }

        if (f == 0) {
            System.out.println("The buffer is empty");
        }

        notifyAll();//ksupnhma olwn

        return x;//epistrofh timhs

    }

    public synchronized void put(int i) {
        while (bufferFull == true) {
            try {
                wait();//koimatai mexri na mhn einai gemato to trapezi
            } catch (InterruptedException e) {
            }
        }
        bufferEmpty = false;
        if (Thread.currentThread().getName().equals("barista")) {//mono gia barista
            System.out.println("The Barista adds the value " + i + " in the cubbyhole");
            contents[counter] = i;//topothetei stoixeio sto trapezi
            counter++;//epomenh thesi

        } else if (Thread.currentThread().getName().equals("chef")) {//mono gia chef
            System.out.println("The Chef adds the value " + i + " in the cubbyhole");
            contents[counter] = i;
            counter++;

        }
        
        if(counter==size)
        {
            counter=0;
        }
        int l = 0;
        for (int k = 0; k < contents.length; k++)//metrhths gia to an to trapezi einai gemato
        {
            if (contents[k] != 0) {
                l++;
            }
        }

        for (int k = 0; k < contents.length; k++) {
            System.out.println("to trapezi exei sth thesi: " + k + " || " + contents[k]);
        }

        if (l == size) {
            bufferFull = true;
            System.out.println("The cubbyhole is full");
        } else if (counter == size && contents[0] == 0)//an to trapezi den einai gemato tote mhdenizw counter wste to epomeno stoixeio na mpei sth thesi 0 tou pinaka efoson exoume kukliko me texnikh FIFO
        {
            counter = 0;
            if (Thread.currentThread().getName().equals("barista")) {
                System.out.println("The Barista adds the value " + i + " in the cubbyhole");
                contents[counter] = i;
                counter++;

            } else if (Thread.currentThread().getName().equals("chef")) {
                System.out.println("The Chef adds the value " + i + " in the cubbyhole");
                contents[counter] = i;
                counter++;

            }
        }
        notifyAll();//ksupnhma olwn

    }

}
