package View;

import Model.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class View {

    public void emptyLine() {
        System.out.println();
    }

    public void print(String string) {
        System.out.println(string);
    }

    public String userInput(String string) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print(string);
        String command = null;
        try {
            command = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return command;
    }

    public void printThreads(List<Thread> listOfThreads, List<Timer> listOfTimers) {
//        listOfThreads.stream()
//                .forEach(n-> System.out.println( "Name: "+ n.getName() +", ThreadId: "+n.getId()+", Seconds:" ));
        String tmpName = "";
        int tempCounter = 0;
        for (int i = 0; i < listOfThreads.size(); i++) {
            for (int j = 0; j < listOfTimers.size(); j++) {
                if (listOfThreads.get(i).getName().equals(listOfTimers.get(j).getName())) {
                    tmpName = listOfThreads.get(i).getName();
                    tempCounter = listOfTimers.get(j).getCounter();
                }
            }
            System.out.println("Name: " + tmpName + ", ThreadId: " + listOfThreads.get(i).getId() + ", Seconds: " + tempCounter);
        }
    }

    public void printThread(String threadForcheck, List<Thread> listOfThreads, List<Timer> listOfTimers) {
        listOfThreads.stream()
                .filter(n -> n.getName().equals(threadForcheck))
                .forEach(n -> System.out.print("Name: " + n.getName() + ", ThreadId: " + n.getId() + ", Seconds: "));

        int tempCounter = 0;
        for (int j = 0; j < listOfTimers.size(); j++) {
            if (listOfTimers.get(j).getName().equals(threadForcheck)) {
                tempCounter = listOfTimers.get(j).getCounter();
            }
        }
        System.out.println(tempCounter);
    }

}
