package week10.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import week10.common.FileTransfer;
import week10.common.FileTransferFactory;
import java.rmi.RemoteException;

public class FileTransferClientGUI extends JFrame implements ActionListener {

  private JLabel dirLabel;
  private JList dirList;
  private JButton getBtn;
  private JButton chdirBtn;
  private JButton quitBtn;

  private FileTransfer clientHOPP;

  public static void main(String args[]) {

    if (args.length < 1) {
      System.err.println("Usage: Client args");
      System.exit(1);
    }

    FileTransfer clientHOPP = null;
    try {
      clientHOPP = FileTransferFactory.newClient(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    if (clientHOPP == null) {
      System.out.println("Unknown client type");
      System.exit(2);
    }

    new FileTransferClientGUI(clientHOPP);
  }

  FileTransferClientGUI(FileTransfer clientHOPP) {
    this.clientHOPP = clientHOPP;

    Container pane = getContentPane();

    pane.setLayout(new BorderLayout());

    // directory label in the top
    dirLabel = new JLabel("Current dir:");
    pane.add(BorderLayout.NORTH, dirLabel);

    // directory listing in the middle
    dirList = new JList();
    dirList.setModel(new DefaultListModel());
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.getViewport().setView(dirList);

    pane.add(BorderLayout.CENTER, scrollPane);

    // pane full of buttons in the bottom
    JPanel buttons = new JPanel();
    pane.add(BorderLayout.SOUTH, buttons);

    makeButtons(buttons);

    populateGUI();

    setSize(400, 600);
    setVisible(true);
  }

  private void makeButtons(JPanel buttons) {
    buttons.setLayout(new GridLayout(1, 3));

    getBtn = new JButton("Get");
    chdirBtn = new JButton("Chdir");
    quitBtn = new JButton("Quit");

    buttons.add(getBtn);
    buttons.add(chdirBtn);
    buttons.add(quitBtn);

    getBtn.addActionListener(this);
    chdirBtn.addActionListener(this);
    quitBtn.addActionListener(this);
  }

  public void populateGUI() {
    try {
      String dir = clientHOPP.getdir();
      dirLabel.setText("Current dir: " + dir);
    } catch (RemoteException e) {
      // display warning dialog?
    }

    try {
      String[] list = clientHOPP.dir();
      setDirList(list);
    } catch (RemoteException e) {
      // display warning dialog?
    }
  }

  public void setDirList(String[] list) {
    DefaultListModel model = (DefaultListModel) dirList.getModel();
    System.out.println("Class " + model.getClass().toString());

    model.clear();
    if (list == null) {
      return;
    }

    for (int n = 0; n < list.length; n++) {
      model.addElement(list[n]);
    }
  }

  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();

    if (source == getBtn) {
      try {
        String[] list = clientHOPP.dir();
        setDirList(list);
      } catch (RemoteException e) {
        // display warning dialog
      }
      return;
    }
    if (source == chdirBtn) {
      String dir = (String) dirList.getSelectedValue();
      if (dir == null) {
        return;
      }
      try {
        if (clientHOPP.chdir(dir)) {
          dirLabel.setText("Current dir: " + clientHOPP.getdir());

          String[] list = clientHOPP.dir();
          setDirList(list);
        } else {
          // display warning dialog
        }
      } catch (RemoteException e) {
        // display warning dialog
      }
      return;
    }
    if (source == quitBtn) {
      try {
        clientHOPP.quit();
      } catch (RemoteException e) {
        // display warning dialog?
      }
      System.exit(0);
    }
  }
}
