package server;
import common.service.impl.VotingServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

    public static void main(String[] args) {
        try {

            // OBJETO QUE SERÁ FORNECIDO VIA REDE
            VotingServiceImpl votingService = new VotingServiceImpl();

            // NOME PARA O USUÁRIO ACESSAR O OBJETO
            String nameObject = "VotingService";

            System.out.println("Registrando objeto RMI...");
            LocateRegistry.createRegistry(1099);
            Naming.rebind(nameObject, votingService);

            System.out.println("Aguardando clientes...\n" + "====================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
