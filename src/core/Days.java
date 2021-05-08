package core;

import java.util.ArrayList;
import java.util.Arrays;

//Devin Kaltenbaugh and Martin Bastecki

public class Days {


    //For Days 1-3 for rooms, we have separate instantiating functions that creates the room objects and makes an arraylist
    //The main difference between each of them is that 2 and 3 add more bias towards going towards the player
    //This is achieved by adding more of one room number to their attached rooms list, thus creating more chance to roll it
    //Day Zero is a cheat day that is harmless to the player
    static public ArrayList<Room> DayZeroRooms()
    {
        Room dummyRoom = new Room();
        Room.Stage Stage = new Room.Stage();
        Room.ShowRoom ShowRoom = new Room.ShowRoom();
        Room.Hallway1 Hallway1 = new Room.Hallway1();
        Room.PartyRoom1 PartyRoom1 = new Room.PartyRoom1();
        Room.Hallway2 Hallway2 = new Room.Hallway2();
        Room.PartyRoom2 PartyRoom2 = new Room.PartyRoom2();
        Room.Kitchen Kitchen = new Room.Kitchen();
        Room.OutsideOfficeDoor OutsideOfficeDoor = new Room.OutsideOfficeDoor();
        Room.PartsRoom PartsRoom = new Room.PartsRoom();
        Room.InsideVents InsideVents = new Room.InsideVents();
        Room.EmergencyShelter EmergencyShelter = new Room.EmergencyShelter();
        Room.OfficeVent OfficeVent = new Room.OfficeVent();
        Room.OfficeDoor OfficeDoor = new Room.OfficeDoor();
        for(int i = 0; i<2; i++){
            OutsideOfficeDoor.attachedRooms.remove(Integer.valueOf(13));
            InsideVents.attachedRooms.remove(Integer.valueOf(12));}//quickly removes any danger to the player
        ArrayList<Room> RoomList = new ArrayList<Room>(Arrays.asList(dummyRoom,Stage,ShowRoom,Hallway1,PartyRoom1,Hallway2,PartyRoom2,Kitchen,OutsideOfficeDoor,PartsRoom,InsideVents,EmergencyShelter,OfficeVent,OfficeDoor));
        return RoomList;
    }
    static public ArrayList<Room> DayOneRooms()
    {
        Room dummyRoom = new Room();
        Room.Stage Stage = new Room.Stage();
        Room.ShowRoom ShowRoom = new Room.ShowRoom();
        Room.Hallway1 Hallway1 = new Room.Hallway1();
        Room.PartyRoom1 PartyRoom1 = new Room.PartyRoom1();
        Room.Hallway2 Hallway2 = new Room.Hallway2();
        Room.PartyRoom2 PartyRoom2 = new Room.PartyRoom2();
        Room.Kitchen Kitchen = new Room.Kitchen();
        Room.OutsideOfficeDoor OutsideOfficeDoor = new Room.OutsideOfficeDoor();
        Room.PartsRoom PartsRoom = new Room.PartsRoom();
        Room.InsideVents InsideVents = new Room.InsideVents();
        Room.EmergencyShelter EmergencyShelter = new Room.EmergencyShelter();
        Room.OfficeVent OfficeVent = new Room.OfficeVent();
        Room.OfficeDoor OfficeDoor = new Room.OfficeDoor();

        ArrayList<Room> RoomList = new ArrayList<Room>(Arrays.asList(dummyRoom,Stage,ShowRoom,Hallway1,PartyRoom1,Hallway2,PartyRoom2,Kitchen,OutsideOfficeDoor,PartsRoom,InsideVents,EmergencyShelter,OfficeVent,OfficeDoor));
        return RoomList;
    }
    static public ArrayList<Room> DayTwoRooms()
    {
        Room dummyRoom = new Room();
        Room.Stage Stage = new Room.Stage();
        Room.ShowRoom ShowRoom = new Room.ShowRoom();
        Room.Hallway1 Hallway1 = new Room.Hallway1();
        Room.PartyRoom1 PartyRoom1 = new Room.PartyRoom1();
        Room.Hallway2 Hallway2 = new Room.Hallway2();
        Room.PartyRoom2 PartyRoom2 = new Room.PartyRoom2();
        Room.Kitchen Kitchen = new Room.Kitchen();
        Room.OutsideOfficeDoor OutsideOfficeDoor = new Room.OutsideOfficeDoor();
        Room.PartsRoom PartsRoom = new Room.PartsRoom();
        Room.InsideVents InsideVents = new Room.InsideVents();
        Room.EmergencyShelter EmergencyShelter = new Room.EmergencyShelter();
        Room.OfficeVent OfficeVent = new Room.OfficeVent();
        Room.OfficeDoor OfficeDoor = new Room.OfficeDoor();
        Hallway1.attachedRooms.add(8);
        PartyRoom1.attachedRooms.add(9);
        Hallway2.attachedRooms.add(8);
        PartyRoom2.attachedRooms.add(5);
        OutsideOfficeDoor.attachedRooms.add(13);
        PartsRoom.attachedRooms.add(10);
        InsideVents.attachedRooms.add(12);



        ArrayList<Room> RoomList = new ArrayList<Room>(Arrays.asList(dummyRoom,Stage,ShowRoom,Hallway1,PartyRoom1,Hallway2,PartyRoom2,Kitchen,OutsideOfficeDoor,PartsRoom,InsideVents,EmergencyShelter,OfficeVent,OfficeDoor));
        return RoomList;
    }
    static public ArrayList<Room> DayThreeRooms()
    {
        Room dummyRoom = new Room();
        Room.Stage Stage = new Room.Stage();
        Room.ShowRoom ShowRoom = new Room.ShowRoom();
        Room.Hallway1 Hallway1 = new Room.Hallway1();
        Room.PartyRoom1 PartyRoom1 = new Room.PartyRoom1();
        Room.Hallway2 Hallway2 = new Room.Hallway2();
        Room.PartyRoom2 PartyRoom2 = new Room.PartyRoom2();
        Room.Kitchen Kitchen = new Room.Kitchen();
        Room.OutsideOfficeDoor OutsideOfficeDoor = new Room.OutsideOfficeDoor();
        Room.PartsRoom PartsRoom = new Room.PartsRoom();
        Room.InsideVents InsideVents = new Room.InsideVents();
        Room.EmergencyShelter EmergencyShelter = new Room.EmergencyShelter();
        Room.OfficeVent OfficeVent = new Room.OfficeVent();
        Room.OfficeDoor OfficeDoor = new Room.OfficeDoor();
        Hallway1.attachedRooms.add(8);
        PartyRoom1.attachedRooms.add(9);
        Hallway2.attachedRooms.add(8);
        PartyRoom2.attachedRooms.add(5);
        OutsideOfficeDoor.attachedRooms.add(13);
        PartsRoom.attachedRooms.add(10);
        InsideVents.attachedRooms.add(12);
        Hallway1.attachedRooms.add(8);
        PartyRoom1.attachedRooms.add(9);
        Hallway2.attachedRooms.add(8);
        PartyRoom2.attachedRooms.add(5);
        OutsideOfficeDoor.attachedRooms.add(13);
        PartsRoom.attachedRooms.add(10);
        InsideVents.attachedRooms.add(12);

        ArrayList<Room> RoomList = new ArrayList<Room>(Arrays.asList(dummyRoom,Stage,ShowRoom,Hallway1,PartyRoom1,Hallway2,PartyRoom2,Kitchen,OutsideOfficeDoor,PartsRoom,InsideVents,EmergencyShelter,OfficeVent,OfficeDoor));
        return RoomList;
    }

//Functions to create the animatronics per day, this way we can introduce different animatronics per day
//additionally can set the angry level to be part of the day for difficulty increase
    static public ArrayList<Animatronic> DayZeroAnim()
    {
        Animatronic.Doug Doug = new Animatronic.Doug();
        Animatronic.Barry Barry = new Animatronic.Barry();
        Animatronic.Rabecca Rabecca = new Animatronic.Rabecca();
        Animatronic.Framework Framework = new Animatronic.Framework();
        Doug.setAngryLevel(1);
        Doug.setCountDownTillMov();
        Barry.setAngryLevel(1);
        Barry.setCountDownTillMov();
        Rabecca.setAngryLevel(1);
        Rabecca.setCountDownTillMov();
        Framework.setAngryLevel(1);
        Framework.setCountDownTillMov();
        ArrayList<Animatronic> AnimList = new ArrayList<Animatronic>(Arrays.asList(Doug, Barry, Rabecca, Framework));
        return AnimList;
    }
    static public ArrayList<Animatronic> DayOneAnim()
    {
        Animatronic.Doug Doug = new Animatronic.Doug();
        Animatronic.Rabecca Rabecca = new Animatronic.Rabecca();
        Doug.setAngryLevel(1);
        Doug.setCountDownTillMov();
        Rabecca.setAngryLevel(1);
        Rabecca.setCountDownTillMov();
        ArrayList<Animatronic> AnimList = new ArrayList<Animatronic>(Arrays.asList(Doug, Rabecca));
        return AnimList;
    }
    static public ArrayList<Animatronic> DayTwoAnim()
    {
        Animatronic.Doug Doug = new Animatronic.Doug();
        Animatronic.Barry Barry = new Animatronic.Barry();
        Animatronic.Rabecca Rabecca = new Animatronic.Rabecca();
        Doug.setAngryLevel((float) .9);
        Doug.setCountDownTillMov();
        Barry.setAngryLevel((float) .9);
        Barry.setCountDownTillMov();
        Rabecca.setAngryLevel((float) .9);
        Rabecca.setCountDownTillMov();
        ArrayList<Animatronic> AnimList = new ArrayList<Animatronic>(Arrays.asList(Doug, Barry, Rabecca));
        return AnimList;
    }
    static public ArrayList<Animatronic> DayThreeAnim()
    {
        Animatronic.Doug Doug = new Animatronic.Doug();
        Animatronic.Barry Barry = new Animatronic.Barry();
        Animatronic.Rabecca Rabecca = new Animatronic.Rabecca();
        Animatronic.Framework Framework = new Animatronic.Framework();
        Doug.setAngryLevel((float) .8);
        Doug.setCountDownTillMov();
        Barry.setAngryLevel((float) .8);
        Barry.setCountDownTillMov();
        Rabecca.setAngryLevel((float) .8);
        Rabecca.setCountDownTillMov();
        Framework.setAngryLevel((float) .8);
        Framework.setCountDownTillMov();
        ArrayList<Animatronic> AnimList = new ArrayList<Animatronic>(Arrays.asList(Doug, Barry, Rabecca, Framework));
        return AnimList;
    }

    //function that is used to clear the current arraylists created by the day functions
    //aka garbage collection
    static public void ClearDay(ArrayList<Room> RoomList, ArrayList<Animatronic> AnimList)
    {
        for (Room room : RoomList)
        {
            room = null;
        }

        for (Animatronic animatronic : AnimList)
        {
            animatronic = null;
        }

        RoomList = null;
        AnimList = null;
    }

}
