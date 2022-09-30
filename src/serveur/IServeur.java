package serveur;

import serveur.log.ILogService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServeur extends Remote {

    ILogService getLogService() throws RemoteException;
}
