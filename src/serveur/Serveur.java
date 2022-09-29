package serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        Registry reg= LocateRegistry.createRegistry(2001);
        IServeur d = new ObjetServeur(10001);
        Naming.rebind("rmi://localhost:2001/MonOD",d);

    }
}
