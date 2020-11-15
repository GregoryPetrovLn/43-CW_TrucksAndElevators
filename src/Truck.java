public class Truck extends Thread {
    int load;
    int nLoads;
    static long elevator1;
    static long elevator2;

    public Truck(int load, int nLoads) {
        this.load = load;
        this.nLoads = nLoads;
    }

    @Override
    public void run() {
        for (int i = 0; i < nLoads; i++) {

            load1();
            load2();
        }
    }

    public static void setElevator1(long elevator1) {
        Truck.elevator1 = elevator1;
    }

    public static void setElevator2(long elevator2) {
        Truck.elevator2 = elevator2;
    }

    public static long getElevator1() {
        return elevator1;
    }

    public static long getElevator2() {
        return elevator2;
    }


    private void load2() {
        elevator2 += load;
    }

    private void load1() {
        elevator1 += load;
    }

}
