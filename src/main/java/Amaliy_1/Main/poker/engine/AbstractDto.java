package Amaliy_1.Main.poker.engine;

import Amaliy_1.Main.poker.Card;
import Amaliy_1.Main.poker.Hand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractDto {
    private ArrayList<ArrayList<Card>> cards;
    private ArrayList<Hand> hands;
}
