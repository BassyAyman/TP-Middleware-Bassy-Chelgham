package serveur.log;

import client.ObjetClient;
import serveur.IServeur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Objects;

public class LogService extends UnicastRemoteObject implements ILogService {

    protected LogService(int port) throws RemoteException {
        super(port);
    }

    public synchronized void doLog(ObjetClient client){
        Compte compte = new Compte();
        boolean valeurOK = false;
        client.demandeServeur(compte);
        if(!compte.getStatus()){
            LogInteract.writeFile(compte.toString());
        }else{
            List<String> valCSV = LogInteract.ReadFile();
            while(!valeurOK){
                for (String s : valCSV) {
                    if(Objects.equals(s,compte.toString())){
                        client.connexionReussi();
                        valeurOK = true;
                        break;
                    }
                }
                if(!valeurOK){
                    client.demandeConnectionError(compte);
                }
            }
        }
    }
}
