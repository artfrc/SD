package server;
import common.service.impl.ResultServiceImpl;
import common.service.impl.VotingServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

    public static void main(String[] args) {
        try {

            // OBJETOS QUE SERAO FORNECIDOS VIA REDE
            VotingServiceImpl votingService = new VotingServiceImpl();
            ResultServiceImpl resultService =
                  new ResultServiceImpl(votingService);


            // NOME PARA O USUÁRIO ACESSAR O OBJETO
            String nameObject = "VotingService";

            System.out.println("Registring RMI object...");
            LocateRegistry.createRegistry(1099);
            Naming.rebind(nameObject, votingService);
            Naming.rebind("ResultService", resultService);


            System.out.println("Waiting clients...\n" + "====================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menu() {
        System.out.println("1. View Votes");
        System.out.println("2. To Vote");
        System.out.println("0. Exit");
    }
}
