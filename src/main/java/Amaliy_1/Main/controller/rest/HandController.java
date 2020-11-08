package Amaliy_1.Main.controller.rest;

import Amaliy_1.Main.poker.*;
import Amaliy_1.Main.poker.engine.AbstractC;
import Amaliy_1.Main.poker.engine.AbstractDto;
import Amaliy_1.Main.poker.engine.ChangeDto;
import Amaliy_1.Main.poker.engine.PokerEngine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class HandController {

    @GetMapping("generate")
    public ResponseEntity generate(@RequestParam("count") int count){
        ArrayList<ArrayList<Card>> cards=AllCards.generate();
//        System.out.println(cards);
        String[] names=new String[count];
        for (int i = 0; i <count-1 ; i++) {
            names[i]=Integer.toString(i+1)+"-bot";
        }
        names[count-1]="Siz";
        ArrayList<Hand> hands=AllCards.generateHands(cards, count,names);
//        System.out.println(cards);
        assert hands != null;
//        System.out.println(AllCards.sort(hands.get(0)));
        for (int i = 0; i <hands.size(); i++) {
            hands.set(i, AllCards.sort(hands.get(i)));
        }
//        System.out.println(cards);
        AbstractDto abstractDto=new AbstractDto(cards,hands);

        return ResponseEntity.ok(abstractDto);
    }

    @PostMapping("change")
    public ResponseEntity change(@RequestBody ChangeDto changeDto){
        AbstractC abstractC=PokerEngine.driver(changeDto.getHand(),changeDto.getCards(),changeDto.getIndex());
        abstractC.setHand(AllCards.sort(abstractC.getHand()));
        return ResponseEntity.ok(abstractC);
    }

    @PostMapping("check/hand")
    public ResponseEntity check_hand(@RequestBody Hand hand){
        return ResponseEntity.ok(Check.check_string(hand));
    }

    @PostMapping("check/all")
    public ResponseEntity check_all(@RequestBody ArrayList<Hand> hands){
//        ArrayList<FinalRank> finalRanks=Check.sort_by_rank_hands(hands);
        return ResponseEntity.ok(Check.sort_by_rank_hands(hands));
    }

}
