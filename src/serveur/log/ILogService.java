package serveur.log;

import client.IClient;
import client.ObjetClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogService extends Remote {

    void doLog(IClient client) throws RemoteException;
}
