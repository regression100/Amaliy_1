package Amaliy_1.Main.poker;

import java.util.ArrayList;

public final class Check {



//    public static int amount_rank_check(Hand hand){
//        return hand.getCards().get(0).getRank()+hand.getCards().get(1).getRank()+hand.getCards().get(2).getRank()+hand.getCards().get(3).getRank()+hand.getCards().get(4).getRank();
//    }

    public static boolean royal_flush(Hand hand){

        return straight(hand) && flush(hand) && hand.getCards().get(0).getRank()==10;

    }

    public static boolean straight_flush(Hand hand){
        return straight(hand) && flush(hand);
    }

    public static boolean four_of_a_kind(Hand hand){
        int sanovchi=0;
        for (int i = 0; i <4 ; i++) {
            if (hand.getCards().get(i).getRank()==hand.getCards().get(i+1).getRank()){
                sanovchi++;
            }
            else break;
        }
        if (sanovchi==3){
            return true;
        }
        else {
            sanovchi=0;
            for (int i = 1; i <4 ; i++) {
                if (hand.getCards().get(i).getRank()==hand.getCards().get(i+1).getRank()){
                    sanovchi++;
                }
                else return false;
            }
            return sanovchi==3;
        }
    }

    public static boolean full_house(Hand hand){

        if (three_of_kind(hand)){
            int rank0=hand.getCards().get(0).getRank();
            int rank1=hand.getCards().get(1).getRank();
            int rank2=hand.getCards().get(2).getRank();
            int rank3=hand.getCards().get(3).getRank();
            int rank4=hand.getCards().get(4).getRank();
            if (rank0!=rank2){
                return rank0 == rank1;
            } else if (rank4!=rank2){
                return rank3==rank4;
            } else return false;
        }
        else return false;
    }

    public static boolean flush(Hand hand){
        String type=hand.getCards().get(0).getType();
        String type2=hand.getCards().get(1).getType();
        String type3=hand.getCards().get(2).getType();
        String type4=hand.getCards().get(3).getType();
        String type5=hand.getCards().get(4).getType();
        return type.equals(type2) && type.equals(type3) && type.equals(type4) && type.equals(type5);
    }

    public static boolean straight(Hand hand){
        boolean bool=false;
        if (hand.getCards().get(0).getRank()!=2){
            for (int i = 0; i <4 ; i++) {
                if (hand.getCards().get(i).getRank()==hand.getCards().get(i+1).getRank()-1){
                    bool=true;
                }
                else {
                    bool=false;
                    break;
                }
            }
            return bool;
        }
        else {
            for (int i = 0; i <3 ; i++) {
                if (hand.getCards().get(i).getRank()==hand.getCards().get(i+1).getRank()-1){
                    bool=true;
                }
                else {
                    bool=false;
                    break;
                }
            }
            return hand.getCards().get(4).getRank() == 14 && bool;
        }
    }

    public static boolean three_of_kind(Hand hand){
        int rank0=hand.getCards().get(0).getRank();
        int rank1=hand.getCards().get(1).getRank();
        int rank2=hand.getCards().get(2).getRank();
        int rank3=hand.getCards().get(3).getRank();
        int rank4=hand.getCards().get(4).getRank();

        if (rank0==rank1&&rank1==rank2){
            return true;
        }
        else {
            if (rank1==rank2&&rank2==rank3){
                return true;
            }
            else {
                return rank2 == rank3 && rank3 == rank4;
            }
        }

    }

    public static boolean two_pair(Hand hand){
        int rank0=hand.getCards().get(0).getRank();
        int rank1=hand.getCards().get(1).getRank();
        int rank2=hand.getCards().get(2).getRank();
        int rank3=hand.getCards().get(3).getRank();
        int rank4=hand.getCards().get(4).getRank();
        return (rank0==rank1&&rank2==rank3)||(rank1==rank2&&rank3==rank4);
    }

    public static boolean one_pair(Hand hand){
        int rank0=hand.getCards().get(0).getRank();
        int rank1=hand.getCards().get(1).getRank();
        int rank2=hand.getCards().get(2).getRank();
        int rank3=hand.getCards().get(3).getRank();
        int rank4=hand.getCards().get(4).getRank();
        return (rank0==rank1)||(rank1==rank2)||(rank2==rank3)||(rank3==rank4);
    }


