package Amaliy_1.Main.poker;

import Amaliy_1.Main.generator.RandomEngine;
import lombok.Data;

import java.util.ArrayList;

@Data
public final class AllCards {
    private static ArrayList<Card> gishtlar=new ArrayList<>();
    private static ArrayList<Card> topponlar=new ArrayList<>();
    private static ArrayList<Card> chilliklar=new ArrayList<>();
    private static ArrayList<Card> qargalar=new ArrayList<>();
//    private static TypeList typeList;

    public static ArrayList<ArrayList<Card>> generate(){
        ArrayList<ArrayList<Card>> cards=new ArrayList<>();
        for (int i = 2; i <=14; i++) {
            Card gisht=new Card("gisht",i);
            Card toppon=new Card("toppon",i);
            Card chillik=new Card("chillik",i);
            Card qarga=new Card("qarga", i);
            gishtlar.add(gisht);
            topponlar.add(toppon);
            chilliklar.add(chillik);
            qargalar.add(qarga);


        }
        cards.add(gishtlar);
        cards.add(topponlar);
        cards.add(chilliklar);
        cards.add(qargalar);
        return cards;
    }

    public static ArrayList<Hand> generateHands(int handCount, String[] names){
        if (handCount>10||handCount<2||names.length!=handCount){
            return null;
        }
        ArrayList<Hand> hands=new ArrayList<>();
        ArrayList<ArrayList<Card>> cards=generate();

        for (int i = 0; i < handCount; i++) {
            Hand hand=new Hand();
            hand.setName(names[i]);
            ArrayList<Card> currentHandCards=new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < cards.size(); k++) {
                    if (cards.get(k).size()==0){
                        cards.remove(cards.get(k));
                    }
                }
                int rand=RandomEngine.random(cards.size());
                int rand2=RandomEngine.random(cards.get(rand).size());

                Card card=new Card(cards.get(rand).get(rand2).getType(),cards.get(rand).get(rand2).getRank());
                cards.get(rand).remove(cards.get(rand).get(rand2));
                currentHandCards.add(card);


            }
            hand.setCards(currentHandCards);
            hands.add(hand);
        }
//        viewResidue(cards);
        return hands;
    }

    public static void viewResidue(ArrayList<ArrayList<Card>> residue){
        System.out.println(residue);
    }

    public static Hand sort(Hand hand){
        Card card1=new Card();
//        Card card2=new Card();
        for (int i = 0; i <hand.getCards().size() ; i++) {
            for (int j = i+1; j <hand.getCards().size(); j++) {
                if (hand.getCards().get(i).getRank()>hand.getCards().get(j).getRank()){
                    card1=hand.getCards().get(i);
                    hand.getCards().set(i,hand.getCards().get(j));
                    hand.getCards().set(j,card1);
                }
            }
        }
        return hand;
    }


}
