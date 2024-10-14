package TrucoNovo;

public class Card {
    private String cardName;
    private int cardNumber;
    private int cardSuit;
    private int cardStrength;

    // Construtor com quatro parâmetros
    public Card(String cardName, int cardNumber, int cardSuit, int cardStrength) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardSuit = cardSuit;
        this.cardStrength = cardStrength;
    }

    // Método para retornar a representação em string da carta
    @Override
    public String toString() {
        return cardName;
    }

    // Getter para a força da carta
    public int getCardStrength() {
        return cardStrength;
    }
}