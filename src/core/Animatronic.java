package core;

import java.util.ArrayList;
import java.util.Arrays;

//Devin Kaltenbaugh and Martin Bastecki

public class Animatronic {
    private int currentRoomNum;
    private double LastMoveTime = 0;
    double CountDownTillMov;// variables that hold current room number
    private float AngryLevel; //determines how angry the animatronic is and therefore speed up decision making, lower = more peeved off
    private ArrayList<Integer> attachedRooms, offLimitsRooms; //grabs arraylist from Room class to see what Rooms can be moved into
    // offLimitsRooms list that contains rooms that animatronics cant move to and filters from list obtained from Rooms
    private String characterStr; //name of character, dumbass
    private boolean attackReady, jumpScare; //bool used to check if the animatronic will kill on next game update

    public String getCharacterStr(){//Gets character name, doesn't need setter
        return characterStr;
    }//gets character string for setting arraylists
    public int getCurrentRoomNum(){//Gets current room the animatronic is in
        return currentRoomNum;
    }//gets current room to grab the next room in functions
    public void setCurrentRoomNum(int newRoomNum){//sets a new room when animatronic moves
        currentRoomNum = newRoomNum;
    }//sets the current animatronic room based on room object they are in
    public double getCountDownTillMov(){//gives the remaining countdown until an animatronic moves
        return CountDownTillMov;
    }
    public void setCountDownTillMov(){//sets countdown for animatronic as needed
        CountDownTillMov *= AngryLevel;
    }
    public float getAngryLevel(){//returns angry level
        return AngryLevel;
    }
    public void setAngryLevel(float newAngryLevel){//sets angry level
        AngryLevel = newAngryLevel;
    }
    public void setAttackReady(){//sets attack to ready if the animatronic is in the doorway and door is not closed
        attackReady = true;
    }//toggles attack ready
    public boolean getJumpScare(){//returns angry level
        return jumpScare;
    }
    public double getLastMoveTime() { return LastMoveTime; }
    public void setLastMoveTime( double newLastMoveTime ) { LastMoveTime = newLastMoveTime; }
    public void setRoomNumAndAttachedRooms(int roomNum, ArrayList<Integer> List){//combined setter cause we may need separate
        setCurrentRoomNum(roomNum);
        setAttachedRooms(List);
    }
    public void setAttachedRooms(ArrayList<Integer> newAttachedRooms){//sets the animatronic's room list to be the same as the current room
        attachedRooms.clear();
        for(Integer IntTemp2: newAttachedRooms){
            attachedRooms.add(IntTemp2);
        }
        for(Integer IntTemp : offLimitsRooms){ //filters out the rooms the animatronic cannot move to based on their offLimits
            attachedRooms.remove(IntTemp.toString());
        }

    }

    public boolean getAttackReady(){//sets attack to ready if the animatronic is in the doorway and door is not closed
        return attackReady;
    }//toggles attack ready bool

    public ArrayList<Integer> getAttachedRooms(){
        return attachedRooms;
    }//grabs the attached rooms from the animatronics, mostly used for testing to see if the attached rooms in the object is correct

    public void MakeMove(ArrayList<Room> RoomList){}//Function determines how the animatronics move, so each one will be heavily modified


//==========================================================================================================
//Start of personalized Animatronic classes

    public static class Doug extends Animatronic{
    int currentRoomNum = 1;
    private double CountDownTillMov = 20000000000.0;
    private double LastMoveTime = 20000000000.0;
    int randomIndex;
    float AngryLevel;
    private ArrayList<Integer> attachedRooms = new ArrayList<Integer>();
    private ArrayList<Integer> offLimitsRooms = new ArrayList<Integer>(Arrays.asList(3, 4, 9, 10, 11, 12));
    String characterStr = "Doug";
    boolean attackReady = false;
    boolean jumpScare = false;


