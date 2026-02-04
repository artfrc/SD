package common.service;

import java.rmi.Remote;
import java.util.Map;

public interface IResultService  extends Remote{

      Map<String, String> viewVotes() throws Exception;

      Map<String, Integer> viewFinalResults() throws Exception;
   
}
