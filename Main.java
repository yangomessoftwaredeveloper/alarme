// Bibliotecas Utilizadas:
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // Alarme em Java

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // -> Formatador para o input .
        LocalTime alarmeTempo = null; // -> Null para utilizar no While.
        String caminhoArquivo = "du-bist-gut-genug.wav"; // -> Caminho do arquivo (não tem, porque já está dentro da pasta do projeto).


        while(alarmeTempo == null){ // While loop enquanto o tempo estiver nulo
            try{ // -> Try/catch block para "Danger Code", recebendo o input do User e caso esteja fora do formato, irá aparecer a mensagem do catch block.
                System.out.print("Digite o tempo do alarme (HH:MM:SS): ");
                String dadoTempo = scanner.nextLine(); //-> Variável recebendo o tempo que o User digitou

                alarmeTempo = LocalTime.parse(dadoTempo, formatter); // parse para variável alarmeTempo
                System.out.println("Alarme colocado para " + alarmeTempo);
            }
            catch (DateTimeParseException e){ // Catch Block
                System.out.println("Formato de hora inválido. Por favor, use na ordem: Hora, minuto e segundo");
                System.out.println("Exemplo: '09:43:50'");
            }
        }

        RelogioAlarme relogioalarme = new RelogioAlarme(alarmeTempo, caminhoArquivo, scanner); // Objeto RelogioAlarme + Argumentos (que são os atributos da classe RelogioAlarme).
        Thread alarmeThread = new Thread(relogioalarme); // Objeto Thread para o alarme
        alarmeThread.start(); // Iniciando a Thread do Alarme
    }
}
