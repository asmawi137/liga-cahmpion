package com.example.ligachampion;

import java.util.ArrayList;

public class ClubData {
    private static String [] clubName = {
            "Manchester United",
            "Manchester City",
            "Arsenal",
            "Chelsea",
            "Liverpool",
    };

    private static String [] clubDetail ={
            "Manchester United adalah klub terbersar di inggris",
            "Manchester City dikenal dengan Man City atau The Citizent",
            "Arsenal sering disebut The Gunners",
            "Chelsea klub yang bermarkas di Fulham",
            "Liverpool sering disebut dengan The Reds",
    };

    private static int[] clubImage = {
            R.drawable.manutd,
            R.drawable.mancity,
            R.drawable.arsenal,
            R.drawable.celsea,
            R.drawable.liverpool,
    };

    static ArrayList<Club> getlisData(){
        ArrayList<Club> list = new ArrayList<>();
        for (int position = 0; position <clubName.length; position) {
            Club club = new Club();
            club.getName(clubName[position]);
            club. getDetail(clubDetail[position]);
            club.getPhoto(clubImage[position]);
            list.add(club);
        }
        return list;
    }

}
