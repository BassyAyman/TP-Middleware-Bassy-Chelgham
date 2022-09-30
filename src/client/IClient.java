package client;

import serveur.log.Compte;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public interface IClient extends Remote {

    String getNom() throws RemoteException;

    Compte demandeConnectionError(Compte compte) throws RemoteException;

    void connexionReussi() throws RemoteException;

    Compte demandeServeur() throws RemoteException;

    Compte demandeConnectionNormal(Compte compte) throws RemoteException;

}
