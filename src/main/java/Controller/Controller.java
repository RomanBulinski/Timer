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
        runner();
    }

    public void runner() {

        boolean flag = true;

        List<String> namesOfThreads = new ArrayList<>();
        List<Timer> listOfTimers = new ArrayList<>();
        List<Thread> listOfThreads = new ArrayList<>();

        while (flag) {
            view.emptyLine();
            String[] userinput = (view.userInput("Enter your command (  start/stop/check/exit  ) : ")).split(" ");
            if (userinput.length == 1) {
                if (userinput[0].equals("check")) {
                    view.printThreads(listOfThreads, listOfTimers);
                }
                if (userinput[0].equals( "exit")) {
                    System.exit(0);
                }
            }
            if (userinput.length == 2) {
                if (userinput[0].equals( "check")) {
                    view.printThread( userinput[1] ,listOfThreads, listOfTimers);
                }
                if (userinput[0].equals("stop")) {
                    int index = getIndex(userinput[1], listOfThreads);
                    listOfThreads.get(index).interrupt();
                }
                if (userinput[0].equals("start") ){
                    String name = userinput[1];
                    if (namesOfThreads.contains(name)) {
                        int index = getIndex(name, listOfThreads);
                        listOfTimers.remove(index);
                        listOfThreads.remove(index);
                        Timer timer = getTimer(listOfTimers, name);
                        startThread(listOfThreads, name, timer);
                    }else{
                        namesOfThreads.add(name);
                        Timer timer = getTimer(listOfTimers, name);
                        startThread(listOfThreads, name, timer);
                    }
                }
            }
        }
    }

    private Timer getTimer(List<Timer> listOfTimers, String name) {
        Timer timer = new Timer(name);
        listOfTimers.add(timer);
        return timer;
    }

    private void startThread(List<Thread> listOfThreads, String name, Timer timer) {
        Thread timerthread = new Thread(timer);
        timerthread.setName(name);
        listOfThreads.add(timerthread);
        timerthread.start();
    }

    public int getIndex(String threadForStop, List<Thread> listOfThreads) {
        int index = 0;
        for (int i = 0; i < listOfThreads.size(); i++) {
            if (listOfThreads.get(i).getName().equals(threadForStop)) {
                index = i;
            }
        }
        return index;
    }
}
