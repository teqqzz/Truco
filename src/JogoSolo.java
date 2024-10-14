
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class JogoSolo {
    public static void main(String[] args) throws IOException {
        System.out.println("Bem-vindo ao Jogo de Truco!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pontuacaoJogador1 = 0;
        int pontuacaoPC = 0;
        int pontuacaoMaxima = 12;
        while (true) {
            boolean trucoJogador1 = false;
            boolean trucoPC = false;
            while (pontuacaoJogador1 < pontuacaoMaxima && pontuacaoPC < pontuacaoMaxima) {
                JogoTruco jogo = new JogoTruco();
                jogo.virarCarta();
                Random rand = new Random();
                ArrayList<Baralho> cartasPC = jogo.distribuirCartas(3);
                ArrayList<Baralho> cartasJogador1 = jogo.distribuirCartas(3);
                for (int rodada = 1; rodada <= 3; rodada++) {
                    System.out.println("------ Rodada " + rodada + " ------");
                    System.out.println("");
                    System.out.println("------ Pontuação ------");
                    System.out.println("Jogador1: " + pontuacaoJogador1 + " pontos");
                    System.out.println("PC: " + pontuacaoPC + " pontos");
                    System.out.println("");
                    
                    Baralho cartaPC = cartasPC.get(rand.nextInt(cartasPC.size()));
                    if (!trucoJogador1 && !trucoPC) {
                        System.out.println(" ----- Jogador1 ----- ");
                        System.out.println("A Carta Virada é: " + jogo.getCartaVirada());
                        System.out.println("Suas cartas:");
                        for (int i = 0; i < cartasJogador1.size(); i++) {
                            System.out.println("Carta " + (i + 1) + ": " + cartasJogador1.get(i));
                        }
                        System.out.println("Deseja pedir truco? (s/n)");
                        String resposta = reader.readLine();
                        if (resposta.equalsIgnoreCase("s")) {
                            trucoJogador1 = true;
                            System.out.println("Você pediu truco!");
    
                            if (rand.nextDouble() <= 0.5 && cartaPC.getForcCarta() > jogo.getCartaVirada().getForcCarta()) {
                                System.out.println("O PC aceitou o truco!");
                            } 
                            else if (rand.nextDouble() <= 0.3 && cartaPC.getForcCarta() > jogo.getCartaVirada().getForcCarta()) {
                                System.out.println("O PC retrucou!");
                                System.out.println("Você deseja aceitar o truco ou fugir ou retrucar? (s/f/r)");
                                String respostaretruco = reader.readLine();
                                if (respostaretruco.equalsIgnoreCase("s")){
                                    System.out.println("Voce Aceitou o Retruco!");
                                }
                                else if (respostaretruco.equalsIgnoreCase("f")){
                                    pontuacaoPC += 6;
                                }
                                else if (respostaretruco.equalsIgnoreCase("r")){

                                    if (rand.nextDouble() <= 0.1 && cartaPC.getForcCarta() > jogo.getCartaVirada().getForcCarta()) {
                                        System.out.println("O PC aceitou o retruco!");
                                    } 
                                }
                                

                            } 
                        
                            else {
                                System.out.println("O PC fugiu!");
                                pontuacaoJogador1 += 3;
                                break;
                            }
                        }
                    }

                    int selecaoPCIndex;
                    while (true) {
                        System.out.println(" ----- Jogador1 ----- ");
                        System.out.println("A Carta Virada é: " + jogo.getCartaVirada());
                        System.out.println("Suas cartas:");
                        for (int i = 0; i < cartasJogador1.size(); i++) {
                            System.out.println("Carta " + (i + 1) + ": " + cartasJogador1.get(i));
                        }
                        System.out.println("Selecione uma carta: ");
                        try {
                            selecaoPCIndex = Integer.parseInt(reader.readLine()) - 1;
    
                            if (selecaoPCIndex >= 0 && selecaoPCIndex < cartasJogador1.size()) {
                                break;
                            } else {
                                System.out.println("Escolha uma carta válida.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, digite um número válido.");
                        }
                    }
                    System.out.println("Jogador1 selecionou a carta " + cartasJogador1.get(selecaoPCIndex));
                    Baralho cartaJogador1 = cartasJogador1.get(selecaoPCIndex);
                    int selecaoJogador1Index = rand.nextInt(cartasPC.size());

                    if (!trucoPC && rand.nextDouble() <= 0.5 && cartaPC.getForcCarta() > jogo.getCartaVirada().getForcCarta() ) {
                        System.out.println("O PC pediu truco!");
                        System.out.println("Você deseja aceitar o truco? (s/n)");
                        String respostat = reader.readLine();
                        if (respostat.equalsIgnoreCase("s")) {
                            System.out.println("Você aceitou o truco!");
                            System.out.println("Deseja Retrucar? (s/n)");
                            String respostaTruco = reader.readLine();
                            if (respostaTruco.equals("s")) {
                                trucoJogador1 = true;
                                if (trucoPC && rand.nextDouble() <= 0.3 && cartaPC.getForcCarta() > jogo.getCartaVirada().getForcCarta()) {
                                    trucoPC = true;
                                    System.out.println("O PC aceitou o truco!");
                                    System.out.println("Deseja retrucar? (s/n)");
                                    String resposta9 = reader.readLine();
                                    if (resposta9.equalsIgnoreCase("s")) {
                                        System.out.println("Você pediu retruco!");
                                        if (rand.nextDouble() <= 0.2 && cartaPC.getForcCarta() > jogo.getCartaVirada().getForcCarta()) {
                                            System.out.println("O PC aceitou o retruco!");
                                    }
                                    else if (rand.nextDouble() <= 0.1 && cartaPC.getForcCarta() > jogo.getCartaVirada().getForcCarta()){
                                        System.out.println("O Pc retrucou!");
                                        String respostaretruco2 = reader.readLine();
                                        System.out.println("Você deseja aceitar o truco(s/n)");
                                        if (respostaretruco2.equalsIgnoreCase("s")){
                                            System.out.println("Voce Aceitou o Retruco!");
                                        }
                                        else if (respostaretruco2.equalsIgnoreCase("n")){
                                            pontuacaoPC += 9;
                                        }
                                }
                            }
                                } else {
                                    System.out.println("O PC fugiu!");
                                    pontuacaoJogador1 += 6;
                                    break;
                                }
                            } else if (respostaTruco.equals("n")) {
                                System.out.println("Você não pediu truco adicional.");
                            } else {
                                System.out.println("Opção inválida. Não foi feito nenhum pedido de truco adicional.");
                            }

                        } else if (respostat.equalsIgnoreCase("n")) {
                            System.out.println("Você fugiu do truco!");
                            pontuacaoPC += 3;
                            break;
                        }
                    }


                    System.out.println("PC selecionou a carta " + cartasPC.get(selecaoJogador1Index));
                    cartasJogador1.remove(selecaoPCIndex);
                    cartaPC = cartasPC.get(selecaoJogador1Index);
                    cartasPC.remove(selecaoJogador1Index);
                    if (cartaJogador1.getForcCarta() > cartaPC.getForcCarta()) {
                        System.out.println("Você venceu a rodada " + rodada + "!");
                        pontuacaoJogador1 += 1;
    
                        if (trucoPC){
                            pontuacaoJogador1 += 2;
                        }
                    } else if (cartaJogador1.getForcCarta() < cartaPC.getForcCarta()) {
                        System.out.println("Você perdeu a rodada " + rodada + "!");
                        pontuacaoPC += 1;
    
                        if (trucoJogador1){
                            pontuacaoPC += 2;
                        }
                    } else {
                        System.out.println("Empate na rodada " + rodada + "!");
                        pontuacaoPC += 1;
                        pontuacaoJogador1 += 1;
                    }
                }

                System.out.println("------ Pontuação Final ------");
                System.out.println("Jogador1: " + pontuacaoJogador1 + " pontos");
                System.out.println("PC: " + pontuacaoPC + " pontos");
                if (pontuacaoJogador1 >= pontuacaoMaxima) {
                    System.out.println("Parabéns! Você venceu o jogo!");
                } else if (pontuacaoPC >= pontuacaoMaxima) {
                    System.out.println("O PC venceu o jogo. Melhor sorte na próxima!");
                }
                if (pontuacaoJogador1 >= pontuacaoMaxima || pontuacaoPC >= pontuacaoMaxima) {
                    break;
                }
            }

  
            System.out.println("Deseja começar uma nova partida? (s/n)");
            String novoJogo = reader.readLine();
            if (novoJogo.equalsIgnoreCase("s")) {
                pontuacaoJogador1 = 0;
                pontuacaoPC = 0;
                trucoJogador1 = false;
                trucoPC = false;
            } else {
                break;
            }
        }
        reader.close();
    }

}
