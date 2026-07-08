// Bibliotecas utilizadas:
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class RelogioAlarme implements Runnable { // Implements Runnable para Polimorfar o método run() do thread.

    private final LocalTime alarmeTempo; // Métodos final pois não serão mexidos, aqui estão os argumentos pro objeto no Main.
    private final String caminhoArquivo;
    private final Scanner scanner;

    //Construtor da classe, com os 3 parametros/argumentos que a classe possui.
    RelogioAlarme(LocalTime alarmeTempo,  String caminhoArquivo, Scanner scanner) {
        this.alarmeTempo = alarmeTempo;
        this.caminhoArquivo = caminhoArquivo;
        this.scanner = scanner;
    }

    //Polimorfismo do método run()
    @Override
    public void run() {
        while(LocalTime.now().isBefore(alarmeTempo)) { //-> While Loop enquanto o current-time for menor que o alarme.
            try {
                Thread.sleep(1000);

                LocalTime agora = LocalTime.now(); //-> Variável local de Localtime, para formatar o Output dos segundos.
                                                  //-> Também utilizei o \r para a linha não pular e o contador ficar estático no mesmo lugar (terminal).
                System.out.printf("\r%02d:%02d:%02d", agora.getHour(), agora.getMinute(), agora.getSecond()); //-> Output formatado com printf.
            }
            catch (InterruptedException e) { //Safety net / Catch Block
                System.out.println("A thread 'RelogioAlarme' foi interrompida.");
            }
        }

        System.out.println("\nAlarm Noises!!");
        playMusica(caminhoArquivo); //-> Função para tocar a musiquinha do alarme assim que o while termina

    }
    //Função para tocar a música do alarme assim que chega na hora que o user deseja
    private void playMusica(String caminhoArquivo) {

        File audioFile = new File(caminhoArquivo);

        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.print("Pressione ENTER para parar o alarme");
            scanner.nextLine();
            clip.stop();
            scanner.close();
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Esse formato de arquivo não é suportado. Converta para .WAV e tente novamente.");
        }
        catch(LineUnavailableException e) {
            System.out.println("Audio indisponível.");
        }
        catch (IOException e) {
            System.out.println("Algo deu errado.");
        }
    }
}
