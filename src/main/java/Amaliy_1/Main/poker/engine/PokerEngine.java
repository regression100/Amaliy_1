package Amaliy_1.Main.poker.engine;

import Amaliy_1.Main.generator.RandomEngine;
import Amaliy_1.Main.poker.Card;
import Amaliy_1.Main.poker.Hand;

import java.util.ArrayList;

public final class PokerEngine {

    public static AbstractC driver(Hand hand, ArrayList<ArrayList<Card>> cards, int index){
        AbstractC abstractC=new AbstractC();
        Card c=new Card();
        boolean bool=false;
        for (int i = 0; i <cards.size() ; i++) {
            for (int j = 0; j <cards.get(i).size(); j++) {
                if (cards.get(i).get(j).getType().equals(hand.getCards().get(index).getType())){
                    c=hand.getCards().get(index);
                    int r1=RandomEngine.random(cards.size());
                    int r2=RandomEngine.random(cards.get(r1).size());
                    hand.getCards().set(index,cards.get(r1).get(r2));
                    cards.get(i).set(j,c);
                    bool=true;
                    break;
                }
//                if (bool) break;
            }
            if (bool) break;;
        }

        if (!bool){
            ArrayList<Card> clist=new ArrayList<>();
            int r1=RandomEngine.random(cards.size());
            int r2=RandomEngine.random(cards.get(r1).size());
            clist.add(hand.getCards().get(index));
            hand.getCards().set(index,cards.get(r1).get(r2));
            cards.get(r1).remove(hand.getCards().get(index));
            if (cards.get(r1).size()==0){
                cards.remove(cards.get(r1));
            }
            cards.add(clist);

        }
        abstractC.setHand(hand);
        abstractC.setResidue_cards(cards);
        return abstractC;

    }

}
