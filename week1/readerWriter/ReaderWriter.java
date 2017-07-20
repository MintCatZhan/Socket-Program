package readerWriter;

import java.io.*;

/**
 * This class copies strings from one thread to another.
 * The class ReaderWriter has a field sharedStr that is
 * set by Writer and printed by Reader. The Writer sets a 
 * value, wakes up the Reader. The Writer then waits till 
 * the Reader is finished and then writes another value.
 * The Reader waits till it is woken and then prints the
 * value. It then wakes up the Writer and waits again.
 * The loops terminate when the Writer writes an empty string ""】、
 * 也就是说这个calss是用来从一个线程中复制strings到另一个线程里去。
 * RW这个类有一个叫做sharedStr的field，它是由writer设置、由reader读取的。
 * writer设置一个值，然后叫醒reader来打印。等reader打印结束，writer被叫醒去设置下一个值。
 * 如此循环，知道writer写入一个“”值。
 */
public class ReaderWriter {
    public static String sharedStr;
    public static Object synchObject;
 
    public static void main(String[] args) {
	synchObject = new Object();
	new Reader().start();
	new Writer().start();
    }
}

class Writer extends Thread {
    private String[] lines = {"line 1",
			      "line 2",
			      "line 3",
			      "line 4",
			      ""        // terminating string
    };

    public void run() {
	for (int n = 0; n  < lines.length; n++) {
	    // synch on the shared object
	    synchronized(ReaderWriter.synchObject) { // 这里可以理解为将synchObject -- reader 这个对象给设置成不接受任何外部method处理，也就是lock了它。
			System.out.println("Writer assigning to string");
			ReaderWriter.sharedStr = lines[n];
	
			// another thread synch'ed on 
			// the synchObject can wake up
			System.out.println("Waking up reader");
			ReaderWriter.synchObject.notifyAll(); // notify其他线程可以run
			
	
			// and we wait until we are
			// woken before continuing
			try {
			    System.out.println("Writer waiting");
			    ReaderWriter.synchObject.wait(); // 这里将该对象 -- writer 设置为non-runnable
			} catch(InterruptedException e) {
			    // ignore
			}
		 }
	}
    }
}

class Reader extends Thread {

    public void run() {
		while (true) {
		    synchronized(ReaderWriter.synchObject) {
				// wait until woken before trying
				// to print anything
				try {
				    System.out.println("Reader waiting");
				    ReaderWriter.synchObject.wait();
				} catch(InterruptedException e) {
				    // ignore
				}
		
				if (ReaderWriter.sharedStr.equals("")) {
				    // end of loop. 
				    // wakeup anyone else before breaking
				    // out of loop
				    ReaderWriter.synchObject.notifyAll();
				    break;
				}
		
				System.out.println(ReaderWriter.sharedStr);
				
				// and then tell another thread to wakeup
				ReaderWriter.synchObject.notifyAll();
		    }
		}
    }
}
