package TrucoNovo;

import java.util.*;

public class trucoSolo {
    public static void main(String[] args) {
        Cheap cheap = new cardManage();
        cheapService cardService = new cheapService(cheap);
        //Gerando cartas
        cardService.cardGenerator();

        //Embaralhar
        cheap.cardShuffle();

        //Distribuição de Cartas
        List<Card> cardsJogador1 = ((cardManage) cheap).cardDistribute(3); // Distribui 3 cartas para o Jogador 1
        List<Card> cardsPC = ((cardManage) cheap).cardDistribute(3); // Distribui 3 cartas para o PC
                

        // Exibir cartas do Jogador 1
        System.out.println("Cartas do Jogador 1:");
        for (Card carta : cardsJogador1) {
            System.out.println(carta);
        }

        // Exibir cartas do PC
        System.out.println("\nCartas do PC:");
        for (Card carta : cardsPC) {
            System.out.println(carta);
        }

        // Exibir a carta virada (primeira carta que ficou no baralho)
        if (!cheap.getCards().isEmpty()) {
            Card cartaVirada = cheap.getCards().get(0); // Primeira carta do baralho
            System.out.println("\nCarta Virada:");
            System.out.println(cartaVirada);
        } else {
            System.out.println("\nNão há cartas restantes para virar.");
        }
    }
}
                

