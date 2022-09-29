package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetServeur extends UnicastRemoteObject implements IServeur{

    protected ObjetServeur(int port) throws RemoteException {
        super(port);
    }
}
