package client;

import common.service.IResultService;
import common.service.IVotingService;

import java.rmi.Naming;
import java.util.Map;
import java.util.Scanner;

public class RmiClient {

    public static void main(String[] args) throws Exception {

        IVotingService votingService =
                (IVotingService) Naming.lookup("rmi://localhost:1099/VotingService");

        IResultService resultService =
                (IResultService) Naming.lookup("rmi://localhost:1099/ResultService");

        Scanner sc = new Scanner(System.in);
        int option;

        do {

            System.out.println("""
                1 - View Votes
                2 - To Vote
                3 - View Final Results
                0 - Exit
                """);

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1 -> {
                    Map<String,String> votes = resultService.viewVotes();

                    System.out.println("\n=== Results ===\n");
                    votes.forEach((voter, candidate) ->
                        System.out.println(voter + " -> " + candidate)
                    );
                    System.out.println("\n====================\n");
                }

                case 2 -> {

                    System.out.print("\n>>> Voter name:  ");
                    String voter = sc.nextLine();

                    String candidate = null;

                    while (candidate == null) {

                        System.out.println("""
                            List of candidates:
                            1 - Candidate 1
                            2 - Candidate 2
                            3 - Candidate 3
                            """);

                        System.out.print("Candidate number: ");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {
                            case 1 -> candidate = "Candidate 1";
                            case 2 -> candidate = "Candidate 2";
                            case 3 -> candidate = "Candidate 3";
                            default -> System.out.println("Invalid option, try again.");
                        }
                    }

                    votingService.toVote(voter, candidate);

                    System.out.println("\n>>> Vote registered!\n");
                    System.out.println("====================\n");
                }

                case 3 -> {

                    System.out.println("\n=== Final Results ===\n");    
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
                    System.out.println("====================\n");

                }

                case 0 -> System.out.println("Finishing client...");

                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);

        sc.close();
    }
}
