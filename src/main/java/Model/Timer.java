package Model;

public class Timer implements Runnable {

    private String name = "";
    private int counter = 0;
    private boolean flag = true;

    public Timer(String name ) {
        this.name = name;
    }

    @Override
    public void run() {
            try {
                while( flag ){
                    Thread.sleep(1000);
                    counter++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


}
