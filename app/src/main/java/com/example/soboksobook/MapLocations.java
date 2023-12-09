package com.example.soboksobook;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MapLocations {

    private static LatLng Input_LatLng ;

    ArrayList<Double> latitudes=new ArrayList<Double>(
            Arrays.asList(37.7082357,37.7170571,36.4988837,
                    36.4861709,36.3098763)
    );

    ArrayList<Double> longitudes=new ArrayList<Double>(
            Arrays.asList(126.6869545,126.7433821,127.268389,
                    127.2622568,127.4096763)
    );
    public MapLocations() {

        //3d37.7082357!4d126.6869545 //청양도서관
        /**3d37.7170571!4d126.7433821 //한울 도서관
         * 3d36.4988837!4d127.268389 //세종도서관
         * 3d36.4861709!4d127.2622568  //지혜의 숲
         * 3d36.3098763!4d127.4096763   //한밭도서관
         *
         */


    }

    public MapLocations(ArrayList<Double> latitudes, ArrayList<Double> longitudes) {
        this.latitudes = latitudes;
        this.longitudes = longitudes;
    }
}
