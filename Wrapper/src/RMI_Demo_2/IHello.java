package RMI_Demo_2;


import java.rmi.*;

public interface IHello extends Remote {
    public String message() throws RemoteException;

}
