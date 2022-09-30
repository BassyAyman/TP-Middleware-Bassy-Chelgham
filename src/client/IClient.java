package client;

import serveur.log.Compte;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {

    String getNom() throws RemoteException;

    Compte demandeConnectionError(Compte compte) throws RemoteException;

    void connexionReussi() throws RemoteException;

    Compte demandeServeur() throws RemoteException;
}
