package org.max.seminar;

import org.junit.jupiter.api.*;
import org.max.seminar.exception.DeckEmptyException;
import org.max.seminar.type.Ranks;
import org.max.seminar.type.Suits;

import java.util.ArrayList;
import java.util.List;

public class MyDeckTest {
    static  List<Card> cards;
    Deck demo;
    @BeforeAll
    static void beforeAll(){
        cards = new ArrayList<>();
    }
    @BeforeEach
    void Unit(){
        demo = new Deck(cards);
    }
    @AfterEach
    void afterEach(){
        cards.clear();
    }
    @Test
    @Disabled
    void getEmptyDeck() throws DeckEmptyException {
        Assertions.assertThrows(DeckEmptyException.class,()-> demo.getCard());
    }

    @Test
    void getOneCard() throws DeckEmptyException {
        Card card = new Card(Ranks.ACE, Suits.HEARTS);
        cards.add(card);
        Card newCard = demo.getCard();
        Assertions.assertAll(
                ()->Assertions.assertEquals(card, newCard),
                ()->Assertions.assertThrows(DeckEmptyException.class,()-> demo.getCard()),
                ()->Assertions.assertEquals(0, demo.getCards().size())
        );
    }

}
