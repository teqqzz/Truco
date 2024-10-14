package TrucoNovo;
import java.util.*;

public class cardManage implements Cheap{
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public List<Card> getCards(){
        return cards;
    }

    public void cardShuffle() { 
        Collections.shuffle(cards);
    }

    public List<Card> cardDistribute(int numCard){
        List<Card> cardDistributed = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numCard; i++){
            int index = random.nextInt(cards.size());
            Card card = cards.get(index);
            cardDistributed.add(card);
            cards.remove(index);
        }
        return cardDistributed;
    }
}
