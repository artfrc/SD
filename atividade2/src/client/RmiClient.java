package client;

import common.service.impl.VotingServiceImpl;
import common.service.IVotingService;

import java.rmi.Naming;

public class RmiClient {

    public static void main(String[] args) throws Exception {

        String nameObject = "rmi://localhost:1099/VotingService";

        IVotingService votingService =
                (IVotingService) Naming.lookup(nameObject);

        votingService.toVote("alo", "alo");
    }
}
