package common.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import common.service.IResultService;

public class ResultServiceImpl extends UnicastRemoteObject
        implements IResultService {

    private final VotingServiceImpl votingService;

    public ResultServiceImpl(VotingServiceImpl votingService)
            throws RemoteException {

        super();
        this.votingService = votingService;
    }

    @Override
    public Map<String,String> viewVotes() throws RemoteException {
         System.out.println(">>> Viewing all votes....");
        return votingService.getVotes();
    }

    @Override
    public Map<String, Integer> viewFinalResults() throws RemoteException {

      System.out.println(">>> Viewing final results....");

      Map<String,String> votes = votingService.getVotes();

      Map<String,Integer> counter = new HashMap<>();

      for (String candidate : votes.values()) {
         counter.put(candidate,
         counter.getOrDefault(candidate, 0) + 1);
      }

      return counter;
    }
}
