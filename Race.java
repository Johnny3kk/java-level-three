import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private ArrayList<Stage> stages;
    private final int CARS_COUNT;
    public CountDownLatch startCD;
    public CountDownLatch endCD;
    private Lock lock = new ReentrantLock();
    private Object winnerLock = new Object();
    private boolean hasWinner = false;
    private ArrayList<Car> winnerList = new ArrayList<>();

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(int cars_count, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.CARS_COUNT = cars_count;
        startCD = new CountDownLatch(CARS_COUNT);
        endCD = new CountDownLatch(CARS_COUNT);
    }

    public void setWinner(Car winner) {

        if (!hasWinner) {
            winner.calculateRaceTime();
            lock.lock();
            hasWinner = true;
            winnerList.add(winner);
            lock.unlock();
        }
        else winner.calculateRaceTime();

    }


    public ArrayList<Car> getWinnerList() {
        return winnerList;
    }
}
