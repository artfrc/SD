package common.service;

import java.rmi.Remote;

public interface IVotingService extends Remote{

   void toVote(String voterName, String candidateName) throws Exception;
   
}
