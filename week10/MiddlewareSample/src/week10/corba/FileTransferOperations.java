package week10.corba;


/**
* week10/corba/FileTransferOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ftp.idl
* Tuesday, August 28, 2012 2:24:38 AM GMT+08:00
*/

public interface FileTransferOperations 
{
  boolean chdir (String dir);
  String[] dir ();
  String getdir ();
  String get (String filename);
  void quit ();
} // interface FileTransferOperations
