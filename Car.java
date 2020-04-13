public class Car implements Runnable {
    private static int CARS_COUNT;
    private boolean finished=false;
    long racetime, starttime,endtime;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }


    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            race.startCD.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            race.startCD.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        starttime=System.currentTimeMillis();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        race.setWinner(this);
        System.out.println(this.name + " пересек финишную черту");
        finished=true;
        race.endCD.countDown();

    }
    public boolean isFinished(){
        return finished;
    }

    public void calculateRaceTime(){
        endtime=System.currentTimeMillis();
        racetime=endtime-starttime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
