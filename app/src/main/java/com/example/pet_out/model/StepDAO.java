package com.example.pet_out.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.pet_out.database.DataBaseHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class StepDAO {

    public static final String NAME= "tb_steps", ID = "id", TITLE = "title", SUB_TITLE= "sub_title", RAW_RES="raw_resource";
    private static final String TAG_STEP_DAO = "_StepDao_";

    public static String getSelectSQL(){
        return MessageFormat.format("SELECT {0},{1},{2},{3} FROM {4}",ID,TITLE,SUB_TITLE,RAW_RES,NAME);
    }
    public static String[] getArray(){
        return new String[] {ID, TITLE, SUB_TITLE, RAW_RES};
    }

    public static String getColumnsSQL(){
        return MessageFormat.format("{0} INTEGER PRIMARY KEY AUTOINCREMENT, {1} TEXT NOT NULL, {2} TEXT NULL, {3} INTEGER NOT NULL", getArray());
    }

    public static long insert(Step step, Context context){
        return new DataBaseHelper(context).insert(NAME, getContentValues(step, false));
    }
    public static long insertwithId(Step step, Context context) {
        return new DataBaseHelper(context).insert(NAME, getContentValues(step, true));
    }
    public static String select (Context context){
    DataBaseHelper helper = new DataBaseHelper(context);
    return helper.select(getSelectSQL(),new String[]{}).toString();

    }
    public static boolean update(Step step, Context context){// int old_id
        return new DataBaseHelper(context).update(NAME,getContentValues(step, false),MessageFormat.format("{0} = {1}",ID, step.getId())) > 0;
    }
    public static boolean delete(Step step, Context context){
        return  new DataBaseHelper(context).delete(NAME, String.format("%s = %s", ID, step.getId())) > 0;
    }

    public static List<Step> getList(Context context){
        return new Gson().fromJson(
                new DataBaseHelper(context).select(getSelectSQL(), null).toString(),
                new TypeToken<ArrayList<Step>>(){}.getType()
        );
    }

    public static ContentValues getContentValues(Step step, boolean is_auto_increment){// boolean is_auto_increment
        ContentValues values = new ContentValues();
        //update || delete => ID
        if(is_auto_increment)
            values.put(ID, step.getId());
        values.put(TITLE, step.getTitle());
        values.put(SUB_TITLE, step.getSub_title());
        values.put(RAW_RES, step.getRaw_resource());
        return values;
    }

}