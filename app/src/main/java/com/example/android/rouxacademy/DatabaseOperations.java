package com.example.android.rouxacademy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by louna on 16/11/2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public  static final int database_version =1;


    public String CREATE_QUERY = "INSERT INTO Hospitals SELECT   '1' AS 'HOSPITAL_ID'," +

            " 'مستشفى النور ' AS 'HOSPITAL_Name', 'uae' as 'HOSPITAL_COUNTRY', '24.246489' as 'HOSPITAL_LATITUDE' ," +
            " '55.731008' as 'HOSPITAL_LONGITUDE','أبو ظبي_العين _شارع خليفة_قرب سوبرماركت شويترام' as 'HOSPITAL_ADDRESS','03 7667666' as 'HOSPITAL_phone' UNION ALL SELECT '2', 'مستشفى عين الخليج','uae','24.254573','55.754972', 'أبو ظبي_العين _ منطقة الجيمي،خلف الجيمي مول'      " +
            ",'03 7133333' UNION ALL SELECT '3', 'مستشفي العين'," +
            "'uae','24.256774','55.749726','أبو ظبي_العين _الجيمي_شارع شبخوط ابن سلطان'" +
            ",'03 7022000'UNION ALL SELECT '4', 'المستشفى السعودي البريطاني '," +
            "'ksa','24.705995', '46.674350','الرياض – طريق الملك فهد – مقابل برج العنود'" +
            ",'114636666' UNION ALL SELECT '5', 'المستشفى الوطني','uae','24.261039','55.755176','الرياض_الزاهرة_طريق عمر بن عبد العزيز'"+
            ",'87878'";



    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        String query;
        query = "CREATE TABLE Hospitals ( HOSPITAL_ID INTEGER PRIMARY " +
                " KEY,HOSPITAL_NAME TEXT,HOSPITAL_COUNTRY TEXT,HOSPITAL_LATITUDE DOUBLE,HOSPITAL_LONGITUDE DOUBLE,HOSPITAL_ADDRESS TEXT,HOSPITAL_PHONE TEXT)";


        sdb.execSQL(query);

        Log.d("Database operations", "table //////////////////////////////////////////////////******//////created");

        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "adddddddddddddding data");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabaseOperations dop,int id ,String name ,String cou ,double lat,double lon)
    {

        SQLiteDatabase SQ= dop.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(TableData.TableInfo.HOSPITAL_ID,id);
        cv.put(TableData.TableInfo.HOSPITAL_Name,name);
        cv.put(TableData.TableInfo.HOSPITAL_COUNTRY,cou);
        cv.put(TableData.TableInfo.HOSPITAL_LATITUDE,lat);
        cv.put(TableData.TableInfo.HOSPITAL_LONGITUDE,lon);


        SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "one raw //////////////////////////////////inserted");}

               public Cursor get_info (DatabaseOperations dop){
                   SQLiteDatabase SQ= dop.getReadableDatabase();
                   String[] col ={TableData.TableInfo.HOSPITAL_ID, TableData.TableInfo.HOSPITAL_Name, TableData.TableInfo.HOSPITAL_COUNTRY, TableData.TableInfo.HOSPITAL_LATITUDE, TableData.TableInfo.HOSPITAL_LONGITUDE, TableData.TableInfo.HOSPITAL_ADDRESS, TableData.TableInfo.HOSPITAL_PHONE};
                   Cursor CR =SQ.query(TableData.TableInfo.TABLE_NAME,col,null,null,null,null,null);
                   return CR;


               }
    public float getDistance(double lat1, double lon1, double lat2, double lon2) {
        android.location.Location homeLocation = new android.location.Location("");
        homeLocation .setLatitude(lat1);
        homeLocation .setLongitude(lon1);
        android.location.Location targetLocation = new android.location.Location("");
        targetLocation .setLatitude(lat2);
        targetLocation .setLongitude(lon2);
        float distanceInMeters =  targetLocation.distanceTo(homeLocation);
        return distanceInMeters ;
    }
}
