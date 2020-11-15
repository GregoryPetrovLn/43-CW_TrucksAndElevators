import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


public class TrucksAppl {
    private static final int N_TRUCKS = 1_000_000;
    private static final int N_LOADS = 1;
    private static final int LOAD = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        Truck[] trucks = new Truck[N_TRUCKS];
        Instant start = Instant.now();

        startLoads(trucks);
        waitForLoadsFinish(trucks);

        System.out.printf("Elevator #1 is loaded with %d tons\n" +
                        "Elevator #2 is loaded with %d tons\n" +
                        "Running time is %d millis\n",
                Truck.getElevator1(), Truck.getElevator2(), ChronoUnit.MILLIS.between(start, Instant.now()));
    }

    private static void waitForLoadsFinish(Truck[] trucks) throws InterruptedException {
        for (Truck truck : trucks) {
            truck.join();
        }
    }

    private static void startLoads(Truck[] trucks) {
        for (int i = 0; i < N_TRUCKS; i++) {
            trucks[i] = new Truck(LOAD, N_LOADS);
            trucks[i].start();
        }

    }
}
