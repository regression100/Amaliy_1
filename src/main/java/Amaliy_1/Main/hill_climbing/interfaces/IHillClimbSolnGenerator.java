package Amaliy_1.Main.hill_climbing.interfaces;

/**
 * Generates random states(IHillClimbSolution) to be used for random restarts in HillClimbRandRestart.
 */
public interface IHillClimbSolnGenerator {
    /**
     * Generates a random IHillClimbSolution to be used by HillClimbRandRestart
     *
     * @return a random IHillClimbSolution
     */
    IHillClimbSolution randomSolution();

}
