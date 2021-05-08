package core;

import java.util.ArrayList;
import java.util.Arrays;

//Devin Kaltenbaugh and Martin Bastecki

public class Room { //topmost archetype for rooms, used as a basis and contains everything necessary to make a new room
    private boolean DoorClosed, VentClosed, Updated, roomLit;
    ArrayList<Integer> attachedRooms;
    ArrayList<String> CharInRoom;
    private int roomCapacity, numCharInRoom, roomNumber;
    private String roomName;


    public boolean isRoomFull(){
        if(roomCapacity == numCharInRoom){
            return true;
        }
        else{
            return false;
        }
    }
    //Adds character to room list and increments count of the characters in room
    public boolean addCharacterToRoom(String CharString){
        if(!isRoomFull()){
            CharInRoom.add(CharString);
            numCharInRoom++;
            Updated = true;
            return true;
        }
        else{
            return false;
        }
    }
    //Removes character from current index arraylist and lowers the numCharInRoom
    public void removeCharacterFromRoom(String CharString){
        CharInRoom.remove(CharString);
        numCharInRoom--;
        Updated = true;
    }

    public void setUpdated(){ Updated = false; }

    //Gets the status of DoorClosed to see if the door is closed
    public boolean isDoorClosed(){
        if(DoorClosed == true){
            return true;
        }
        else{
            return false;
        }
    }
    //Checks if vent is closed
    public boolean isVentClosed(){
        if(VentClosed == true){
            return true;
        }
        else{
            return false;
        }
    }
    //Setters for DoorClosed and VentClosed
    public void closeDoor(){
        DoorClosed = true;
    }
    public void openDoor(){
        DoorClosed = false;
    }
    public void closeVent(){
        VentClosed = true;
    }
    public void openVent(){
        VentClosed = false;
    }
    public boolean isRoomLit() { return roomLit; }
    public void setRoomLit() {
        if (roomLit)
        {
            roomLit = false;
        }
        else
        {
            roomLit = true;
        }

    }

    //Returns arraylist of attachedrooms
    public ArrayList<Integer> getAttachedRooms() {
        return attachedRooms;
    }
    public ArrayList<String> getCharInRoom() {
        return CharInRoom;
    }
    //returns room name
    public String getRoomName(){
        return roomName;
    }
    //returns room number
    public Integer getRoomNum(){
        return roomNumber;
    }
//======================================================================================================================
//creation of separate room classes
    public static class Stage extends Room{
        String roomName = "Stage";
        int roomNumber = 1;
        int roomCapacity = 3;
        int numCharInRoom = 3;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>(Arrays.asList("Doug","Barry","Rabecca"));
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(2));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
         public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

    public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
        return CharInRoom;
    }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }

    public static class ShowRoom extends Room{
        String roomName = "ShowRoom";
        int roomNumber = 2;
        int roomCapacity = 3;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(3,5));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class Hallway1 extends Room{
        String roomName = "Hallway1";
        int roomNumber = 3;
        int roomCapacity = 1;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(2,4,8,8));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class PartyRoom1 extends Room{
        String roomName = "PartyRoom1";
        int roomNumber = 4;
        int roomCapacity = 3;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(3,9,9));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class Hallway2 extends Room{
        String roomName = "Hallway2";
        int roomNumber = 5;
        int roomCapacity = 1;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(2,6,8,8));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class PartyRoom2 extends Room{
        String roomName = "PartyRoom2";
        int roomNumber = 6;
        int roomCapacity = 3;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(5,5,7));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class Kitchen extends Room{
        String roomName = "Kitchen";
        int roomNumber = 7;
        int roomCapacity = 3;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(6));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class OutsideOfficeDoor extends Room{
        String roomName = "OutsideOfficeDoor";
        int roomNumber = 8;
        int roomCapacity = 1;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(3,5,13,13));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class PartsRoom extends Room{
        String roomName = "PartsRoom";
        int roomNumber = 9;
        int roomCapacity = 3;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(4,10,10));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class InsideVents extends Room{
        String roomName = "InsideVents";
        int roomNumber = 10;
        int roomCapacity = 1;
        int numCharInRoom = 0;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(9,12,12));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class EmergencyShelter extends Room{
        String roomName = "EmergencyShelter";
        int roomNumber = 11;
        int roomCapacity = 1;
        int numCharInRoom = 1;
        boolean Updated = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(4));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
    }
    public static class OfficeDoor extends Room{
        String roomName = "OfficeDoor";
        int roomNumber = 13;
        int roomCapacity = 1;
        int numCharInRoom = 0;
        boolean DoorClosed = false;
        boolean Updated = false;
        boolean roomLit = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(8));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
        public boolean isDoorClosed(){
            if(DoorClosed == true){
                return true;
            }
            else{
                return false;
            }
        }
        public void closeDoor(){
            DoorClosed = true;
        }
        public void openDoor(){
            DoorClosed = false;
        }
        public boolean isRoomLit() { return roomLit; }
        public void setRoomLit() {
            if (roomLit)
            {
                roomLit = false;
            }
            else
            {
                roomLit = true;
            }

        }
    }
    public static class OfficeVent extends Room{
        String roomName = "OfficeVent";
        int roomNumber = 12;
        int roomCapacity = 1;
        int numCharInRoom = 0;
        boolean VentClosed;
        boolean Updated = false;
        boolean roomLit = false;
        ArrayList<String> CharInRoom = new ArrayList<String>();
        ArrayList<Integer> attachedRooms = new ArrayList<Integer>(Arrays.asList(10));
        public boolean isRoomFull(){
            if(roomCapacity == numCharInRoom){
                return true;
            }
            else{
                return false;
            }
        }
        //Adds character to room list and increments count of the characters in room
        public boolean addCharacterToRoom(String CharString){
            if(!isRoomFull()){
                CharInRoom.add(CharString);
                numCharInRoom++;
                Updated = true;
                return true;
            }
            else{
                return false;
            }
        }
        //Removes character from current index arraylist and lowers the numCharInRoom
        public void removeCharacterFromRoom(String CharString){
            CharInRoom.remove(CharString);
            numCharInRoom--;
            Updated = true;
        }

        public void setUpdated(){ Updated = false; }
        public ArrayList<Integer> getAttachedRooms() {
            return attachedRooms;
        }
        public ArrayList<String> getCharInRoom() {
            return CharInRoom;
        }
        public String getRoomName(){
            return roomName;
        }
        public Integer getRoomNum() {
            return roomNumber;
        }
        public boolean isVentClosed(){
            if(VentClosed == true){
                return true;
            }
            else{
                return false;
            }
        }
        public void closeVent(){
            VentClosed = true;
        }
        public void openVent(){
            VentClosed = false;
        }
        public boolean isRoomLit() { return roomLit; }
        public void setRoomLit() {
            if (roomLit)
            {
                roomLit = false;
            }
            else
                {
                    roomLit = true;
                }

        }
    }


}

