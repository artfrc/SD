package common.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVotingService extends Remote {

    void toVote(String voterName, String candidateName) throws RemoteException;

}
