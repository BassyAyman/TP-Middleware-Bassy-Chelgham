package client;

import serveur.log.Compte;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ObjetClient extends UnicastRemoteObject implements IClient {

    protected ObjetClient(int port) throws RemoteException {
        super(port);
    }

    public void demandeConnectionError(Compte compte){
        Scanner myObj = new Scanner(System.in);
        System.out.println(" le login ou mots de passe sont incorrect, veuillez recommencer");
        System.out.println( " Login : ");
        String log = myObj.nextLine();
        System.out.println( " Mots de Passe : ");
        String mdp = myObj.nextLine();
        compte.setLogin(log);
        compte.setPassword(mdp);
    }

    public void connexionReussi(){
        System.out.println(" connexion reussi");
        System.out.println(" ----------------- ");
        System.out.println(" ----------------- ");
        System.out.println(" ----------------- ");
    }

    public void demandeServeur(Compte compte){
        System.out.println(" bienvenu sur notre service de streaming , avez-vous deja un compte chez nous ? (O/N): ");
        Scanner myObj = new Scanner(System.in);
        String reponse = myObj.nextLine().toUpperCase(Locale.ROOT);
        while(!Objects.equals(reponse, "O") && !Objects.equals(reponse, "N")){
            System.out.println(" vous etes priez de repondre par O (oui) ou N (non) : ");
            reponse = myObj.nextLine();
        }
        if(Objects.equals(reponse,"O")){
            compte.setStatus(true);
            System.out.println( " Login : ");
            String log = myObj.nextLine();
            System.out.println( " Mots de Passe : ");
            String mdp = myObj.nextLine();
            compte.setLogin(log);
            compte.setPassword(mdp);
        }else{
            compte.setStatus(false);
            System.out.println( " votre nouveau Login : ");
            String log = myObj.nextLine();
            System.out.println( " votre nouveau Mots de Passe : ");
            String mdp = myObj.nextLine();
            System.out.print("SVP, veuillez confirmez votre Mots de Passe : ");
            String confirm = myObj.nextLine();
            while (!mdp.equals(confirm)) {
                System.out.println("MDP invalide !");
                System.out.print( "reentrez votre nouveau Mots de Passe :  ");
                mdp = myObj.nextLine();
                System.out.print("SVP, veuillez confirmez votre Mots de Passe : ");
                confirm = myObj.nextLine();
            }
            compte.setLogin(log);
            compte.setPassword(mdp);
        }
    }
}
