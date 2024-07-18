package com.example.android.rouxacademy;

import android.provider.BaseColumns;

/**
 * Created by louna on 16/11/2015.
 */
public class TableData {

public TableData(){}

    public  static abstract  class TableInfo implements BaseColumns
    {

        public  static final String HOSPITAL_ID ="HOSPITAL_ID";
        public  static final String HOSPITAL_Name ="HOSPITAL_Name";
        public  static final String HOSPITAL_LONGITUDE ="HOSPITAL_LONGITUDE";
        public  static final String HOSPITAL_LATITUDE ="HOSPITAL_LATITUDE";
        public  static final String HOSPITAL_COUNTRY ="HOSPITAL_COUNTRY";
        public  static final String HOSPITAL_ADDRESS ="HOSPITAL_ADDRESS";
        public  static final String HOSPITAL_PHONE ="HOSPITAL_PHONE";
        public  static final String DATABASE_NAME ="database_name";
        public  static final String TABLE_NAME ="hospitals";





    }



}
