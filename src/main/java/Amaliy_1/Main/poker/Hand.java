package Amaliy_1.Main.poker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hand {
    private String name;
    private ArrayList<Card> cards;
}
