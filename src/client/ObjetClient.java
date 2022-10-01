package client;

import serveur.log.Compte;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ObjetClient extends UnicastRemoteObject implements IClient, IClientBox {

    private final String nom;

    protected ObjetClient(int port, String nom) throws RemoteException {
        super(port);
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public Compte demandeConnectionError(Compte compte){
        Scanner myObj = new Scanner(System.in);
        System.out.println(" le login ou mot de passe incorrect, veuillez recommencer");
        System.out.println( " Login : ");
        String log = myObj.nextLine();
        System.out.println( " Mot de Passe : ");
        String mdp = myObj.nextLine();
        compte.setLogin(log);
        compte.setPassword(mdp);
        return compte;
    }

    public Compte demandeConnectionNormal(Compte compte){
        Scanner myObj = new Scanner(System.in);
        System.out.println(" veillez rentrer votre nouveau login");
        System.out.println( " Login : ");
        String log = myObj.nextLine();
        System.out.println( " Mot de Passe : ");
        String mdp = myObj.nextLine();
        compte.setLogin(log);
        compte.setPassword(mdp);
        return compte;
    }

    public void connexionReussi(){
        System.out.println(" connexion reussie");
        System.out.println(" ----------------- ");
        System.out.println(" ----------------- ");
        System.out.println(" ----------------- ");
        System.out.println();
    }

    public Compte demandeServeur(){
        Compte compte = new Compte();
        System.out.println(" bienvenue sur notre service de streaming , avez-vous deja un compte chez nous ? (O/N): ");
        Scanner myObj = new Scanner(System.in);
        String reponse = myObj.nextLine().toUpperCase(Locale.ROOT);
        while(!Objects.equals(reponse, "O") && !Objects.equals(reponse, "N")){
            System.out.println(" vous etes prié de repondre par O (oui) ou N (non) : ");
            reponse = myObj.nextLine();
        }
        if(Objects.equals(reponse,"O")){
            compte.setStatus(true);
            System.out.println( " Login : ");
            String log = myObj.nextLine();
            System.out.println( " Mot de Passe : ");
            String mdp = myObj.nextLine();
            compte.setLogin(log);
            compte.setPassword(mdp);
        }else{
            compte.setStatus(false);
            System.out.println( " votre nouveau Login : ");
            String log = myObj.nextLine();
            System.out.println( " votre nouveau Mot de Passe : ");
            String mdp = myObj.nextLine();
            System.out.print("SVP, veuillez confirmer votre Mot de Passe : ");
            String confirm = myObj.nextLine();
            while (!mdp.equals(confirm)) {
                System.out.println("MDP invalide !");
                System.out.print( "rentrez votre nouveau Mot de Passe :  ");
                mdp = myObj.nextLine();
                System.out.print("SVP, veuillez confirmer votre Mot de Passe : ");
                confirm = myObj.nextLine();
            }
            compte.setLogin(log);
            compte.setPassword(mdp);
            /*System.out.println("---------------------  "+compte.getLogin());
            System.out.println("---------------------  "+compte.getPassword());
            System.out.println("---------------------  "+compte.getStatus()); sert pour les tests valeur de compte */
        }
        return compte;
    }

    @Override
    public void stream(byte[] chunck) throws RemoteException {
        System.out.println(new String(Base64.getEncoder().encode(chunck)));
    }
}
