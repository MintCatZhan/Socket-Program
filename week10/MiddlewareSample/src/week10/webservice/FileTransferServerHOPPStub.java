/**
 * FileTransferServerHOPPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package week10.webservice;

/*
 *  FileTransferServerHOPPStub java implementation
 */

public class FileTransferServerHOPPStub extends org.apache.axis2.client.Stub {
  protected org.apache.axis2.description.AxisOperation[] _operations;

  // hashmaps to keep the fault mapping
  private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
  private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
  private java.util.HashMap faultMessageMap = new java.util.HashMap();

  private static int counter = 0;

  private static synchronized java.lang.String getUniqueSuffix() {
    // reset the counter if it is greater than 99999
    if (counter > 99999) {
      counter = 0;
    }
    counter = counter + 1;
    return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_"
        + counter;
  }

  private void populateAxisService() throws org.apache.axis2.AxisFault {

    // creating the Service with a unique name
    _service = new org.apache.axis2.description.AxisService(
        "FileTransferServerHOPP" + getUniqueSuffix());
    addAnonymousOperations();

    // creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[4];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://monash.edu/",
        "dir"));
    _service.addOperation(__operation);

    _operations[0] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://monash.edu/",
        "getdir"));
    _service.addOperation(__operation);

    _operations[1] = __operation;

    __operation = new org.apache.axis2.description.OutOnlyAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://monash.edu/",
        "quit"));
    _service.addOperation(__operation);

    _operations[2] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://monash.edu/",
        "chdir"));
    _service.addOperation(__operation);

    _operations[3] = __operation;

  }

  // populates the faults
  private void populateFaults() {

  }

  /**
   * Constructor that takes in a configContext
   */

  public FileTransferServerHOPPStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
    this(configurationContext, targetEndpoint, false);
  }

  /**
   * Constructor that takes in a configContext and useseperate listner
   */
  public FileTransferServerHOPPStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint, boolean useSeparateListener)
      throws org.apache.axis2.AxisFault {
    // To populate AxisService
    populateAxisService();
    populateFaults();

    _serviceClient = new org.apache.axis2.client.ServiceClient(
        configurationContext, _service);

    _serviceClient.getOptions().setTo(
        new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
    _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

    // Set the soap version
    _serviceClient.getOptions().setSoapVersionURI(
        org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

  }

  /**
   * Default Constructor
   */
  public FileTransferServerHOPPStub(
      org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault {

    this(configurationContext,
        "http://localhost:8080/axis2/services/FileTransferServerHOPP");

  }

  /**
   * Default Constructor
   */
  public FileTransferServerHOPPStub() throws org.apache.axis2.AxisFault {

    this("http://localhost:8080/axis2/services/FileTransferServerHOPP");

  }

  /**
   * Constructor taking the target endpoint
   */
  public FileTransferServerHOPPStub(java.lang.String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(null, targetEndpoint);
  }

  /**
   * Auto generated method signature
   * 
   * @see week10.webservice.FileTransferServerHOPP#dir
   * @param dir0
   */

  public week10.webservice.FileTransferServerHOPPStub.DirResponse dir(

  week10.webservice.FileTransferServerHOPPStub.Dir dir0)

  throws java.rmi.RemoteException

  {
    org.apache.axis2.context.MessageContext _messageContext = null;
    try {
      org.apache.axis2.client.OperationClient _operationClient = _serviceClient
          .createClient(_operations[0].getName());
      _operationClient.getOptions().setAction("urn:dir");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create a message context
      _messageContext = new org.apache.axis2.context.MessageContext();

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env = toEnvelope(getFactory(_operationClient.getOptions()
          .getSoapVersionURI()), dir0,
          optimizeContent(new javax.xml.namespace.QName("http://monash.edu/",
              "dir")), new javax.xml.namespace.QName("http://monash.edu/",
              "dir"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
          .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
          .getEnvelope();

      java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
          week10.webservice.FileTransferServerHOPPStub.DirResponse.class,
          getEnvelopeNamespaces(_returnEnv));

      return (week10.webservice.FileTransferServerHOPPStub.DirResponse) object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap
            .containsKey(new org.apache.axis2.client.FaultMapKey(faultElt
                .getQName(), "dir"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt
                    .getQName(), "dir"));
            java.lang.Class exceptionClass = java.lang.Class
                .forName(exceptionClassName);
            java.lang.reflect.Constructor constructor = exceptionClass
                .getConstructor(String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor
                .newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName = (java.lang.String) faultMessageMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt
                    .getQName(), "dir"));
            java.lang.Class messageClass = java.lang.Class
                .forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass,
                null);
            java.lang.reflect.Method m = exceptionClass.getMethod(
                "setFaultMessage", new java.lang.Class[] { messageClass });
            m.invoke(ex, new java.lang.Object[] { messageObject });

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   * 
   * @see week10.webservice.FileTransferServerHOPP#startdir
   * @param dir0
   */
  public void startdir(

  week10.webservice.FileTransferServerHOPPStub.Dir dir0,

  final week10.webservice.FileTransferServerHOPPCallbackHandler callback)

  throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient = _serviceClient
        .createClient(_operations[0].getName());
    _operationClient.getOptions().setAction("urn:dir");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env = toEnvelope(getFactory(_operationClient.getOptions()
        .getSoapVersionURI()), dir0,
        optimizeContent(new javax.xml.namespace.QName("http://monash.edu/",
            "dir")), new javax.xml.namespace.QName("http://monash.edu/", "dir"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient
        .setCallback(new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(
              org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
                  .getEnvelope();

              java.lang.Object object = fromOM(
                  resultEnv.getBody().getFirstElement(),
                  week10.webservice.FileTransferServerHOPPStub.DirResponse.class,
                  getEnvelopeNamespaces(resultEnv));
              callback
                  .receiveResultdir((week10.webservice.FileTransferServerHOPPStub.DirResponse) object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrordir(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap
                    .containsKey(new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "dir"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
                        .get(new org.apache.axis2.client.FaultMapKey(faultElt
                            .getQName(), "dir"));
                    java.lang.Class exceptionClass = java.lang.Class
                        .forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor = exceptionClass
                        .getConstructor(String.class);
                    java.lang.Exception ex = (java.lang.Exception) constructor
                        .newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName = (java.lang.String) faultMessageMap
                        .get(new org.apache.axis2.client.FaultMapKey(faultElt
                            .getQName(), "dir"));
                    java.lang.Class messageClass = java.lang.Class
                        .forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt,
                        messageClass, null);
                    java.lang.reflect.Method m = exceptionClass.getMethod(
                        "setFaultMessage",
                        new java.lang.Class[] { messageClass });
                    m.invoke(ex, new java.lang.Object[] { messageObject });

                    callback.receiveErrordir(new java.rmi.RemoteException(ex
                        .getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrordir(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrordir(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrordir(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrordir(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrordir(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrordir(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrordir(f);
                  }
                } else {
                  callback.receiveErrordir(f);
                }
              } else {
                callback.receiveErrordir(f);
              }
            } else {
              callback.receiveErrordir(error);
            }
          }

          public void onFault(
              org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
                .getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender()
                  .cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrordir(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[0].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[0].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);

  }

  /**
   * Auto generated method signature
   * 
   * @see week10.webservice.FileTransferServerHOPP#getdir
   * @param getdir2
   */

  public week10.webservice.FileTransferServerHOPPStub.GetdirResponse getdir(

  week10.webservice.FileTransferServerHOPPStub.Getdir getdir2)

  throws java.rmi.RemoteException

  {
    org.apache.axis2.context.MessageContext _messageContext = null;
    try {
      org.apache.axis2.client.OperationClient _operationClient = _serviceClient
          .createClient(_operations[1].getName());
      _operationClient.getOptions().setAction("urn:getdir");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create a message context
      _messageContext = new org.apache.axis2.context.MessageContext();

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env = toEnvelope(getFactory(_operationClient.getOptions()
          .getSoapVersionURI()), getdir2,
          optimizeContent(new javax.xml.namespace.QName("http://monash.edu/",
              "getdir")), new javax.xml.namespace.QName("http://monash.edu/",
              "getdir"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
          .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
          .getEnvelope();

      java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
          week10.webservice.FileTransferServerHOPPStub.GetdirResponse.class,
          getEnvelopeNamespaces(_returnEnv));

      return (week10.webservice.FileTransferServerHOPPStub.GetdirResponse) object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap
            .containsKey(new org.apache.axis2.client.FaultMapKey(faultElt
                .getQName(), "getdir"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt
                    .getQName(), "getdir"));
            java.lang.Class exceptionClass = java.lang.Class
                .forName(exceptionClassName);
            java.lang.reflect.Constructor constructor = exceptionClass
                .getConstructor(String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor
                .newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName = (java.lang.String) faultMessageMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt
                    .getQName(), "getdir"));
            java.lang.Class messageClass = java.lang.Class
                .forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass,
                null);
            java.lang.reflect.Method m = exceptionClass.getMethod(
                "setFaultMessage", new java.lang.Class[] { messageClass });
            m.invoke(ex, new java.lang.Object[] { messageObject });

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   * 
   * @see week10.webservice.FileTransferServerHOPP#startgetdir
   * @param getdir2
   */
  public void startgetdir(

  week10.webservice.FileTransferServerHOPPStub.Getdir getdir2,

  final week10.webservice.FileTransferServerHOPPCallbackHandler callback)

  throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient = _serviceClient
        .createClient(_operations[1].getName());
    _operationClient.getOptions().setAction("urn:getdir");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env = toEnvelope(getFactory(_operationClient.getOptions()
        .getSoapVersionURI()), getdir2,
        optimizeContent(new javax.xml.namespace.QName("http://monash.edu/",
            "getdir")), new javax.xml.namespace.QName("http://monash.edu/",
            "getdir"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient
        .setCallback(new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(
              org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
                  .getEnvelope();

              java.lang.Object object = fromOM(
                  resultEnv.getBody().getFirstElement(),
                  week10.webservice.FileTransferServerHOPPStub.GetdirResponse.class,
                  getEnvelopeNamespaces(resultEnv));
              callback
                  .receiveResultgetdir((week10.webservice.FileTransferServerHOPPStub.GetdirResponse) object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorgetdir(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap
                    .containsKey(new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getdir"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
                        .get(new org.apache.axis2.client.FaultMapKey(faultElt
                            .getQName(), "getdir"));
                    java.lang.Class exceptionClass = java.lang.Class
                        .forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor = exceptionClass
                        .getConstructor(String.class);
                    java.lang.Exception ex = (java.lang.Exception) constructor
                        .newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName = (java.lang.String) faultMessageMap
                        .get(new org.apache.axis2.client.FaultMapKey(faultElt
                            .getQName(), "getdir"));
                    java.lang.Class messageClass = java.lang.Class
                        .forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt,
                        messageClass, null);
                    java.lang.reflect.Method m = exceptionClass.getMethod(
                        "setFaultMessage",
                        new java.lang.Class[] { messageClass });
                    m.invoke(ex, new java.lang.Object[] { messageObject });

                    callback.receiveErrorgetdir(new java.rmi.RemoteException(ex
                        .getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorgetdir(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorgetdir(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorgetdir(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorgetdir(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorgetdir(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorgetdir(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorgetdir(f);
                  }
                } else {
                  callback.receiveErrorgetdir(f);
                }
              } else {
                callback.receiveErrorgetdir(f);
              }
            } else {
              callback.receiveErrorgetdir(error);
            }
          }

          public void onFault(
              org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
                .getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender()
                  .cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorgetdir(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[1].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[1].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);

  }

  /**
   * Auto generated method signature
   * 
   */
  public void quit(week10.webservice.FileTransferServerHOPPStub.Quit quit4

  ) throws java.rmi.RemoteException

  {
    org.apache.axis2.context.MessageContext _messageContext = null;

    org.apache.axis2.client.OperationClient _operationClient = _serviceClient
        .createClient(_operations[2].getName());
    _operationClient.getOptions().setAction("urn:quit");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    org.apache.axiom.soap.SOAPEnvelope env = null;
    _messageContext = new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env = toEnvelope(getFactory(_operationClient.getOptions()
        .getSoapVersionURI()), quit4,
        optimizeContent(new javax.xml.namespace.QName("http://monash.edu/",
            "quit")), new javax.xml.namespace.QName("http://monash.edu/",
            "quit"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope

    _messageContext.setEnvelope(env);

    // add the message contxt to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.execute(true);

    if (_messageContext.getTransportOut() != null) {
      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
    }

    return;
  }

  /**
   * Auto generated method signature
   * 
   * @see week10.webservice.FileTransferServerHOPP#chdir
   * @param chdir5
   */

  public week10.webservice.FileTransferServerHOPPStub.ChdirResponse chdir(

  week10.webservice.FileTransferServerHOPPStub.Chdir chdir5)

  throws java.rmi.RemoteException

  {
    org.apache.axis2.context.MessageContext _messageContext = null;
    try {
      org.apache.axis2.client.OperationClient _operationClient = _serviceClient
          .createClient(_operations[3].getName());
      _operationClient.getOptions().setAction("urn:chdir");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create a message context
      _messageContext = new org.apache.axis2.context.MessageContext();

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env = toEnvelope(getFactory(_operationClient.getOptions()
          .getSoapVersionURI()), chdir5,
          optimizeContent(new javax.xml.namespace.QName("http://monash.edu/",
              "chdir")), new javax.xml.namespace.QName("http://monash.edu/",
              "chdir"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
          .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
          .getEnvelope();

      java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
          week10.webservice.FileTransferServerHOPPStub.ChdirResponse.class,
          getEnvelopeNamespaces(_returnEnv));

      return (week10.webservice.FileTransferServerHOPPStub.ChdirResponse) object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap
            .containsKey(new org.apache.axis2.client.FaultMapKey(faultElt
                .getQName(), "chdir"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt
                    .getQName(), "chdir"));
            java.lang.Class exceptionClass = java.lang.Class
                .forName(exceptionClassName);
            java.lang.reflect.Constructor constructor = exceptionClass
                .getConstructor(String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor
                .newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName = (java.lang.String) faultMessageMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt
                    .getQName(), "chdir"));
            java.lang.Class messageClass = java.lang.Class
                .forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass,
                null);
            java.lang.reflect.Method m = exceptionClass.getMethod(
                "setFaultMessage", new java.lang.Class[] { messageClass });
            m.invoke(ex, new java.lang.Object[] { messageObject });

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   * 
   * @see week10.webservice.FileTransferServerHOPP#startchdir
   * @param chdir5
   */
  public void startchdir(

  week10.webservice.FileTransferServerHOPPStub.Chdir chdir5,

  final week10.webservice.FileTransferServerHOPPCallbackHandler callback)

  throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient = _serviceClient
        .createClient(_operations[3].getName());
    _operationClient.getOptions().setAction("urn:chdir");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env = toEnvelope(getFactory(_operationClient.getOptions()
        .getSoapVersionURI()), chdir5,
        optimizeContent(new javax.xml.namespace.QName("http://monash.edu/",
            "chdir")), new javax.xml.namespace.QName("http://monash.edu/",
            "chdir"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient
        .setCallback(new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(
              org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
                  .getEnvelope();

              java.lang.Object object = fromOM(
                  resultEnv.getBody().getFirstElement(),
                  week10.webservice.FileTransferServerHOPPStub.ChdirResponse.class,
                  getEnvelopeNamespaces(resultEnv));
              callback
                  .receiveResultchdir((week10.webservice.FileTransferServerHOPPStub.ChdirResponse) object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorchdir(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap
                    .containsKey(new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "chdir"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
                        .get(new org.apache.axis2.client.FaultMapKey(faultElt
                            .getQName(), "chdir"));
                    java.lang.Class exceptionClass = java.lang.Class
                        .forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor = exceptionClass
                        .getConstructor(String.class);
                    java.lang.Exception ex = (java.lang.Exception) constructor
                        .newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName = (java.lang.String) faultMessageMap
                        .get(new org.apache.axis2.client.FaultMapKey(faultElt
                            .getQName(), "chdir"));
                    java.lang.Class messageClass = java.lang.Class
                        .forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt,
                        messageClass, null);
                    java.lang.reflect.Method m = exceptionClass.getMethod(
                        "setFaultMessage",
                        new java.lang.Class[] { messageClass });
                    m.invoke(ex, new java.lang.Object[] { messageObject });

                    callback.receiveErrorchdir(new java.rmi.RemoteException(ex
                        .getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorchdir(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorchdir(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorchdir(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorchdir(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorchdir(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorchdir(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis
                    // fault
                    callback.receiveErrorchdir(f);
                  }
                } else {
                  callback.receiveErrorchdir(f);
                }
              } else {
                callback.receiveErrorchdir(f);
              }
            } else {
              callback.receiveErrorchdir(error);
            }
          }

          public void onFault(
              org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
                .getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender()
                  .cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorchdir(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[3].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[3].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);

  }

  /**
   * A utility method that copies the namepaces from the SOAPEnvelope
   */
  private java.util.Map getEnvelopeNamespaces(
      org.apache.axiom.soap.SOAPEnvelope env) {
    java.util.Map returnMap = new java.util.HashMap();
    java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
    while (namespaceIterator.hasNext()) {
      org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator
          .next();
      returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
    }
    return returnMap;
  }

  private javax.xml.namespace.QName[] opNameArray = null;

  private boolean optimizeContent(javax.xml.namespace.QName opName) {

    if (opNameArray == null) {
      return false;
    }
    for (int i = 0; i < opNameArray.length; i++) {
      if (opName.equals(opNameArray[i])) {
        return true;
      }
    }
    return false;
  }

  // http://localhost:8080/axis2/services/FileTransferServerHOPP
  public static class Chdir implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
        "http://monash.edu/xsd", "chdir", "ns1");

    /**
     * field for Dir
     */

    protected java.lang.String localDir;

    /*
     * This tracker boolean wil be used to detect whether the user called the
     * set method for this attribute. It will be used to determine whether to
     * include this field in the serialized XML
     */
    protected boolean localDirTracker = false;

    public boolean isDirSpecified() {
      return localDirTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getDir() {
      return localDir;
    }

    /**
     * Auto generated setter method
     * 
     * @param param
     *          Dir
     */
    public void setDir(java.lang.String param) {
      localDirTracker = true;

      this.localDir = param;

    }

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
          this, MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
          xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
            "http://monash.edu/xsd");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", namespacePrefix + ":chdir", xmlWriter);
        } else {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", "chdir", xmlWriter);
        }

      }
      if (localDirTracker) {
        namespace = "http://monash.edu/xsd";
        writeStartElement(null, namespace, "dir", xmlWriter);

        if (localDir == null) {
          // write the nil attribute

          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "nil", "1", xmlWriter);

        } else {

          xmlWriter.writeCharacters(localDir);

        }

        xmlWriter.writeEndElement();
      }
      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://monash.edu/xsd")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(namespace, localPart);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (xmlWriter.getPrefix(namespace) == null) {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter
          .getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        }

      } else {
        xmlWriter
            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible
        // to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil
                          .convertToString(qnames[i]));
            } else {
              stringToWrite
                  .append(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(qnames[i]));
            }
          } else {
            stringToWrite
                .append(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter
            .getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil
              .getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     * 
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      if (localDirTracker) {
        elementList.add(new javax.xml.namespace.QName("http://monash.edu/xsd",
            "dir"));

        elementList.add(localDir == null ? null
            : org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(localDir));
      }

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
          qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

      /**
       * static method to create the object Precondition: If this object is an
       * element, the current or next start element starts this object and any
       * intervening reader events are ignorable If this object is not an
       * element, it is a complex type and the reader is at the event just after
       * the outer start element Postcondition: If this object is an element,
       * the reader is positioned at its end element If this object is a complex
       * type, the reader is positioned at the end element of its outer element
       */
      public static Chdir parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        Chdir object = new Chdir();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue(
              "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName
                  .indexOf(":") + 1);

              if (!"chdir".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext()
                    .getNamespaceURI(nsPrefix);
                return (Chdir) ExtensionMapper.getTypeObject(nsUri, type,
                    reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal
          // attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("http://monash.edu/xsd", "dir")
                  .equals(reader.getName())) {

            nillableValue = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setDir(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element

          else {

          }

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid
            // property
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }// end of factory class

  }

  public static class Getdir implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
        "http://monash.edu/xsd", "getdir", "ns1");

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
          this, MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
          xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
            "http://monash.edu/xsd");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", namespacePrefix + ":getdir", xmlWriter);
        } else {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", "getdir", xmlWriter);
        }

      }

      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://monash.edu/xsd")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(namespace, localPart);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (xmlWriter.getPrefix(namespace) == null) {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter
          .getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        }

      } else {
        xmlWriter
            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible
        // to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil
                          .convertToString(qnames[i]));
            } else {
              stringToWrite
                  .append(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(qnames[i]));
            }
          } else {
            stringToWrite
                .append(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter
            .getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil
              .getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     * 
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
          qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

      /**
       * static method to create the object Precondition: If this object is an
       * element, the current or next start element starts this object and any
       * intervening reader events are ignorable If this object is not an
       * element, it is a complex type and the reader is at the event just after
       * the outer start element Postcondition: If this object is an element,
       * the reader is positioned at its end element If this object is a complex
       * type, the reader is positioned at the end element of its outer element
       */
      public static Getdir parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        Getdir object = new Getdir();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue(
              "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName
                  .indexOf(":") + 1);

              if (!"getdir".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext()
                    .getNamespaceURI(nsPrefix);
                return (Getdir) ExtensionMapper.getTypeObject(nsUri, type,
                    reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal
          // attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid
            // property
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }// end of factory class

  }

  public static class DirResponse implements
      org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
        "http://monash.edu/xsd", "dirResponse", "ns1");

    /**
     * field for _return This was an Array!
     */

    protected java.lang.String[] local_return;

    /*
     * This tracker boolean wil be used to detect whether the user called the
     * set method for this attribute. It will be used to determine whether to
     * include this field in the serialized XML
     */
    protected boolean local_returnTracker = false;

    public boolean is_returnSpecified() {
      return local_returnTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String[]
     */
    public java.lang.String[] get_return() {
      return local_return;
    }

    /**
     * validate the array for _return
     */
    protected void validate_return(java.lang.String[] param) {

    }

    /**
     * Auto generated setter method
     * 
     * @param param
     *          _return
     */
    public void set_return(java.lang.String[] param) {

      validate_return(param);

      local_returnTracker = true;

      this.local_return = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param
     *          java.lang.String
     */
    public void add_return(java.lang.String param) {
      if (local_return == null) {
        local_return = new java.lang.String[] {};
      }

      // update the setting tracker
      local_returnTracker = true;

      java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
          .toList(local_return);
      list.add(param);
      this.local_return = (java.lang.String[]) list
          .toArray(new java.lang.String[list.size()]);

    }

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
          this, MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
          xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
            "http://monash.edu/xsd");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", namespacePrefix + ":dirResponse", xmlWriter);
        } else {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", "dirResponse", xmlWriter);
        }

      }
      if (local_returnTracker) {
        if (local_return != null) {
          namespace = "http://monash.edu/xsd";
          for (int i = 0; i < local_return.length; i++) {

            if (local_return[i] != null) {

              writeStartElement(null, namespace, "return", xmlWriter);

              xmlWriter
                  .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(local_return[i]));

              xmlWriter.writeEndElement();

            } else {

              // write null attribute
              namespace = "http://monash.edu/xsd";
              writeStartElement(null, namespace, "return", xmlWriter);
              writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                  xmlWriter);
              xmlWriter.writeEndElement();

            }

          }
        } else {

          // write the null attribute
          // write null attribute
          writeStartElement(null, "http://monash.edu/xsd", "return", xmlWriter);

          // write the nil attribute
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "nil", "1", xmlWriter);
          xmlWriter.writeEndElement();

        }

      }
      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://monash.edu/xsd")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(namespace, localPart);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (xmlWriter.getPrefix(namespace) == null) {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter
          .getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        }

      } else {
        xmlWriter
            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible
        // to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil
                          .convertToString(qnames[i]));
            } else {
              stringToWrite
                  .append(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(qnames[i]));
            }
          } else {
            stringToWrite
                .append(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter
            .getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil
              .getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     * 
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      if (local_returnTracker) {
        if (local_return != null) {
          for (int i = 0; i < local_return.length; i++) {

            if (local_return[i] != null) {
              elementList.add(new javax.xml.namespace.QName(
                  "http://monash.edu/xsd", "return"));
              elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(local_return[i]));
            } else {

              elementList.add(new javax.xml.namespace.QName(
                  "http://monash.edu/xsd", "return"));
              elementList.add(null);

            }

          }
        } else {

          elementList.add(new javax.xml.namespace.QName(
              "http://monash.edu/xsd", "return"));
          elementList.add(null);

        }

      }

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
          qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

      /**
       * static method to create the object Precondition: If this object is an
       * element, the current or next start element starts this object and any
       * intervening reader events are ignorable If this object is not an
       * element, it is a complex type and the reader is at the event just after
       * the outer start element Postcondition: If this object is an element,
       * the reader is positioned at its end element If this object is a complex
       * type, the reader is positioned at the end element of its outer element
       */
      public static DirResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        DirResponse object = new DirResponse();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue(
              "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName
                  .indexOf(":") + 1);

              if (!"dirResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext()
                    .getNamespaceURI(nsPrefix);
                return (DirResponse) ExtensionMapper.getTypeObject(nsUri, type,
                    reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal
          // attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          java.util.ArrayList list1 = new java.util.ArrayList();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("http://monash.edu/xsd",
                  "return").equals(reader.getName())) {

            // Process the array and step past its final element's end.

            nillableValue = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "nil");
            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
              list1.add(null);

              reader.next();
            } else {
              list1.add(reader.getElementText());
            }
            // loop until we find a start element that is not part of this array
            boolean loopDone1 = false;
            while (!loopDone1) {
              // Ensure we are at the EndElement
              while (!reader.isEndElement()) {
                reader.next();
              }
              // Step out of this element
              reader.next();
              // Step to next element event.
              while (!reader.isStartElement() && !reader.isEndElement())
                reader.next();
              if (reader.isEndElement()) {
                // two continuous end elements means we are exiting the xml
                // structure
                loopDone1 = true;
              } else {
                if (new javax.xml.namespace.QName("http://monash.edu/xsd",
                    "return").equals(reader.getName())) {

                  nillableValue = reader.getAttributeValue(
                      "http://www.w3.org/2001/XMLSchema-instance", "nil");
                  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                    list1.add(null);

                    reader.next();
                  } else {
                    list1.add(reader.getElementText());
                  }
                } else {
                  loopDone1 = true;
                }
              }
            }
            // call the converter utility to convert and set the array

            object.set_return((java.lang.String[]) list1
                .toArray(new java.lang.String[list1.size()]));

          } // End of if for expected property start element

          else {

          }

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid
            // property
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }// end of factory class

  }

  public static class ChdirResponse implements
      org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
        "http://monash.edu/xsd", "chdirResponse", "ns1");

    /**
     * field for _return
     */

    protected boolean local_return;

    /*
     * This tracker boolean wil be used to detect whether the user called the
     * set method for this attribute. It will be used to determine whether to
     * include this field in the serialized XML
     */
    protected boolean local_returnTracker = false;

    public boolean is_returnSpecified() {
      return local_returnTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return boolean
     */
    public boolean get_return() {
      return local_return;
    }

    /**
     * Auto generated setter method
     * 
     * @param param
     *          _return
     */
    public void set_return(boolean param) {

      // setting primitive attribute tracker to true
      local_returnTracker = true;

      this.local_return = param;

    }

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
          this, MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
          xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
            "http://monash.edu/xsd");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", namespacePrefix + ":chdirResponse", xmlWriter);
        } else {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", "chdirResponse", xmlWriter);
        }

      }
      if (local_returnTracker) {
        namespace = "http://monash.edu/xsd";
        writeStartElement(null, namespace, "return", xmlWriter);

        if (false) {

          throw new org.apache.axis2.databinding.ADBException(
              "return cannot be null!!");

        } else {
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(local_return));
        }

        xmlWriter.writeEndElement();
      }
      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://monash.edu/xsd")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(namespace, localPart);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (xmlWriter.getPrefix(namespace) == null) {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter
          .getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        }

      } else {
        xmlWriter
            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible
        // to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil
                          .convertToString(qnames[i]));
            } else {
              stringToWrite
                  .append(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(qnames[i]));
            }
          } else {
            stringToWrite
                .append(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter
            .getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil
              .getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     * 
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      if (local_returnTracker) {
        elementList.add(new javax.xml.namespace.QName("http://monash.edu/xsd",
            "return"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString(local_return));
      }

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
          qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

      /**
       * static method to create the object Precondition: If this object is an
       * element, the current or next start element starts this object and any
       * intervening reader events are ignorable If this object is not an
       * element, it is a complex type and the reader is at the event just after
       * the outer start element Postcondition: If this object is an element,
       * the reader is positioned at its end element If this object is a complex
       * type, the reader is positioned at the end element of its outer element
       */
      public static ChdirResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        ChdirResponse object = new ChdirResponse();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue(
              "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName
                  .indexOf(":") + 1);

              if (!"chdirResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext()
                    .getNamespaceURI(nsPrefix);
                return (ChdirResponse) ExtensionMapper.getTypeObject(nsUri,
                    type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal
          // attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("http://monash.edu/xsd",
                  "return").equals(reader.getName())) {

            nillableValue = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "nil");
            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
              throw new org.apache.axis2.databinding.ADBException(
                  "The element: " + "return" + "  cannot be null");
            }

            java.lang.String content = reader.getElementText();

            object.set_return(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToBoolean(content));

            reader.next();

          } // End of if for expected property start element

          else {

          }

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid
            // property
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }// end of factory class

  }

  public static class ExtensionMapper {

    public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
        java.lang.String typeName, javax.xml.stream.XMLStreamReader reader)
        throws java.lang.Exception {

      throw new org.apache.axis2.databinding.ADBException("Unsupported type "
          + namespaceURI + " " + typeName);
    }

  }

  public static class Quit implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
        "http://monash.edu/xsd", "quit", "ns1");

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
          this, MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
          xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
            "http://monash.edu/xsd");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", namespacePrefix + ":quit", xmlWriter);
        } else {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", "quit", xmlWriter);
        }

      }

      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://monash.edu/xsd")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(namespace, localPart);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (xmlWriter.getPrefix(namespace) == null) {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter
          .getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        }

      } else {
        xmlWriter
            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible
        // to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil
                          .convertToString(qnames[i]));
            } else {
              stringToWrite
                  .append(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(qnames[i]));
            }
          } else {
            stringToWrite
                .append(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter
            .getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil
              .getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     * 
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
          qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

      /**
       * static method to create the object Precondition: If this object is an
       * element, the current or next start element starts this object and any
       * intervening reader events are ignorable If this object is not an
       * element, it is a complex type and the reader is at the event just after
       * the outer start element Postcondition: If this object is an element,
       * the reader is positioned at its end element If this object is a complex
       * type, the reader is positioned at the end element of its outer element
       */
      public static Quit parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        Quit object = new Quit();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue(
              "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName
                  .indexOf(":") + 1);

              if (!"quit".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext()
                    .getNamespaceURI(nsPrefix);
                return (Quit) ExtensionMapper
                    .getTypeObject(nsUri, type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal
          // attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid
            // property
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }// end of factory class

  }

  public static class Dir implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
        "http://monash.edu/xsd", "dir", "ns1");

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
          this, MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
          xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
            "http://monash.edu/xsd");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", namespacePrefix + ":dir", xmlWriter);
        } else {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", "dir", xmlWriter);
        }

      }

      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://monash.edu/xsd")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(namespace, localPart);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (xmlWriter.getPrefix(namespace) == null) {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter
          .getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        }

      } else {
        xmlWriter
            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible
        // to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil
                          .convertToString(qnames[i]));
            } else {
              stringToWrite
                  .append(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(qnames[i]));
            }
          } else {
            stringToWrite
                .append(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter
            .getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil
              .getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     * 
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
          qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

      /**
       * static method to create the object Precondition: If this object is an
       * element, the current or next start element starts this object and any
       * intervening reader events are ignorable If this object is not an
       * element, it is a complex type and the reader is at the event just after
       * the outer start element Postcondition: If this object is an element,
       * the reader is positioned at its end element If this object is a complex
       * type, the reader is positioned at the end element of its outer element
       */
      public static Dir parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        Dir object = new Dir();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue(
              "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName
                  .indexOf(":") + 1);

              if (!"dir".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext()
                    .getNamespaceURI(nsPrefix);
                return (Dir) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal
          // attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid
            // property
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }// end of factory class

  }

  public static class GetdirResponse implements
      org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
        "http://monash.edu/xsd", "getdirResponse", "ns1");

    /**
     * field for _return
     */

    protected java.lang.String local_return;

    /*
     * This tracker boolean wil be used to detect whether the user called the
     * set method for this attribute. It will be used to determine whether to
     * include this field in the serialized XML
     */
    protected boolean local_returnTracker = false;

    public boolean is_returnSpecified() {
      return local_returnTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String get_return() {
      return local_return;
    }

    /**
     * Auto generated setter method
     * 
     * @param param
     *          _return
     */
    public void set_return(java.lang.String param) {
      local_returnTracker = true;

      this.local_return = param;

    }

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
          this, MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
          xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter,
            "http://monash.edu/xsd");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", namespacePrefix + ":getdirResponse", xmlWriter);
        } else {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "type", "getdirResponse", xmlWriter);
        }

      }
      if (local_returnTracker) {
        namespace = "http://monash.edu/xsd";
        writeStartElement(null, namespace, "return", xmlWriter);

        if (local_return == null) {
          // write the nil attribute

          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
              "nil", "1", xmlWriter);

        } else {

          xmlWriter.writeCharacters(local_return);

        }

        xmlWriter.writeEndElement();
      }
      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://monash.edu/xsd")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(namespace, localPart);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (xmlWriter.getPrefix(namespace) == null) {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter
          .getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter
              .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qname));
        }

      } else {
        xmlWriter
            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible
        // to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil
                          .convertToString(qnames[i]));
            } else {
              stringToWrite
                  .append(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(qnames[i]));
            }
          } else {
            stringToWrite
                .append(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter
            .getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil
              .getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     * 
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      if (local_returnTracker) {
        elementList.add(new javax.xml.namespace.QName("http://monash.edu/xsd",
            "return"));

        elementList.add(local_return == null ? null
            : org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(local_return));
      }

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
          qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

      /**
       * static method to create the object Precondition: If this object is an
       * element, the current or next start element starts this object and any
       * intervening reader events are ignorable If this object is not an
       * element, it is a complex type and the reader is at the event just after
       * the outer start element Postcondition: If this object is an element,
       * the reader is positioned at its end element If this object is a complex
       * type, the reader is positioned at the end element of its outer element
       */
      public static GetdirResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetdirResponse object = new GetdirResponse();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue(
              "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName
                  .indexOf(":") + 1);

              if (!"getdirResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext()
                    .getNamespaceURI(nsPrefix);
                return (GetdirResponse) ExtensionMapper.getTypeObject(nsUri,
                    type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal
          // attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("http://monash.edu/xsd",
                  "return").equals(reader.getName())) {

            nillableValue = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object
                  .set_return(org.apache.axis2.databinding.utils.ConverterUtil
                      .convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element

          else {

          }

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid
            // property
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }// end of factory class

  }

  private org.apache.axiom.om.OMElement toOM(
      week10.webservice.FileTransferServerHOPPStub.Dir param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          week10.webservice.FileTransferServerHOPPStub.Dir.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(
      week10.webservice.FileTransferServerHOPPStub.DirResponse param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          week10.webservice.FileTransferServerHOPPStub.DirResponse.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(
      week10.webservice.FileTransferServerHOPPStub.Getdir param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          week10.webservice.FileTransferServerHOPPStub.Getdir.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(
      week10.webservice.FileTransferServerHOPPStub.GetdirResponse param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          week10.webservice.FileTransferServerHOPPStub.GetdirResponse.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(
      week10.webservice.FileTransferServerHOPPStub.Quit param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          week10.webservice.FileTransferServerHOPPStub.Quit.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(
      week10.webservice.FileTransferServerHOPPStub.Chdir param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          week10.webservice.FileTransferServerHOPPStub.Chdir.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(
      week10.webservice.FileTransferServerHOPPStub.ChdirResponse param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          week10.webservice.FileTransferServerHOPPStub.ChdirResponse.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      week10.webservice.FileTransferServerHOPPStub.Dir param,
      boolean optimizeContent, javax.xml.namespace.QName methodQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
          .getDefaultEnvelope();
      emptyEnvelope.getBody().addChild(
          param.getOMElement(
              week10.webservice.FileTransferServerHOPPStub.Dir.MY_QNAME,
              factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      week10.webservice.FileTransferServerHOPPStub.Getdir param,
      boolean optimizeContent, javax.xml.namespace.QName methodQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
          .getDefaultEnvelope();
      emptyEnvelope.getBody().addChild(
          param.getOMElement(
              week10.webservice.FileTransferServerHOPPStub.Getdir.MY_QNAME,
              factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      week10.webservice.FileTransferServerHOPPStub.Quit param,
      boolean optimizeContent, javax.xml.namespace.QName methodQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
          .getDefaultEnvelope();
      emptyEnvelope.getBody().addChild(
          param.getOMElement(
              week10.webservice.FileTransferServerHOPPStub.Quit.MY_QNAME,
              factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      week10.webservice.FileTransferServerHOPPStub.Chdir param,
      boolean optimizeContent, javax.xml.namespace.QName methodQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
          .getDefaultEnvelope();
      emptyEnvelope.getBody().addChild(
          param.getOMElement(
              week10.webservice.FileTransferServerHOPPStub.Chdir.MY_QNAME,
              factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  /* methods to provide back word compatibility */

  /**
   * get the default envelope
   */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory) {
    return factory.getDefaultEnvelope();
  }

  private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
      java.lang.Class type, java.util.Map extraNamespaces)
      throws org.apache.axis2.AxisFault {

    try {

      if (week10.webservice.FileTransferServerHOPPStub.Dir.class.equals(type)) {

        return week10.webservice.FileTransferServerHOPPStub.Dir.Factory
            .parse(param.getXMLStreamReaderWithoutCaching());

      }

      if (week10.webservice.FileTransferServerHOPPStub.DirResponse.class
          .equals(type)) {

        return week10.webservice.FileTransferServerHOPPStub.DirResponse.Factory
            .parse(param.getXMLStreamReaderWithoutCaching());

      }

      if (week10.webservice.FileTransferServerHOPPStub.Getdir.class
          .equals(type)) {

        return week10.webservice.FileTransferServerHOPPStub.Getdir.Factory
            .parse(param.getXMLStreamReaderWithoutCaching());

      }

      if (week10.webservice.FileTransferServerHOPPStub.GetdirResponse.class
          .equals(type)) {

        return week10.webservice.FileTransferServerHOPPStub.GetdirResponse.Factory
            .parse(param.getXMLStreamReaderWithoutCaching());

      }

      if (week10.webservice.FileTransferServerHOPPStub.Quit.class.equals(type)) {

        return week10.webservice.FileTransferServerHOPPStub.Quit.Factory
            .parse(param.getXMLStreamReaderWithoutCaching());

      }

      if (week10.webservice.FileTransferServerHOPPStub.Chdir.class.equals(type)) {

        return week10.webservice.FileTransferServerHOPPStub.Chdir.Factory
            .parse(param.getXMLStreamReaderWithoutCaching());

      }

      if (week10.webservice.FileTransferServerHOPPStub.ChdirResponse.class
          .equals(type)) {

        return week10.webservice.FileTransferServerHOPPStub.ChdirResponse.Factory
            .parse(param.getXMLStreamReaderWithoutCaching());

      }

    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }

}
