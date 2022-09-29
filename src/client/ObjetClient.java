package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetClient extends UnicastRemoteObject implements IClient {

    protected ObjetClient(int port) throws RemoteException {
        super(port);
    }
}
