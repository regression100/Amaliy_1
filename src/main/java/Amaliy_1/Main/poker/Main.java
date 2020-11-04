package Amaliy_1.Main.poker;

import Amaliy_1.Main.generator.RandomEngine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Hand> hands=AllCards.generateHands(10,new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
//        System.out.println(hands);
//        assert hands != null;
//        System.out.println(AllCards.sort(hands.get(0)));
//        for (int i = 0; i <hands.size(); i++) {
//            hands.set(i, AllCards.sort(hands.get(i)));
//        }
//
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println("**************************************************************************************************");
//        for (Hand hand : hands) {
//            System.out.println(hand);
//            if (Check.royal_flush(hand)){
//                System.out.println("Royal flush");
//            }
//            else if (Check.straight_flush(hand)){
//                System.out.println("Straight flush");
//            } else if (Check.four_of_a_kind(hand)){
//                System.out.println("Four of a kind");
//            } else if (Check.full_house(hand)){
//                System.out.println("Full house");
//            } else if (Check.flush(hand)){
//                System.out.println("Flush");
//            } else if (Check.straight(hand)){
//                System.out.println("Straight");
//            } else if (Check.three_of_kind(hand)){
//                System.out.println("Three of kind");
//            } else if (Check.two_pair(hand)){
//                System.out.println("Two pair");
//            } else if (Check.one_pair(hand)){
//                System.out.println("One pair");
//            } else System.out.println("High card");
//
//            System.out.println("**************************************************************************************************");
//            System.out.println();
//            System.out.println("**************************************************************************************************");
//        }
//        for (int i = 0; i <hands.size(); i++) {
//            hands.set(i, AllCards.sort(hands.get(i)));
//        }
//        ArrayList<FinalRank> finalRanks=Check.sort_by_rank_hands(hands);
//        for (FinalRank finalRank : finalRanks) {
//            System.out.println(finalRank);
////                if (finalRank.getRank_by_position()==RankByPosition.FULL_HOUSE){
////
////                    b=false;
////                }
//        }
//











//
        boolean b=true;
        long ja=0;
//        System.out.println("FINAL RESULT:");
        while (b){
            ja++;
            ArrayList<Hand> hands=AllCards.generateHands(10,new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
//            System.out.println(hands);
            assert hands != null;
//            System.out.println(AllCards.sort(hands.get(0)));
            for (int i = 0; i <hands.size(); i++) {
                hands.set(i, AllCards.sort(hands.get(i)));
            }
            ArrayList<FinalRank> finalRanks=Check.sort_by_rank_hands(hands);

            //1 talik
//            for (FinalRank finalRank : finalRanks) {
//                if (finalRank.getRank_by_position()==RankByPosition.FULL_HOUSE){
//                    System.out.println(finalRank);
//                    b=false;
//                }
//            }

//            //Hammasi
//            for (FinalRank finalRank : finalRanks) {
//                if (finalRank.getRank_by_position()==RankByPosition.ROYAL_FLUSH){
//                    for (FinalRank finalRank1: finalRanks) {
//                        System.out.println(finalRank1);
//                    }
//                    b=false;
//                }
//            }

            //2 ta bir xil uchun
            long t=0;
            for (FinalRank finalRank : finalRanks) {
                if (finalRank.getRank_by_position()==RankByPosition.THREE_OF_KIND){
                    t++;
                }
            }
            if (t>3){
                for (FinalRank finalRank1: finalRanks) {
                    System.out.println(finalRank1);
                }
                b=false;
            }

        }
//        System.out.println();
        System.out.println(ja);

//        System.out.println(RandomEngine.random(1));


    }
}
