package serveur.log;

import client.ObjetClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogService extends Remote {

    void doLog(ObjetClient client) throws RemoteException;
}
