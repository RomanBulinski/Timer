package Controller;

import Model.Timer;
import View.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {

//    Start timers and give them a Name.
//    Stop a Timer by Name.
//    Check a Timer by Name or all timers (without a Name ).

    View view = new View();

    public Controller() {
        try {
            run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() throws InterruptedException {

        boolean flag = true;

        List<Timer> listOfTimers = new ArrayList<>();
        List<Thread> listOfThreads = new ArrayList<>();

        while (flag) {
            view.emptyLine();
            switch (view.userInput("Enter your command (  start / stop / check / exit  ) : ")) {
                case ("start"):
                    String name = view.userInput("Enter your name of Timer : ");
                    Timer timer = new Timer(name, 1, true);
                    listOfTimers.add(timer);
                    Thread timerthread = new Thread(timer);
                    listOfThreads.add(timerthread);
                    timerthread.start();

                    break;
                case ("stop"):

                    String timerForStop = view.userInput("Enter name of Timer for STOP : ");
                    int index = getIndex(timerForStop, listOfTimers);
                    listOfTimers.get(index).setFlag(false);

                    break;
                case ("check"):

                    String timerForcheck = view.userInput("Enter name of Timer for check / or tape 'all' : ");
                    if(timerForcheck.equals("all")){
                        view.printTimers(listOfTimers);
                    }else{
                        int index2 = getIndex(timerForcheck, listOfTimers);
                        view.printTimer(index2, listOfTimers);
                    }
                    break;

                case ("exit"):
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    // code block
            }
        }
    }

    public int getIndex(String timerForStop, List<Timer> listOfTimers) {

        int index = 0;
        for (int i = 0; i < listOfTimers.size(); i++) {
            if (listOfTimers.get(i).getName().equals(timerForStop)) {
                index = i;
            }
        }
        return index;
    }
}
