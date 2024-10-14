package TrucoNovo;
import java.util.*;

public class cheapService {
    private final Cheap cheap;
    private Map<String, Integer> cardStrengths;

    public cheapService(Cheap cheap) {
        this.cheap = cheap;
        this.cardStrengths = new HashMap<>();
        cardStrength(); 
    }

    public void cardStrength() {
        // Definindo as forças das cartas no truco
        cardStrengths.put("Três (3)", 10);
        cardStrengths.put("Dois (2)", 9);
        cardStrengths.put("Ás (A)", 8);
        cardStrengths.put("Rei (K)", 7);
        cardStrengths.put("Valete (J)", 6);
        cardStrengths.put("Rainha (Q)", 5);
        cardStrengths.put("Sete (7)", 4);
        cardStrengths.put("Seis (6)", 3);
        cardStrengths.put("Cinco (5)", 2);
        cardStrengths.put("Quatro (4)", 1);
    }


    public void cardGenerator() {
        // Array com os nomes dos naipes
        String[] cardSuit = {" (♦)", " (♠)", " (♥)", " (♣)"};
        // Array com nome e número de carta
        String[] cardNumber = {"Quatro (4)", "Cinco (5)", "Seis (6)",  
        "Sete (7)", "Rainha (Q)", "Valete (J)", "Rei (K)", "Ás (A)", "Dois (2)", "Três (3)"};

        // For para iterar pelos naipes
        for (int i = 0; i < cardSuit.length; i++) {
            String suit = cardSuit[i];
            // For para iterar pelos números das cartas
            for (int j = 0; j < cardNumber.length; j++) {
                String number = cardNumber[j];
                int strength = cardStrengths.getOrDefault(number, 0); // Pega a força da carta com base no nome
                // Criando uma nova carta com base no naipe e no número
                Card card = new Card(number + suit, j + 1, i + 1, strength);
                // Adicionando a carta ao objeto 'Cheap' que foi injetado
                cheap.addCard(card);
            }
        }
        // Embaralhamento de Cartas
        if (cheap instanceof cardManage) {
            ((cardManage) cheap).cardShuffle();
        }
    }
}