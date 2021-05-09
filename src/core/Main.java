package core;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

//Devin Kaltenbaugh and Martin Bastecki

public class Main extends Application {

    //Creates the panel and sets the window to the right size
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("<-- Several Nights at Jody's");
        primaryStage.setScene(new Scene(root, 1148, 476));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("pics/drstrausserpng.png"));

        Canvas canvas = new Canvas(1148,476);

        root.getChildren().add(canvas);
        primaryStage.show();

        MainMenu(root, canvas, primaryStage);
    }

    //Default start
    public static void main(String[] args) {
        launch(args);
    }

    //Function for creating the menu buttons and functions
    public static void MainMenu(Group root, Canvas canvas, Stage primaryStage)
    {
        Image img = new Image("pics/Title_new.png");
        canvas.getGraphicsContext2D().drawImage(img, 0, 0);

        Button btn_start = new Button();
        Button btn_game = new Button();
        Button btn_cheat = new Button();

        btn_start.setGraphic(new ImageView("pics/Menu Start Button_new.png"));
        btn_game.setGraphic(new ImageView("pics/Menu Start Button_new.png"));
        btn_cheat.setGraphic(new ImageView("pics/Menu Cheat Button_new.png"));

        btn_start.setPrefSize(192,64);
        btn_game.setPrefSize(192,64);
        btn_cheat.setPrefSize(192,64);

        btn_start.setTranslateY(330);
        btn_start.setTranslateX(465);
        btn_game.setTranslateY(230);
        btn_game.setTranslateX(465);
        btn_cheat.setTranslateY(330);
        btn_cheat.setTranslateX(465);

        //Creates the start menu button
        btn_start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                //Gives the button an image
                Image img = new Image("pics/Menu Load Screen_new.png");
                canvas.getGraphicsContext2D().drawImage(img, 0, 0);

                //Adds future buttons to the window
                root.getChildren().add(btn_game);
                root.getChildren().add(btn_cheat);

                //Hides this button
                btn_start.setTranslateY(-100);
                btn_start.setTranslateX(-100);
                btn_start.setGraphic(null);
                btn_start.setPrefSize(0,0);
            }
        });
        //Creates the start normal day button
        btn_game.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Image img = new Image("pics/Menu Load Screen_new.png");
                canvas.getGraphicsContext2D().drawImage(img, 0, 0);

                btn_game.setPrefSize(0,0);
                btn_game.setTranslateY(-100);
                btn_game.setTranslateX(-100);
                btn_game.setGraphic(null);
                btn_cheat.setPrefSize(0,0);
                btn_cheat.setTranslateY(-100);
                btn_cheat.setTranslateX(-100);
                btn_cheat.setGraphic(null);

                ArrayList<Room> RoomList = Days.DayOneRooms();
                ArrayList<Animatronic> AnimList = Days.DayOneAnim();

                GameLoop(RoomList, AnimList, new Image("pics/Cam Map without framework_new.png"), canvas, primaryStage, root);
            }
        });
        //Creates the cheat day button
        btn_cheat.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Image img = new Image("pics/Menu Load Screen_new.png");
                canvas.getGraphicsContext2D().drawImage(img, 0, 0);

                btn_game.setPrefSize(0,0);
                btn_game.setTranslateY(-100);
                btn_game.setTranslateX(-100);
                btn_game.setGraphic(null);
                btn_cheat.setPrefSize(0,0);
                btn_cheat.setTranslateY(-100);
                btn_cheat.setTranslateX(-100);
                btn_cheat.setGraphic(null);

                ArrayList<Room> RoomList = Days.DayZeroRooms();
                ArrayList<Animatronic> AnimList = Days.DayZeroAnim();

                GameLoop(RoomList, AnimList, new Image("pics/Cam Map with framework_new.png"), canvas, primaryStage, root);
            }
        });

        //Adds the start button to the window
        root.getChildren().add(btn_start);
    }


    //Function for handling the gameloop and game related functions
    public static void GameLoop(ArrayList<Room> RoomList, ArrayList<Animatronic> AnimList, Image CamMap, Canvas canvas, Stage primaryStage, Group root) {

        final int[] playerCam = {0};
        final boolean[] dead = {false};
        final double[] powerLvl = {100.0};

        //Creating the keypressed handler for checking if a key is pressed
        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {

            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.NUMPAD0)
                {
                    playerCam[0] = 1;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD1)
                {
                    playerCam[0] = 2;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD2)
                {
                    playerCam[0] = 3;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD3)
                {
                    playerCam[0] = 4;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD4)
                {
                    playerCam[0] = 5;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD5)
                {
                    playerCam[0] = 6;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD6)
                {
                    playerCam[0] = 7;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD7)
                {
                    playerCam[0] = 8;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD8)
                {
                    playerCam[0] = 9;
                }
                else if (keyEvent.getCode() == KeyCode.NUMPAD9)
                {
                    playerCam[0] = 10;
                }
                else if (keyEvent.getCode() == KeyCode.A)
                {
                    playerCam[0] = 13;
                }
                else if (keyEvent.getCode() == KeyCode.S)
                {
                    playerCam[0] = 0;
                }
                else if (keyEvent.getCode() == KeyCode.D)
                {
                    playerCam[0] = 12;
                }
                else if (keyEvent.getCode() == KeyCode.L)
                {
                    if (playerCam[0] == 13)
                    {
                        RoomList.get(13).setRoomLit();
                    }
                    else if (playerCam[0] == 12)
                    {
                        RoomList.get(12).setRoomLit();
                    }
                }
                else if (keyEvent.getCode() == KeyCode.K)
                {
                    if (playerCam[0] == 13 && !RoomList.get(13).isDoorClosed())
                    {
                        RoomList.get(13).closeDoor();
                    }
                    else if (playerCam[0] == 13 && RoomList.get(13).isDoorClosed())
                    {
                        RoomList.get(13).openDoor();
                    }
                    else if (playerCam[0] == 12 && !RoomList.get(12).isVentClosed())
                    {
                        RoomList.get(12).closeVent();
                    }
                    else if (playerCam[0] == 12 && RoomList.get(12).isVentClosed())
                    {
                        RoomList.get(12).openVent();
                    }
                }
                else if (keyEvent.getCode() == KeyCode.P && dead[0])
                {
                    MainMenu(root, canvas, primaryStage);
                }
            }
        });

        //Creating the animation timer for the gameloop to run in
        new AnimationTimer(){
            long lastUpdate = System.nanoTime();

            public void handle(long now) {
                if ((now - lastUpdate) >= 240000000000.0)
                {
                    //If the timer runs out the timer is killed
                    this.stop();
                }
                else if ((now - lastUpdate) >= 250000000.0) {

                    //For loop for checking if any of the animatronics want to move
                    for (Animatronic animatronic : AnimList)
                    {
                        if ((now - animatronic.getLastMoveTime()) >= animatronic.getCountDownTillMov())
                        {
                            animatronic.setLastMoveTime((double) now);
                            animatronic.MakeMove(RoomList);
                        }
                    }

                    if (powerLvl[0] <= 0)
                    {
                        GuiLoopNoPower(canvas, playerCam[0]);
                    }
                    else
                        {
                            //Call for rendering graphics
                            GuiLoop(canvas, CamMap, RoomList, playerCam[0]);
                        }

                    //For loop for figuring out if an animatronic
                    //has done a jump scare or not
                    for (Animatronic animatronic : AnimList)
                    {
                        if (animatronic.getJumpScare())
                        {
                            switch (animatronic.getCharacterStr()) {

                                case "Doug":
                                    Image img = new Image("pics/Doug Jump Scare_new.png");
                                    canvas.getGraphicsContext2D().drawImage(img, 0, 0);

                                    dead[0] = true;
                                    this.stop();
                                    break;
                                case "Barry":
                                    img = new Image("pics/Barry Jump Scare_new.png");
                                    canvas.getGraphicsContext2D().drawImage(img, 0, 0);

                                    dead[0] = true;
                                    this.stop();
                                    break;
                                case "Rabecca":
                                    img = new Image("pics/Rabecca Jump Scare_new.png");
                                    canvas.getGraphicsContext2D().drawImage(img, 0, 0);

                                    dead[0] = true;
                                    this.stop();
                                    break;
                                case "Framework":
                                    img = new Image("pics/Framework Jump Scare_new.png");
                                    canvas.getGraphicsContext2D().drawImage(img, 0, 0);

                                    dead[0] = true;
                                    this.stop();

                            }
                        }
                    }

                    if (RoomList.get(12).isVentClosed() == true && RoomList.get(13).isDoorClosed() == false)
                    {
                        powerLvl[0] -= 0.25;
                    }
                    else if (RoomList.get(12).isVentClosed() == false && RoomList.get(13).isDoorClosed() == true)
                    {
                        powerLvl[0] -= 0.5;
                    }
                    else if (RoomList.get(12).isVentClosed() == true && RoomList.get(13).isDoorClosed() == true)
                    {
                        powerLvl[0] -= 1.0;
                    }

                    lastUpdate = now;
                }
                else if (dead[0])
                {
                    this.stop();
                }

            }
        }.start;
    }


    //This function is used for rendering the required graphics to the window
    //This is accomplished by checking to see what is in the room and then loading that image
    //onto the window
    public static void GuiLoop(Canvas canvas,Image CamMap ,ArrayList<Room> RoomList, int CamRoom) {
        boolean DougInRoom = false;
        boolean BarryInRoom = false;
        boolean RabeccaInRoom=false;
        boolean FrameworkInRoom = false;
        boolean roomLit = false;
        boolean doorClosed = false;
        if(CamRoom >= 1) {
            for (String StringTemp : RoomList.get(CamRoom).getCharInRoom()) {
                switch (StringTemp) {
                    case "Doug":
                        DougInRoom = true;
                        break;
                    case "Barry":
                        BarryInRoom = true;
                        break;
                    case "Rabecca":
                        RabeccaInRoom = true;
                        break;
                    case "Framework":
                        FrameworkInRoom = true;
                }
            }
        }
        Image Cams = new Image("pics/Office Cams_new.png");
        switch (CamRoom) {
            case 0:

                canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                break;

            case 1:
                if (BarryInRoom && RabeccaInRoom && DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Stage Full Crew_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && RabeccaInRoom && !DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Stage Barry and Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && !RabeccaInRoom && !DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Stage Only Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Stage Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }

                break;
            case 2:
                if (BarryInRoom && RabeccaInRoom && DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Full Crew_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && RabeccaInRoom && !DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Barry and Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && !RabeccaInRoom && DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Barry and Doug_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && RabeccaInRoom && DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Rabecca and Doug_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && !RabeccaInRoom && DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Only Doug_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && RabeccaInRoom && !DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Only Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && !RabeccaInRoom && !DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Only Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Showroom Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }

                break;
            case 3:
                if (BarryInRoom && !RabeccaInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 1 Only Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && RabeccaInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 1 Only Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && !RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 1 Only Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 1 Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 4:
                if (BarryInRoom && RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Full Crew_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && RabeccaInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Barry and Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && !RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Barry and Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Rabecca and Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && !RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Only Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && RabeccaInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Only Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && !RabeccaInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Only Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 1 Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 5:
                if (BarryInRoom && !DougInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 2 Only Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && DougInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 2 Only Doug_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && !DougInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 2 Only Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Hallway 2 Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 6:
                if (BarryInRoom && DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 2 Full Crew_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (BarryInRoom && !DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 2 Only Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 2 Only Doug_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Party Room 2 Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 7:
                if (DougInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Static Frame_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Static Frame_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;


            case 8:
                if (BarryInRoom && !DougInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Office Door Only Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && DougInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Office Door Only Doug_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!BarryInRoom && !DougInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Office Door Only Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Office Door Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 9:
                if (RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Parts Room Full Crew_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (RabeccaInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Parts Room Only Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Parts Room Only Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Parts Room Empty_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 10:
                if (RabeccaInRoom && !FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Static Framer_rev_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else if (!RabeccaInRoom && FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Static Frame_rev_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Static Frame_rev_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 11:
                if (FrameworkInRoom) {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Static Framer_rev_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                } else {
                    canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                    canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                    Image CamImage = new Image("pics/Static Frame_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                }
                break;
            case 12:
                roomLit = RoomList.get(CamRoom).isRoomLit();
                doorClosed = RoomList.get(CamRoom).isVentClosed();
                if (RabeccaInRoom && !FrameworkInRoom && !roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Open Black_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (RabeccaInRoom && !FrameworkInRoom && roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Open Lit Rabecca_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!RabeccaInRoom && FrameworkInRoom && !roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Open Black_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!RabeccaInRoom && FrameworkInRoom && roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Open Lit Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (RabeccaInRoom && !FrameworkInRoom && !roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (RabeccaInRoom && !FrameworkInRoom && roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!RabeccaInRoom && FrameworkInRoom && !roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!RabeccaInRoom && FrameworkInRoom && roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!RabeccaInRoom && !FrameworkInRoom && roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!RabeccaInRoom && !FrameworkInRoom && !roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!RabeccaInRoom && !FrameworkInRoom && roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Vent Open Lit_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else {
                    Image CamImage = new Image("pics/Office Vent Open Black_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                }
                break;
            case 13:
                roomLit = RoomList.get(CamRoom).isRoomLit();
                doorClosed = RoomList.get(CamRoom).isDoorClosed();
                if (BarryInRoom && !DougInRoom && !FrameworkInRoom && !roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Door Open Black_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (BarryInRoom && !DougInRoom && !FrameworkInRoom && roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Door Open Lit Barry_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && DougInRoom && !FrameworkInRoom && !roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Door Open Black_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && DougInRoom && !FrameworkInRoom && roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Door Open Lit Doug_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && !DougInRoom && FrameworkInRoom && !roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Door Open Black_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && !DougInRoom && FrameworkInRoom && roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Door Open Lit Framework_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (BarryInRoom && !DougInRoom && !FrameworkInRoom && !roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (BarryInRoom && !DougInRoom && !FrameworkInRoom && roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && DougInRoom && !FrameworkInRoom && !roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && DougInRoom && !FrameworkInRoom && roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && !DougInRoom && FrameworkInRoom && !roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && !DougInRoom && FrameworkInRoom && roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && !DougInRoom && !FrameworkInRoom && roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && !DougInRoom && !FrameworkInRoom && !roomLit && doorClosed) {
                    Image CamImage = new Image("pics/Office Door Closed_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else if (!BarryInRoom && !DougInRoom && !FrameworkInRoom && roomLit && !doorClosed) {
                    Image CamImage = new Image("pics/Office Door Open Lit_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                } else {
                    Image CamImage = new Image("pics/Office Door Open Black_new.png");
                    canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                }
                break;

        }
    }

    public static void GuiLoopNoPower(Canvas canvas, int CamRoom) {
        if(CamRoom > 0 && CamRoom <= 11){
            CamRoom = 1;
        }
        Image CamMap = new Image("pics/Static Frame_new.png");
        Image CamImage = new Image("pics/Static Frame_rev_new.png");
        Image Cams = new Image("pics/Office Cams_new.png");
        switch (CamRoom) {
            case 0:
                canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                break;

            case 1:
                canvas.getGraphicsContext2D().drawImage(Cams, 0, 0);
                canvas.getGraphicsContext2D().drawImage(CamMap, 630, 28);
                canvas.getGraphicsContext2D().drawImage(CamImage, 28, 28);
                break;

            case 12:
                CamImage = new Image("pics/Office Vent Open Black_new.png");
                canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);
                break;
            case 13:
                CamImage = new Image("pics/Office Door Open Black_new.png");
                canvas.getGraphicsContext2D().drawImage(CamImage, 0, 0);

                break;
        }
    }
}
