package Amaliy_1.Main.poker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalRank {
    private String name;
    private int rank_by_position;
    private Hand hand;
}
