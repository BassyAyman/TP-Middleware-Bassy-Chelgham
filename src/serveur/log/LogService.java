package serveur.log;

import client.IClient;
import serveur.ObjetServeur;
import serveur.videoservice.IVODService;
import serveur.videoservice.VODService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Objects;

public class LogService extends UnicastRemoteObject implements ILogService {

    private final ObjetServeur objetServeur;

    public LogService(int port, ObjetServeur objetServeur) throws RemoteException {
        super(port);
        this.objetServeur = objetServeur;
    }

    public synchronized IVODService doLog(IClient client) throws RemoteException {
        boolean valeurOK = false;
        Compte compte = client.demandeServeur();
        if(!compte.getStatus()){
            /*System.out.println("---------------------  "+compte.getLogin());
            System.out.println("---------------------  "+compte.getPassword());
            System.out.println("---------------------  "+compte.getStatus()); test compte*/
            LogInteract.writeFile(compte.toString());
            System.out.println(" le client "+client.getNom()+" effectue sa premiere connection");
        }
        if(!compte.getStatus()){
            compte = client.demandeConnectionNormal(compte);
        }
        List<String> valCSV = LogInteract.readFile();
        while(!valeurOK){
            for (String s : valCSV) {
                /*System.out.println(" --------------------- "+compte.toString());
                System.out.println(" --------------------- "+s); test */
                if(Objects.equals(s,compte.toString())){
                    client.connexionReussi();
                    System.out.println(" le client+ "+client.getNom()+" a reussi a ce connecter");
                    valeurOK = true;
                    break;
                }
            }
            if(!valeurOK){
                compte = client.demandeConnectionError(compte);
            }
        }
        System.out.println("par la test");
        return objetServeur.getVodService();
    }
}
