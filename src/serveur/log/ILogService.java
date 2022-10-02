package serveur.log;

import client.IClient;
import client.ObjetClient;
import exception.InvalidCredentialException;
import exception.SignInFailedException;
import serveur.videoservice.IVODService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogService extends Remote {

    IVODService doLog(IClient client) throws RemoteException, SignInFailedException, InvalidCredentialException;
}
