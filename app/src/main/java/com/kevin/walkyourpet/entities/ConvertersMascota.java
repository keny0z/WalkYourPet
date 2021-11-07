package com.kevin.walkyourpet.entities;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ConvertersMascota {
    @TypeConverter
    public static ArrayList<Mascota> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Mascota>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Mascota> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
