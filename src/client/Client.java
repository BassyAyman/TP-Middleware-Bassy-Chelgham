package client;

import serveur.IServeur;
import serveur.log.ILogService;
import serveur.log.LogService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        Registry r = LocateRegistry.getRegistry("localhost",2001);
        IServeur d = (IServeur) Naming.lookup("rmi://localhost:2001/MonOD");

        IClient c1 = new ObjetClient(10004, "JOJO");

        try{
            ILogService serviceLog = d.getLogService();

            serviceLog.doLog(c1);

        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
