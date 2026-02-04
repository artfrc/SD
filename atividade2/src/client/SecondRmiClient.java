package client;

import java.rmi.Naming;
import java.util.Map;

import common.service.IResultService;

public class SecondRmiClient {

   public static void main(String[] args) throws Exception {

        IResultService resultService =
                (IResultService) Naming.lookup("rmi://localhost:1099/ResultService");

        System.out.println("=== FINAL RESULTS ===\n");

        Map<String, Integer> results = resultService.viewFinalResults();

        String winner = null;
        int max = 0;

        for (var entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

            if (entry.getValue() > max) {
                max = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " (" + max + " votes)");
        System.out.println("====================");
    }
   
}