    public static ArrayList<FinalRank> generate_final_rank_by_card_position(ArrayList<Hand> hands){
        ArrayList<FinalRank> ranks = new ArrayList<>();
        for (Hand hand : hands) {

            FinalRank finalRank=new FinalRank();
            finalRank.setHand(hand);
//            System.out.println(hand);
            if (Check.royal_flush(hand)){
                finalRank.setName("Royal flush");
                finalRank.setRank_by_position(RankByPosition.ROYAL_FLUSH);
            }
            else if (Check.straight_flush(hand)){
                finalRank.setName("Straight flush");
                finalRank.setRank_by_position(RankByPosition.STRAIGHT_FLUSH);
            } else if (Check.four_of_a_kind(hand)){
                finalRank.setName("Four of a kind");
                finalRank.setRank_by_position(RankByPosition.FOUR_OF_A_KIND);
            } else if (Check.full_house(hand)){
                finalRank.setName("Full house");
                finalRank.setRank_by_position(RankByPosition.FULL_HOUSE);
            } else if (Check.flush(hand)){
                finalRank.setName("Flush");
                finalRank.setRank_by_position(RankByPosition.FLUSH);
            } else if (Check.straight(hand)){
                finalRank.setName("Straight");
                finalRank.setRank_by_position(RankByPosition.STRAIGHT);
            } else if (Check.three_of_kind(hand)){
                finalRank.setName("Three of kind");
                finalRank.setRank_by_position(RankByPosition.THREE_OF_KIND);
            } else if (Check.two_pair(hand)){
                finalRank.setName("Two pair");
                finalRank.setRank_by_position(RankByPosition.TWO_PAIR);
            } else if (Check.one_pair(hand)){
                finalRank.setName("One pair");
                finalRank.setRank_by_position(RankByPosition.ONE_PAIR);
            } else {
                finalRank.setName("High card");
                finalRank.setRank_by_position(RankByPosition.HIGH_CARD);
            }
            ranks.add(finalRank);
        }

        return ranks;
    }

    public static ArrayList<FinalRank> sort_by_rank_hands(ArrayList<Hand> hands){

        ArrayList<FinalRank> finalRanks=generate_final_rank_by_card_position(hands);
        for (int i = 0; i <finalRanks.size(); i++) {
            for (int j = i+1; j <finalRanks.size(); j++) {
                if (finalRanks.get(i).getRank_by_position()>finalRanks.get(j).getRank_by_position()){
                    FinalRank temp=finalRanks.get(i);
                    finalRanks.set(i,finalRanks.get(j));
                    finalRanks.set(j,temp);
                }
            }
        }

        for (int i = 0; i <finalRanks.size()-1; i++) {
            FinalRank temp=new FinalRank();
            if (finalRanks.get(i).getRank_by_position()==finalRanks.get(i+1).getRank_by_position()){
                if (compare_by_final_rank(finalRanks.get(i),finalRanks.get(i+1))){
                    temp=finalRanks.get(i);
                    finalRanks.set(i,finalRanks.get(i+1));
                    finalRanks.set(i+1,temp);
                }

            }
        }
        return finalRanks;

    }

