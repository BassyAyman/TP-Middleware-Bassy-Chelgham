package serveur.log;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Compte implements Serializable {

    private String login;

    private String password;

    /**
     * true : deja un compte et renseigne ces données
     * false : pas de compte et en crée un
     */
    private boolean status;

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public boolean getStatus(){
        return status;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return login+","+password;
    }
}
