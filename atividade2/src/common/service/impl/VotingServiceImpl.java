package common.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import common.service.IVotingService;

public class VotingServiceImpl extends UnicastRemoteObject
        implements IVotingService {

    private final Map<String,String> votes = new HashMap<>();

    public VotingServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public synchronized void toVote(String voter, String candidate)
            throws RemoteException {

        votes.put(voter, candidate);

        System.out.println("Vote received: " + voter + " -> " + candidate);
    }

    public Map<String,String> getVotes() {
        return votes;
    }
}

