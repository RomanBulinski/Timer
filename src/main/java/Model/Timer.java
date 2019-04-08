package Model;

public class Timer implements Runnable {

    String name;
    int id;
    Boolean flag = true;
    int counter = 0;


    public Timer(String name, int id, Boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
    }
    
    @Override
    public void run() {
        while( flag ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                counter++;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
}
