package serveur.videoservice;

import client.IClient;
import client.IClientBox;
import exception.InvalidCredentialException;
import serveur.Bill;

import java.io.Serializable;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Random;

public class VODService extends UnicastRemoteObject implements IVODService {

    private List<MovieDesc> catalog = List.of(
            new MovieDesc("Titanic", "1", "spoiler: un bateau va couler..."),
            new MovieDesc("Interstellar", "2", "Découverte des profondeurs de l'espace et de la relativité"),
            new MovieDesc("Mortal Kombat", "3", "Adaptation du célèbre jeu vidéo de combat"),
            new MovieDesc("Avengers Infinity War", "4", "Avengers vs Thanos qui va gagner ? A vous de le découvrir"),
            new MovieDesc("Hulk", "5", "Bonhomme vert à l'humeur instable")
    );

    public VODService(int port) throws RemoteException {
        super(port);
    }

    public synchronized List<MovieDesc> viewCatalog() throws RemoteException {
        return catalog;

    }

    @Override
    public Bill playMovie(String isbn, IClientBox box) throws RemoteException {
        Random r = new Random();
        byte[] b = new byte[4];
        r.nextBytes(b);
        box.stream(b);

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                r.nextBytes(b);
                try {
                    box.stream(b);
                    Thread.sleep(100);
                    System.out.println("idothings");
                } catch (RemoteException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Bill(getMovieName(isbn), BigInteger.TEN);
    }

    private String getMovieName(String isbn){
        for(MovieDesc md : catalog){
            if(md.getIsbn().equals(isbn)) return md.getMovieName();
        }
        return "not found";
    }


   /* @Override
    public IVODService login(String mail, String pwd) throws InvalidCredentialException {
        return null;
    }*/

}
