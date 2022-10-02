package client;

import exception.InvalidCredentialException;
import exception.SignInFailedException;
import serveur.Bill;
import serveur.IServeur;
import serveur.log.ILogService;
import serveur.log.LogService;
import serveur.videoservice.IVODService;
import serveur.videoservice.MovieDesc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException, SignInFailedException, InvalidCredentialException {
        Registry r = LocateRegistry.getRegistry("localhost", 2001);
        IServeur d = (IServeur) Naming.lookup("rmi://localhost:2001/MonOD");

        IClient c1 = new ObjetClient(10004, "JOJO");
        ILogService serviceLog = d.getLogService();
        IVODService vodService = serviceLog.doLog(c1);

        System.out.println("-------------------------------");
        System.out.println("--          Gratflix         --");
        System.out.println("--       streaming de fou    --");
        System.out.println("-------------------------------");

        ////////////////////////////////////////////

        //Affichage du catalogue
        int numFilm = 0;
        for (MovieDesc md : vodService.viewCatalog()) {
            System.out.println(++numFilm + ": " + md);
        }

        //Choix du film ET lancement
        Scanner sc = new Scanner(System.in);
        System.out.println("Tapez le numéro du film que vous voulez jouer");
        String ibsn = sc.nextLine();
        if (Integer.parseInt(ibsn) > 0 && Integer.parseInt(ibsn) <= 5) {
            Bill b = vodService.playMovie(ibsn, (IClientBox) c1);
            System.out.println(b);
        } else {
            System.out.println("numéro incorrect");
        }

    }

}
