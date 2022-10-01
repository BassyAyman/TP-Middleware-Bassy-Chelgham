package serveur;

import client.IClientBox;
import serveur.log.ILogService;
import serveur.log.LogService;
import serveur.videoservice.IVODService;
import serveur.videoservice.VODService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetServeur extends UnicastRemoteObject implements IServeur{

    private final ILogService logService;
    private final IVODService vodService;

    protected ObjetServeur(int port) throws RemoteException {
        super(port);
        logService = new LogService(10002, this);
        vodService = new VODService(10003);
    }


    public ILogService getLogService(){
        return logService;
    }

    public IVODService getVodService() {return vodService;}


}
