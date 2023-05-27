package part07.observer;

import java.util.Random;

public enum Occupation {

    developerSenior, developerJunior, administrativeWorker, worker, lawyer, financial;

    private static final Random PRNG = new Random();

    public static Occupation randomOccupation() {
        Occupation[] occupations = values();
        return occupations[PRNG.nextInt(occupations.length)];
    }

}
