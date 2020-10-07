package com.github.jp.erudo.elts.utils;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class MathUtils {

    public static String getCoordinatetoString(Location loc) {
        String[] coordinates = {Double.toString(loc.getX()), Double.toString(loc.getY()), Double.toString(loc.getZ())};

        String result;
        result = String.join(",",coordinates);

        return result;
    }

    public static List<Double> getCoordinatefromString(String s) {
        List<Double> coordinates = new ArrayList<>();

        String[] s_list = s.split(" ");

        for (String str : s_list) {
            Double d = Double.valueOf(s);
            coordinates.add(d);

        }

        return coordinates;
    }
}
