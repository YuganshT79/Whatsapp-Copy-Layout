package com.yuganshtyagi.whatsapp_copy;

import java.util.ArrayList;

public final class Utils {

    public static ArrayList<Integer> getAvengerImages() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(R.drawable.iron_man);
        arrayList.add(R.drawable.doctor_strange);
        arrayList.add(R.drawable.spider_man);
        arrayList.add(R.drawable.thor);
        arrayList.add(R.drawable.drax);
        arrayList.add(R.drawable.black_widow);
        arrayList.add(R.drawable.hawkeye);
        arrayList.add(R.drawable.black_panther);

        return arrayList;
    }

    public static ArrayList<String> getAvengerNames() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Iron Man");
        arrayList.add("Doctor Strange");
        arrayList.add("Spider Man");
        arrayList.add("Thor");
        arrayList.add("Drax");
        arrayList.add("Black Widow");
        arrayList.add("Hawkeye");
        arrayList.add("Black Panther");
        return arrayList;
    }

    public static ArrayList<String> getAvengerTexts() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Hey, can you tell Pepper I will be late, I am in space so no network");
        arrayList.add("Need to protect the Time Stone");
        arrayList.add("I don't wanna go! T_T");
        arrayList.add("I will kill Thanos for what he did to Loki");
        arrayList.add("You can't see me, I am invisible");
        arrayList.add("You like my new hairstyle? ;)");
        arrayList.add("I retire for what, like 5 mins and it all goes to ...");
        arrayList.add("WAKANDA FOREVER!");

        return arrayList;
    }

    public static ArrayList<String> getGroupNames(){
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Let's defeat Thanos");
        arrayList.add("The Shawrma gang");
        arrayList.add("S.H.I.E.L.D");
        arrayList.add("Daredevils");
        arrayList.add("Iron man fan club");
        arrayList.add("Deadpool's Team");
        arrayList.add("Bring Hulk back!");
        arrayList.add("The Black order");

        return arrayList;
    }

    public static ArrayList<Integer> getGroupIcons(){
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(R.drawable.defeat_thanos);
        arrayList.add(R.drawable.shwarma);
        arrayList.add(R.drawable.shield);
        arrayList.add(R.drawable.daredevil);
        arrayList.add(R.drawable.iron_man_fan);
        arrayList.add(R.drawable.deadpool_tem);
        arrayList.add(R.drawable.hulk);
        arrayList.add(R.drawable.black_order);

        return arrayList;
    }
}
