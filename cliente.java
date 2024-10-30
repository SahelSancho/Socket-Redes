import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado ao servidor.");

            boolean continuar = true;
            while (continuar) {
                System.out.print("Digite um ID de 1 a 3 para consulta (ou -1 para sair): ");
                int id = scanner.nextInt();

                if (id == -1) {
                    continuar = false;
                } else {
                    out.writeInt(id);
                    String resposta = in.readUTF();
                    System.out.println("Resposta do servidor: " + resposta);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}