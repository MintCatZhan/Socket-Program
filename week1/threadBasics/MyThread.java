package threadBasics;

class MyThread extends Thread {
	
	public static void main(String args[])
	{
	
	MyThread thr = new MyThread(); 
    thr.start(); 
 }
 
  	public void run() { 
		System.out.println("Hello from MyThread");
 		} 
	} 