import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Servidor {
    private static HashMap<Integer, String> dados;

    public static void main(String[] args) {
        dados = new HashMap<>();
        dados.put(1, "Me da um 10 professor!");
        dados.put(2, "Vou ganhar um 10?");
        dados.put(3, "Acho que mereço 10");

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor iniciado na porta 12345.");

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClienteHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
    }

    private static class ClienteHandler implements Runnable {
        private Socket socket;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                boolean continuar = true;
                while (continuar) {
                    int id = in.readInt();
                    if (id == -1) {  // Verifica se o cliente quer encerrar a conexão
                        continuar = false;
                        out.writeUTF("Conexão encerrada pelo cliente.");
                    } else {
                        String resposta = dados.getOrDefault(id, "ID não encontrado");
                        out.writeUTF(resposta);  // Envia a resposta ao cliente
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro no atendimento ao cliente: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o socket: " + e.getMessage());
                }
            }
        }
    }
}