        public String getCharacterStr(){//Gets character name, doesn't need setter
            return characterStr;
        }
        public int getCurrentRoomNum(){//Gets current room the animatronic is in
            return currentRoomNum;
        }
        public void setCurrentRoomNum(int newRoomNum){//sets a new room when animatronic moves
            currentRoomNum = newRoomNum;
        }
        public double getCountDownTillMov(){//gives the remaining countdown until an animatronic moves
            return CountDownTillMov;
        }
        public void setCountDownTillMov(){//sets countdown for animatronic as needed
            CountDownTillMov *= AngryLevel;
        }
        public float getAngryLevel(){//returns angry level
            return AngryLevel;
        }
        public boolean getJumpScare(){//returns angry level
            return jumpScare;
        }
        public double getLastMoveTime() { return LastMoveTime; }
        public void setLastMoveTime( double newLastMoveTime ) { LastMoveTime = newLastMoveTime; }
        public void setAngryLevel(float newAngryLevel){//sets angry level
            AngryLevel = newAngryLevel;
        }
        public void setAttackReady(){
            if (attackReady){
                attackReady = false;
            }
            else{
                attackReady = true;
            }
        }
        public void setRoomNumAndAttachedRooms(int roomNum, ArrayList<Integer> List){
            setCurrentRoomNum(roomNum);
            setAttachedRooms(List);
        }

        public boolean getAttackReady(){//sets attack to ready if the animatronic is in the doorway and door is not closed
            return attackReady;
        }

        public void setAttachedRooms(ArrayList<Integer> newAttachedRooms){//sets the animatronic's room list to be the same as the current room
            attachedRooms.clear();
            for(Integer IntTemp2: newAttachedRooms){
                attachedRooms.add(IntTemp2);
            }
            for(Integer IntTemp : offLimitsRooms){ //filters out the rooms the animatronic cannot move to based on their offLimits
                attachedRooms.remove(IntTemp.toString());
            }

        }

        public ArrayList<Integer> getAttachedRooms(){
            return attachedRooms;
        }

