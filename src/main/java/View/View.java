package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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



    //    Start timers and give them a Name.
//    Stop a timer by Name.
//    Check a timer by Name or all timers (without a Name ).


}
