package example.send;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;

import java.rmi.*;
import java.rmi.server.*;

class RMIClient1 extends JFrame
		 implements ActionListener {

   JLabel text, clicked;
   JButton button;
   JPanel panel;
   JTextField textField;
   Socket socket = null;
   PrintWriter out = null;
   static Send send;

   RMIClient1(){ //Begin Constructor
     text = new JLabel("Text to send:");
     textField = new JTextField(20);
     button = new JButton("Click Me");
     button.addActionListener(this);

     panel = new JPanel();
     panel.setLayout(new BorderLayout());
     panel.setBackground(Color.white);
     getContentPane().add(panel);
     panel.add("North", text);
     panel.add("Center", textField);
     panel.add("South", button);
   } //End Constructor

  public void actionPerformed(ActionEvent event){
     Object source = event.getSource();

     if(source == button){
//Send data over socket
        String text = textField.getText();
        try{
          send.sendData(text);
	} catch (java.rmi.RemoteException e) {
	  System.out.println("Cannot send data to server");	
	}
        textField.setText(new String(""));
     }
  }
  
   public static void main(String[] args){
        RMIClient1 frame = new RMIClient1();
	frame.setTitle("Client One");
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
      System.out.println("Cannot look up remote server object");
    } catch(java.rmi.RemoteException e){
      System.out.println("Cannot look up remote server object");
    } catch(java.net.MalformedURLException e) {
      System.out.println("Cannot look up remote server object");
    }
  }
}
