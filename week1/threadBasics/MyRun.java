package threadBasics;

class MyRun implements Runnable {
	
	public static void main(String args[])
	{
	
	   MyRun run = new MyRun(); 
       new Thread(run).start(); 
 
 }
 
  	public void run() { 
		System.out.println("Hello from MyRun");
 		} 
	} 