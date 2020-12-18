package Amaliy_1.Main.controller.rest;

import Amaliy_1.Main.hill_climbing.a.ApiModel;
import Amaliy_1.Main.hill_climbing.a.ArrayModel;
import Amaliy_1.Main.hill_climbing.a.HillClimbing;
import Amaliy_1.Main.hill_climbing.a.State;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("api")
public class HillClimbingController {

    @PostMapping("hill")
    public ResponseEntity hill(@RequestBody ArrayModel arrayModel){
        ApiModel apiModel=new ApiModel();
        HillClimbing hillClimbing = new HillClimbing();
        if (!Arrays.toString(Arrays.stream(arrayModel.getS1()).sorted().toArray()).equals(Arrays.toString(Arrays.stream(arrayModel.getS2()).sorted().toArray()))){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        Stack<String> startState = hillClimbing.getStackWithValues(arrayModel.getS1());
        Stack<String> goalState = hillClimbing.getStackWithValues(arrayModel.getS2());
        try {
            List<State> solutionSequence = hillClimbing.getRouteWithHillClimbing(startState, goalState);
//            solutionSequence.forEach(HillClimbing::printEachStep);

            List<List<String>> api=new ArrayList<>();
//            System.out.println(api);



            for (State state : solutionSequence) {
                api.add(HillClimbing.printEachStep(state));
            }
//            System.out.println(api);
            apiModel.setLists(api);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(apiModel);
    }
}
