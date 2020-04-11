public class HomeWork4 {
    static Character character = 'A';


    public static void main(String[] args) {

        Object lock = new Object();

        class Mytask implements Runnable {
            private Character currentCharacter;
            private Character nextCharacter;

            public Mytask(Character currentCharacter, Character nextCharacter) {
                this.currentCharacter = currentCharacter;
                this.nextCharacter = nextCharacter;
            }

            private void printCharacter() {
                synchronized (lock) {
                    try {
                        for (int i = 0; i < 5; i++) {
                            while (!character.equals(currentCharacter)) lock.wait();
                            System.out.println(currentCharacter);
                            character = nextCharacter;
                            Thread.sleep(1);
                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void run() {
                printCharacter();
            }
        }
        new Thread(new Mytask('A', 'B')).start();
        new Thread(new Mytask('B', 'C')).start();
        new Thread(new Mytask('C', 'A')).start();
    }
}
