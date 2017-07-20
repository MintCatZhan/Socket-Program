package simple;
public class SimpleThread extends Thread {

    protected int base;

    static public void main(String[] argv) {
    	for (int n = 0; n < 3; n++) {
    		new SimpleThread(n).start();
		}
    }

    public SimpleThread(int base) {
    	this.base = base;
    }

    public void run() {
    	int count = 0;
    	while (count < 5) {
		    System.out.println("Thread " + base + " loop " + count);
		    count++;
		    try {
		    	sleep((base + 1) * 1000);
		    } catch(InterruptedException e) {
		    	e.printStackTrace();
		    }
    	}
    	System.out.println("Thread " + base + " finished");
    }
}