    public static boolean compare_by_final_rank(FinalRank finalRank1, FinalRank finalRank2){
        if (finalRank1.getRank_by_position()!=RankByPosition.ROYAL_FLUSH){


            int frank0=finalRank1.getHand().getCards().get(0).getRank();
            int frank1=finalRank1.getHand().getCards().get(1).getRank();
            int frank2=finalRank1.getHand().getCards().get(2).getRank();
            int frank3=finalRank1.getHand().getCards().get(3).getRank();
            int frank4=finalRank1.getHand().getCards().get(4).getRank();

            int f2rank0=finalRank2.getHand().getCards().get(0).getRank();
            int f2rank1=finalRank2.getHand().getCards().get(1).getRank();
            int f2rank2=finalRank2.getHand().getCards().get(2).getRank();
            int f2rank3=finalRank2.getHand().getCards().get(3).getRank();
            int f2rank4=finalRank2.getHand().getCards().get(4).getRank();

//            if (finalRank1.getRank_by_position()==RankByPosition.STRAIGHT_FLUSH){
//                return finalRank1.getHand().getCards().get(4).getRank() > finalRank2.getHand().getCards().get(4).getRank();
//            }

            if (finalRank1.getRank_by_position()==RankByPosition.STRAIGHT_FLUSH||finalRank1.getRank_by_position()==RankByPosition.STRAIGHT||finalRank1.getRank_by_position()==RankByPosition.FLUSH){
                return frank4 > f2rank4;
            }
            else if (finalRank1.getRank_by_position()==RankByPosition.FULL_HOUSE){
//                if (frank0==frank1&&frank1==frank2){
//                    if (f2rank0==f2rank1&&frank1==f2rank2){
//                        return frank0>f2rank0;
//                    } else {
//                        return frank0 > f2rank4;
//                    }
//
//                } else {
//                    if (f2rank0==f2rank1&&f2rank1==f2rank2){
//                        return frank4>f2rank0;
//                    } else {
//                        return frank4 > f2rank4;
//                    }
//                }

                if (frank0==frank1&&frank1==frank2){
                    if (f2rank0==f2rank1&&frank1==f2rank2){
                        if (frank0>f2rank0){
                            return true;
                        }
                        if (frank0<f2rank0) {
                            return false;
                        } else {
                            return frank4>f2rank4;
                        }
                    } else {
                        return frank0 > f2rank4;
                    }
                } else {
                    if (f2rank0==f2rank1&&f2rank1==f2rank2){
                        return frank4 > f2rank0;
                    } else {
                        if (frank4>f2rank4){
                            return true;
                        } else {
                            if (frank4==f2rank4){
                                return frank0>f2rank0;
                            } else return false;
                        }
                    }
                }

            } else if (finalRank1.getRank_by_position()==RankByPosition.FOUR_OF_A_KIND){
                if(frank2>f2rank2){
                    return true;
                } else if (frank2==f2rank2){
                    return frank0 > f2rank0 || frank4 > f2rank4;
                } else return false;
            } else if (finalRank1.getRank_by_position()==RankByPosition.THREE_OF_KIND){
                if (frank2>f2rank2){
                    return true;
                } else if (frank2==f2rank2){
                    int max=0;
                    int min=0;
                    int max2=0;
                    int min2=0;
                    if (frank2!=frank0) min=frank0;
                    if (frank2!=frank4) max=frank4;
                    if (frank2!=frank1) {
                        min=frank0;
                        max=frank1;
                    }
                    if (frank2!=frank3){
                        min=frank3;
                        max=frank4;
                    }

                    if (f2rank2!=f2rank0) min2=f2rank0;
                    if (f2rank2!=f2rank4) max2=f2rank4;
                    if (f2rank2!=f2rank1) {
                        min2=f2rank0;
                        max2=f2rank1;
                    }
                    if (f2rank2!=f2rank3){
                        min2=f2rank3;
                        max2=f2rank4;
                    }
                    if (max>max2) {
                        return true;
                    } else if (max==max2){
                        return min > min2;
                    } else return false;


                } else return false;
            } else if (finalRank1.getRank_by_position()==RankByPosition.TWO_PAIR){
//                if (frank3>f2rank3){
//                    return true;
//                } else if (frank3==f2rank3){
//                    if (frank1>f2rank1) {
//                        return true;
//                    } else if (frank1==f2rank1){
//                        if (frank4>f2rank4) return true;
//                        if (frank2>f2rank2) return true;
//                        return frank0 > f2rank0;
//                    } else return false;
//                } else return false;
                if (frank0==frank1&&frank2==frank3){
                    if (f2rank0==f2rank1&&f2rank2==f2rank3){
                        if (frank3<f2rank3) return false;
                        if (frank3==f2rank3){
                            if (frank0<f2rank0) return false;
                            if (frank0==f2rank0){
                                return frank4>f2rank4;
                            }
                        } else return true;
                    }
                }


            } else if (finalRank1.getRank_by_position()==RankByPosition.ONE_PAIR){
                ArrayList<Integer> franks=new ArrayList<>();
                ArrayList<Integer> franks2=new ArrayList<>();
                franks.add(frank0);
                franks.add(frank1);
                franks.add(frank2);
                franks.add(frank3);
                franks.add(frank4);
                franks2.add(f2rank0);
                franks2.add(f2rank1);
                franks2.add(f2rank2);
                franks2.add(f2rank3);
                franks2.add(f2rank4);
                boolean m=true;
                boolean n=true;
                for (int i = 0; i < 4; i++) {
                    if (m&&franks.get(i).equals(franks.get(i + 1))){
                        franks.remove(franks.get(i));
                        franks.remove(franks.get(i));
                        m=false;
                    }
                    if (n&&franks2.get(i).equals(franks2.get(i + 1))){
                        franks2.remove(franks2.get(i));
                        franks2.remove(franks2.get(i));
                        n=false;
                    }
                }
                for (int i = 2; i >= 0; i--) {
                    if (franks.get(i)>franks2.get(i)) {
                        return true;
                    }
                } return false;
            } else {
                if (frank4>f2rank4) return true;
                if (frank4==f2rank4){
                    if (frank3>f2rank3) return true;
                    if (frank3==f2rank3){
                        if (frank2>f2rank2) return true;
                        if (frank2==f2rank2){
                            if (frank1>f2rank1) return true;
                            if (frank1==f2rank1){
                                return frank0 > f2rank0;
                            } return false;
                        } return false;
                    } return false;

                } else return false;

            } return false;



        }
        else return false;
    }

    public static ArrayList<Hand> sort_special(ArrayList<Hand> hands){

    }

}
