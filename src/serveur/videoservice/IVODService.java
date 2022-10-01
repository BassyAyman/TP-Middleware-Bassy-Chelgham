package serveur.videoservice;

import client.IClient;
import client.IClientBox;
import exception.InvalidCredentialException;
import serveur.Bill;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVODService extends Remote {

 //  IVODService login(String mail, String pwd) throws InvalidCredentialException;

   List<MovieDesc> viewCatalog() throws RemoteException;

   Bill playMovie(String isbn, IClientBox box) throws RemoteException;

}
