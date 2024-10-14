package TrucoNovo;

import java.util.*;

public interface Cheap {
    void addCard(Card card);
    List<Card> getCards();
    void cardShuffle();
    List<Card> cardDistribute(int numCard);
}
