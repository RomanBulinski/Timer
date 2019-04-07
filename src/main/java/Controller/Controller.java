package Controller;

import View.View;

import static javafx.application.Platform.exit;

public class Controller {


//    Start timers and give them a Name.
//    Stop a timer by Name.
//    Check a timer by Name or all timers (without a Name ).

    View view = new View();

    public Controller() {
        run();
    }

    public void run(){

        boolean flag = true;

        while(flag){
            view. emptyLine();
            switch( view.userInput("Enter your command (  start / stop / check / exit  ) : ") )  {
                case ("start"):
                    view.print("Staaaaaaaaaaaaaaaaaaaaart");
                    break;
                case ("stop"):
                    // code block
                    break;
                case ("check"):
                    // code block
                    break;

                case ("exit"):
                    flag = false;
                    exit();
                    break;
                default:
                    // code block
            }


        }



    }



}
