package View;

import Model.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class View {


    public void emptyLine(){
        System.out.println();
    }

    public void print(String string){
        System.out.println( string );
    }


    public String userInput( String string ){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print( string );

        String command = null;
        try {
            command = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return command;
    }

    public void printTimers( List<Timer> listOfTimers ){
        listOfTimers.stream()
                .forEach(n-> System.out.println( "Name: "+ n.getName() +", ThreadId: "+n.getId()+", Seconds:"+n.getCounter()));
    }


//    Name: TEA, ThreadId: 13, Seconds: 15


    public void printTimer ( int index, List<Timer> listOfTimers  ){
        Timer tempTimer = listOfTimers.get(index);
        System.out.println( "Name: "+ tempTimer.getName() +", ThreadId: "+tempTimer.getId()+", Seconds:"+tempTimer.getCounter());
    }






    //    Start timers and give them a Name.
//    Stop a Timer by Name.
//    Check a Timer by Name or all timers (without a Name ).


}
