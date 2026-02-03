package common.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.service.IVotingService;

public class VotingServiceImpl extends UnicastRemoteObject implements IVotingService {

    public VotingServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void toVote(String voterName, String candidateName) throws RemoteException {
        System.out.println(">>> Receiving a vote....");
        System.out.println(">>> Candidate:" + candidateName);
        System.out.println(">>> Voter: " + voterName + "\n====================\n");
    }
}
