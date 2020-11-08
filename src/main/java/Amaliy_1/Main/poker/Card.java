package Amaliy_1.Main.poker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String type;
    private int rank;
    private String symbol;
    private String color;
}
