package week1.adder;

/** 
 * This is a hard way of doing arithmetic:
 * fire off a separate thread for each sum
 * and then synchronize them on a shared object
 * to avoid contention
 */ 

public class Adder extends Thread {

    // static fields are shared by all instances
    // of the Adder class i.e. one field for
    // all instances
    private static Object synchObject;
    private static int sum = 0;

    // non-static fields belong to individual
    // instances of each Adder object i.e.
    // separate fields for each instance
    private int increment;

    public static void main(String[] args) {
       for(int i=0;i<10;i++)
       {
	Adder a1 = new Adder(1);
	Adder a3 = new Adder(3);

	// this could have been set to a1 or a3
	synchObject = new Object();

	// the following should do
	//   sum += 1
	//   sum += 3
	// in an indeterminate order
	a1.start();
	a3.start();
	try {
	    // sleep for long enough for all threads
	    // to complete (hopefully)
	    sleep(1000);
	} catch(InterruptedException e) {
	    // ignore
	}
	// now all threads should have finished
	System.out.println("Final Sum is " + sum);
	//sum=0;
}
    }

    public Adder(int increment) {
	this.increment = increment;
    }

    public void run() {
	synchronized(synchObject) {
	    
	    sum += increment;
	    System.out.println("Intermediate sum is " + sum);
	}
    }
}
