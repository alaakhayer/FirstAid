package com.example.android.rouxacademy;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Location extends ActionBarActivity {

    Button btnShowLocation;
    Context ctx=this;
    GPSTracker gps;
    String hospital_num;


    float dis=0;
    float min=1000000000;
    float lat,log;
    String A,B,C;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gps=new GPSTracker(Location.this);

        if(gps.canGetLocation()){
            double latitude= gps.getLatitude();
            double logitiude = gps.getLongitude();
            DatabaseOperations db =new DatabaseOperations(ctx);

            TextView name_hos= (TextView) findViewById(R.id.textView7);
            TextView address_hos= (TextView) findViewById(R.id.textView9);
            TextView phone_hos= (TextView) findViewById(R.id.textView11);


            Cursor CR=db.get_info(db);
            CR.moveToFirst();

            do {
                lat =CR.getFloat(3);
                log =CR.getFloat(4);
                dis=db.getDistance(latitude, logitiude,lat, log);
                if (dis<min)
                {  min=dis;
                    A=CR.getString(1);
                    B=CR.getString(5);
                    C=CR.getString(6);



                }

                //
                // b=b+"////// "+CR.getString(0)+"   "+CR.getString(1)+"    "+"   "+CR.getString(2)+"    "+"   "+CR.getString(3)+"    "+"   "+CR.getString(4)+"    " +CR.getString(5)+"    "+CR.getString(6)+String.valueOf(dis);

            }
            while (CR.moveToNext() );
            // t.setText(String.valueOf(log)+"   "+String.valueOf(lat));
            // float d;
            //  d =db.getDistance(24.256099, 55.754650,24.255972, 55.755498);
            // t.setText(String.valueOf(min)+b+String.valueOf(lat)+"  "+String.valueOf(log)+" "+CR.getString(3));

            name_hos.setText(A);
            address_hos.setText(B);
            phone_hos.setText(C);
            hospital_num=phone_hos.getText().toString();
            /////////////////////////////////////////////////////
           // Toast.makeText(getApplicationContext(),
            //        "Your Location is \nLat:"+latitude+"\nLong:"+logitiude,
              //      Toast.LENGTH_LONG).show();
        }else{
            gps.showSettingsAlert();
        }
        // make a call to the hospital
        btnShowLocation = (Button) findViewById(R.id.button2);

        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + hospital_num));
                startActivity(intent);
            }
        });


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
