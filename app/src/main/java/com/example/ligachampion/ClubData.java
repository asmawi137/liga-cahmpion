package com.example.ligachampion;

import java.util.ArrayList;

public class ClubData {
    private static String [] clubNames = {
            "Manchester United",
            "Manchester City",
            "Arsenal",
            "Chelsea",
            "Liverpool"
    };
    private static String [] clublinks = {
            "https://www.youtube.com/watch?v=RxR--klDbTI",
            "https://www.youtube.com/watch?v=8jlkMNrWsDc",
            "https://www.youtube.com/watch?v=FJqqneQMuEM",
            "https://www.youtube.com/watch?v=tPuen01EVVs",
            "https://www.youtube.com/watch?v=SkIk7txs1aY"
    };

    private static String [] clubDetails ={
            "Manchester United adalah klub terbersar di inggris",
            "Manchester City dikenal dengan Man City atau The Citizent",
            "Arsenal sering disebut The Gunners",
            "Chelsea klub yang bermarkas di Fulham",
            "Liverpool sering disebut dengan The Reds"
    };

    private static int[] clubImages = {
            R.drawable.manutd,
            R.drawable.mancity,
            R.drawable.arsenal,
            R.drawable.chelsea,
            R.drawable.liverpool
    };

    static ArrayList<Club> getLisData(){
        ArrayList<Club> list = new ArrayList<>();
        for (int position = 0; position <clubNames.length; position++) {
            Club club = new Club();
            club.setName(clubNames[position]);
            club.setDetail(clubDetails[position]);
            club.setPhoto(clubImages[position]);
            club.setLink(clublinks[position]);
            list.add(club);
        }
        return list;
    }

}
