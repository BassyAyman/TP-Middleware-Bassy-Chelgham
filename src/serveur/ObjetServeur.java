package serveur;

import serveur.log.ILogService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetServeur extends UnicastRemoteObject implements IServeur{

    private ILogService logService;

    protected ObjetServeur(int port) throws RemoteException {
        super(port);
    }

    public ILogService getLogService(){
        return logService;
    }
}