        public void MakeMove(ArrayList<Room> RoomList){

            if(attackReady == true){
                if (RoomList.get(currentRoomNum).isDoorClosed() == true)
                {
                    setAttackReady();
                    RoomList.get(2).addCharacterToRoom(characterStr);
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);
                    setRoomNumAndAttachedRooms(RoomList.get(2).getRoomNum(), RoomList.get(2).getAttachedRooms());
                }
                else
                    {
                        jumpScare = true;
                    }
            }
            else if(currentRoomNum == 13 && RoomList.get(currentRoomNum).isDoorClosed() == false){//sets attack to ready state if in office doorway and door isnt close
                setAttackReady();
            }
            else if(currentRoomNum == 1){ //precheck for characters like doug that are already in a room to start out with
                setRoomNumAndAttachedRooms(RoomList.get(1).getRoomNum(), RoomList.get(1).getAttachedRooms()); //sets the attached room set and room number to the second one if they are on stage to jump out of infinite loop
                randomIndex = (int)(Math.random() * attachedRooms.size());
                if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) { //makes the move out of stage if the room is not full
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr); //removes character from current room
                    setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//after removing character it gets the info from the current room it is in
                }
                //MakeMove(RoomList);//recursive call to once more, get out of the loop
            }
            else{
                try
                {
                    randomIndex = (int)(Math.random() * attachedRooms.size());//determines through random gen which of the available rooms it wants to go into
                    if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) {//checks through the addCharacterToRoom room function if it returns true
                        RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);//removes character from the room it was in before updating to the new room in its own data
                        setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//sets new values for the room it just jumped into
                    }
                }
                catch (Exception ignored)
                {

                }

            }

        }
    }

    public static class Barry extends Animatronic{
        int currentRoomNum = 1;
        private double CountDownTillMov = 31000000000.0;
        private double LastMoveTime = 31000000000.0;
        int randomIndex;
        float AngryLevel;
        private ArrayList<Integer> attachedRooms = new ArrayList<Integer>();
        private ArrayList<Integer> offLimitsRooms = new ArrayList<Integer>(Arrays.asList(7, 9, 10, 11, 12));
        String characterStr = "Barry";
        boolean attackReady = false;
        boolean jumpScare = false;

        public String getCharacterStr(){//Gets character name, doesn't need setter
            return characterStr;
        }
        public int getCurrentRoomNum(){//Gets current room the animatronic is in
            return currentRoomNum;
        }
        public void setCurrentRoomNum(int newRoomNum){//sets a new room when animatronic moves
            currentRoomNum = newRoomNum;
        }
        public double getCountDownTillMov(){//gives the remaining countdown until an animatronic moves
            return CountDownTillMov;
        }
        public void setCountDownTillMov(){//sets countdown for animatronic as needed
            CountDownTillMov *= AngryLevel;
        }
        public float getAngryLevel(){//returns angry level
            return AngryLevel;
        }
        public boolean getJumpScare(){//returns angry level
            return jumpScare;
        }
        public double getLastMoveTime() { return LastMoveTime; }
        public void setLastMoveTime( double newLastMoveTime ) { LastMoveTime = newLastMoveTime; }
        public void setAngryLevel(float newAngryLevel){//sets angry level
            AngryLevel = newAngryLevel;
        }
        public void setAttackReady(){
            if (attackReady){
                attackReady = false;
            }
            else{
                attackReady = true;
            }
        }
        public void setRoomNumAndAttachedRooms(int roomNum, ArrayList<Integer> List){
            setCurrentRoomNum(roomNum);
            setAttachedRooms(List);
        }

        public boolean getAttackReady(){//sets attack to ready if the animatronic is in the doorway and door is not closed
            return attackReady;
        }

        public void setAttachedRooms(ArrayList<Integer> newAttachedRooms){//sets the animatronic's room list to be the same as the current room
            attachedRooms.clear();
            for(Integer IntTemp2: newAttachedRooms){
                attachedRooms.add(IntTemp2);
            }
            for(Integer IntTemp : offLimitsRooms){ //filters out the rooms the animatronic cannot move to based on their offLimits
                attachedRooms.remove(IntTemp.toString());
            }

        }

        public ArrayList<Integer> getAttachedRooms(){
            return attachedRooms;
        }

        public void MakeMove(ArrayList<Room> RoomList){

            if(attackReady == true){
                if (RoomList.get(currentRoomNum).isDoorClosed() == true)
                {
                    setAttackReady();
                    RoomList.get(2).addCharacterToRoom(characterStr);
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);
                    setRoomNumAndAttachedRooms(RoomList.get(2).getRoomNum(), RoomList.get(2).getAttachedRooms());
                }
                else
                    {
                        jumpScare = true;
                    }
            }
            else if(currentRoomNum == 13 && RoomList.get(currentRoomNum).isDoorClosed() == false){//sets attack to ready state if in office doorway and door isnt close
                setAttackReady();
            }
            else if(currentRoomNum == 1){ //precheck for characters like doug that are already in a room to start out with
                setRoomNumAndAttachedRooms(RoomList.get(1).getRoomNum(), RoomList.get(1).getAttachedRooms()); //sets the attached room set and room number to the second one if they are on stage to jump out of infinite loop
                randomIndex = (int)(Math.random() * attachedRooms.size());
                if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) { //makes the move out of stage if the room is not full
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr); //removes character from current room
                    setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//after removing character it gets the info from the current room it is in
                }
                //MakeMove(RoomList);//recursive call to once more, get out of the loop
            }
            else{
                try
                {
                    randomIndex = (int)(Math.random() * attachedRooms.size());//determines through random gen which of the available rooms it wants to go into
                    if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) {//checks through the addCharacterToRoom room function if it returns true
                        RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);//removes character from the room it was in before updating to the new room in its own data
                        setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//sets new values for the room it just jumped into
                    }
                }
                catch (Exception ignored)
                {

                }

            }

        }
    }

    public static class Rabecca extends Animatronic{
        int currentRoomNum = 1;
        private double CountDownTillMov = 27000000000.0;
        private double LastMoveTime = 27000000000.0;
        int randomIndex;
        float AngryLevel;
        private ArrayList<Integer> attachedRooms = new ArrayList<Integer>();
        private ArrayList<Integer> offLimitsRooms = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 11, 13));
        String characterStr = "Rabecca";
        boolean attackReady = false;
        boolean jumpScare = false;

        public String getCharacterStr(){//Gets character name, doesn't need setter
            return characterStr;
        }
        public int getCurrentRoomNum(){//Gets current room the animatronic is in
            return currentRoomNum;
        }
        public void setCurrentRoomNum(int newRoomNum){//sets a new room when animatronic moves
            currentRoomNum = newRoomNum;
        }
        public double getCountDownTillMov(){//gives the remaining countdown until an animatronic moves
            return CountDownTillMov;
        }
        public void setCountDownTillMov(){//sets countdown for animatronic as needed
            CountDownTillMov *= AngryLevel;
        }
        public float getAngryLevel(){//returns angry level
            return AngryLevel;
        }
        public boolean getJumpScare(){//returns angry level
            return jumpScare;
        }
        public double getLastMoveTime() { return LastMoveTime; }
        public void setLastMoveTime( double newLastMoveTime ) { LastMoveTime = newLastMoveTime; }
        public void setAngryLevel(float newAngryLevel){//sets angry level
            AngryLevel = newAngryLevel;
        }
        public void setAttackReady(){
            if (attackReady){
                attackReady = false;
            }
            else{
                attackReady = true;
            }
        }
        public void setRoomNumAndAttachedRooms(int roomNum, ArrayList<Integer> List){
            setCurrentRoomNum(roomNum);
            setAttachedRooms(List);
        }

        public boolean getAttackReady(){//sets attack to ready if the animatronic is in the doorway and door is not closed
            return attackReady;
        }

        public void setAttachedRooms(ArrayList<Integer> newAttachedRooms){//sets the animatronic's room list to be the same as the current room
            attachedRooms.clear();
            for(Integer IntTemp2: newAttachedRooms){
                attachedRooms.add(IntTemp2);
            }
            for(Integer IntTemp : offLimitsRooms){ //filters out the rooms the animatronic cannot move to based on their offLimits
                attachedRooms.remove(IntTemp.toString());
            }

        }

        public ArrayList<Integer> getAttachedRooms(){
            return attachedRooms;
        }

        public void MakeMove(ArrayList<Room> RoomList){

            if(attackReady == true){
                if (RoomList.get(currentRoomNum).isVentClosed() == true)
                {
                    setAttackReady();
                    RoomList.get(2).addCharacterToRoom(characterStr);
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);
                    setRoomNumAndAttachedRooms(RoomList.get(2).getRoomNum(), RoomList.get(2).getAttachedRooms());
                }
                else
                    {
                        jumpScare = true;
                    }
            }
            else if(currentRoomNum == 12 && RoomList.get(currentRoomNum).isVentClosed() == false){//sets attack to ready state if in office doorway and door isnt close
                setAttackReady();
            }
            else if(currentRoomNum == 1){ //precheck for characters like doug that are already in a room to start out with
                setRoomNumAndAttachedRooms(RoomList.get(1).getRoomNum(), RoomList.get(1).getAttachedRooms()); //sets the attached room set and room number to the second one if they are on stage to jump out of infinite loop
                randomIndex = (int)(Math.random() * attachedRooms.size());
                if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) { //makes the move out of stage if the room is not full
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr); //removes character from current room
                    setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//after removing character it gets the info from the current room it is in
                }
                //MakeMove(RoomList);//recursive call to once more, get out of the loop
            }
            else{
                try
                {
                    randomIndex = (int)(Math.random() * attachedRooms.size());//determines through random gen which of the available rooms it wants to go into
                    if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) {//checks through the addCharacterToRoom room function if it returns true
                        RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);//removes character from the room it was in before updating to the new room in its own data
                        setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//sets new values for the room it just jumped into
                    }
                }
                catch (Exception ignored)
                {

                }

            }

        }
    }

    public static class Framework extends Animatronic{
        int currentRoomNum = 11;
        private double CountDownTillMov = 17000000000.0;
        private double LastMoveTime = 17000000000.0;
        int randomIndex;
        float AngryLevel;
        private ArrayList<Integer> attachedRooms = new ArrayList<Integer>();
        private ArrayList<Integer> offLimitsRooms = new ArrayList<Integer>(Arrays.asList(1, 2, 6, 7));
        String characterStr = "Framework";
        boolean attackReady = false;
        boolean jumpScare = false;

        public String getCharacterStr(){//Gets character name, doesn't need setter
            return characterStr;
        }
        public int getCurrentRoomNum(){//Gets current room the animatronic is in
            return currentRoomNum;
        }
        public void setCurrentRoomNum(int newRoomNum){//sets a new room when animatronic moves
            currentRoomNum = newRoomNum;
        }
        public double getCountDownTillMov(){//gives the remaining countdown until an animatronic moves
            return CountDownTillMov;
        }
        public void setCountDownTillMov(){//sets countdown for animatronic as needed
            CountDownTillMov *= AngryLevel;
        }
        public float getAngryLevel(){//returns angry level
            return AngryLevel;
        }
        public boolean getJumpScare(){//returns angry level
            return jumpScare;
        }
        public double getLastMoveTime() { return LastMoveTime; }
        public void setLastMoveTime( double newLastMoveTime ) { LastMoveTime = newLastMoveTime; }
        public void setAngryLevel(float newAngryLevel){//sets angry level
            AngryLevel = newAngryLevel;
        }

        public void setAttackReady(){
            if (attackReady){
                attackReady = false;
            }
            else{
                attackReady = true;
            }
        }
        public void setRoomNumAndAttachedRooms(int roomNum, ArrayList<Integer> List){
            setCurrentRoomNum(roomNum);
            setAttachedRooms(List);
        }

        public boolean getAttackReady(){//sets attack to ready if the animatronic is in the doorway and door is not closed
            return attackReady;
        }

        public void setAttachedRooms(ArrayList<Integer> newAttachedRooms){//sets the animatronic's room list to be the same as the current room
            attachedRooms.clear();
            for(Integer IntTemp2: newAttachedRooms){
                attachedRooms.add(IntTemp2);
            }
            for(Integer IntTemp : offLimitsRooms){ //filters out the rooms the animatronic cannot move to based on their offLimits
                attachedRooms.remove(IntTemp.toString());
            }

        }

        public ArrayList<Integer> getAttachedRooms(){
            return attachedRooms;
        }

        public void MakeMove(ArrayList<Room> RoomList){

            if(attackReady == true){
                if (RoomList.get(currentRoomNum).isVentClosed() == true || RoomList.get(currentRoomNum).isDoorClosed() == true)
                {
                    setAttackReady();
                    RoomList.get(4).addCharacterToRoom(characterStr);
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);
                    setRoomNumAndAttachedRooms(RoomList.get(4).getRoomNum(), RoomList.get(4).getAttachedRooms());
                }
                else
                    {
                        jumpScare = true;
                    }
            }
            else if((currentRoomNum == 12 || currentRoomNum == 13) && (RoomList.get(currentRoomNum).isVentClosed() == false || RoomList.get(currentRoomNum).isDoorClosed() == false)){//sets attack to ready state if in office doorway and door isnt close
                setAttackReady();
            }
            else if(currentRoomNum == 11){ //precheck for characters like doug that are already in a room to start out with
                setRoomNumAndAttachedRooms(RoomList.get(11).getRoomNum(), RoomList.get(11).getAttachedRooms()); //sets the attached room set and room number to the second one if they are on stage to jump out of infinite loop
                randomIndex = (int)(Math.random() * attachedRooms.size());
                if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) { //makes the move out of stage if the room is not full
                    RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr); //removes character from current room
                    setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//after removing character it gets the info from the current room it is in
                }
                //MakeMove(RoomList);//recursive call to once more, get out of the loop
            }
            else{
                try
                {
                    randomIndex = (int)(Math.random() * attachedRooms.size());//determines through random gen which of the available rooms it wants to go into
                    if(RoomList.get(attachedRooms.get(randomIndex)).addCharacterToRoom(characterStr) == true) {//checks through the addCharacterToRoom room function if it returns true
                        RoomList.get(currentRoomNum).removeCharacterFromRoom(characterStr);//removes character from the room it was in before updating to the new room in its own data
                        setRoomNumAndAttachedRooms(RoomList.get(attachedRooms.get(randomIndex)).getRoomNum(), RoomList.get(attachedRooms.get(randomIndex)).getAttachedRooms());//sets new values for the room it just jumped into
                    }
                }
                catch (Exception ignored)
                {

                }

            }

        }
    }
}

