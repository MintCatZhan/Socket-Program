package example.send;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;

import java.rmi.*;
import java.rmi.server.*;

class RMIClient2 extends JFrame
		 implements ActionListener {

   JLabel text, clicked;
   JButton button;
   JPanel panel;
   JTextArea textArea;
   Socket socket = null;
   PrintWriter out = null;
   static Send send;

   RMIClient2(){ //Begin Constructor
     text = new JLabel("Text received:");
     textArea = new JTextArea();
     button = new JButton("Click Me");
     button.addActionListener(this);

     panel = new JPanel();
     panel.setLayout(new BorderLayout());
     panel.setBackground(Color.white);
     getContentPane().add(panel);
     panel.add("North", text);
     panel.add("Center", textArea);
     panel.add("South", button);
   } //End Constructor

  public void actionPerformed(ActionEvent event){
     Object source = event.getSource();

     if(source == button){
        try{
          String text = send.getData();
	  textArea.append(text);
	} catch (java.rmi.RemoteException e) {
	  System.out.println("Cannot access data in server");	
	}
     }
  }
  
   public static void main(String[] args){
        RMIClient2 frame = new RMIClient2();
	frame.setTitle("Client Two");
        WindowListener l = new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                        System.exit(0);
                }
        };

        frame.addWindowListener(l);
        frame.pack();
        frame.setVisible(true);

    if(System.getSecurityManager() == null) {
      System.setSecurityManager(new RMISecurityManager());
    }

    try {
      String name = "//" + args[0] + "/Send";
      send = ((Send) Naming.lookup(name));
    } catch (java.rmi.NotBoundException e) {
      System.out.println("Cannot access data in server");
    } catch(java.rmi.RemoteException e){
      System.out.println("Cannot access data in server");
    } catch(java.net.MalformedURLException e) {
      System.out.println("Cannot access data in server");
    }
  }
}
