package serveur.log;

import client.IClient;
import exception.InvalidCredentialException;
import exception.SignInFailedException;
import serveur.ObjetServeur;
import serveur.videoservice.IVODService;
import serveur.videoservice.VODService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LogService extends UnicastRemoteObject implements ILogService {

    private final ObjetServeur objetServeur;

    public LogService(int port, ObjetServeur objetServeur) throws RemoteException {
        super(port);
        this.objetServeur = objetServeur;
    }

    private boolean verificationCredential(String s,List<String> valCSV){
        List<String> logs = new ArrayList<>();
        for (String sos : valCSV){
            logs.add(sos.split(",")[0]);
        }
        for (String sos : logs){
            if (Objects.equals(s,sos)){
                return true;
            }
        }
        return false;
    }

    public synchronized IVODService doLog(IClient client) throws RemoteException, SignInFailedException, InvalidCredentialException {
        int cpt1 = 0;
        int cpt2 = 0;
        boolean valeurOK = false;
        List<String> valCSV = LogInteract.readFile();
        Compte compte = client.demandeServeur();
        if(!compte.getStatus()){

            if(verificationCredential(compte.getLogin(),valCSV)) // verifie si le log existe deja dans le fichier, si oui jette une exeption
                throw new InvalidCredentialException(" --------- le log renseigné existe deja ");
            LogInteract.writeFile(compte.toString());
            valCSV.add(compte.toString());
            System.out.println(" le client "+client.getNom()+" effectue sa premiere connection");
        }
        if(!compte.getStatus()){
            compte = client.demandeConnectionNormal(compte);
        }
        while(!valeurOK){
            for (String s : valCSV) {
                System.out.println(" --------------------- "+compte.toString());
                System.out.println(" --------------------- "+s);
                if(Objects.equals(s,compte.toString())){
                    client.connexionReussi();
                    System.out.println(" le client+ "+client.getNom()+" a reussi a ce connecter");
                    valeurOK = true;
                    break;
                }
            }
            if(!valeurOK){
                cpt2++;
                if(cpt2 > 3) // si trop d'erreur d'autenfication sont faite, jette l'exeption
                    throw new SignInFailedException(" ----- trop d'erreur dans l'autentification ! ");
                compte = client.demandeConnectionError(compte);
            }
        }

        return objetServeur.getVodService();
    }
}
