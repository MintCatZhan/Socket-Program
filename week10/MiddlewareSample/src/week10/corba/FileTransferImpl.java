package week10.corba;
/**
 * FileTransferImpl.java
 *
 *
 * Created: Wed Sep 21 11:34:08 2005
 *
 * @author <a href="mailto:jan.newmarch@infotech.monash.edu.au">Jan Newmarch</a>
 * @version 1.0
 */

import week10.server.FileTransferServerHOPP;

public class FileTransferImpl extends FileTransferPOA {

    private FileTransferServerHOPP serverHOPP = new FileTransferServerHOPP();

    public FileTransferImpl() {
	
    } // FileTransferImpl constructor
    
    public boolean chdir(String dir) {
	return serverHOPP.chdir(dir);
    }

    public String[] dir() {
	return serverHOPP.dir();
    }

    public String getdir() {
	return serverHOPP.getdir();
    }

    public String get(String filename) {
	return serverHOPP.get(filename);
    }

    public void quit() {
	serverHOPP.quit();
    }
} // FileTransferImpl
