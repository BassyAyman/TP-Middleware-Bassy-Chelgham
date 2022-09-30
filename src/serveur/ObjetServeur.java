package serveur;

import serveur.log.ILogService;
import serveur.log.LogService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetServeur extends UnicastRemoteObject implements IServeur{

    private final ILogService logService;

    protected ObjetServeur(int port) throws RemoteException {
        super(port);
        logService = new LogService(10002);
    }

    public ILogService getLogService(){
        return logService;
    }
}
