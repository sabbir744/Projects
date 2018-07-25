package com.uber.sabbirtech.uberclone.historyRecyclerView;

/**
 * Created by SABBIR TECH on 25-Jul-18.
 */

public class HistoryObject {
    private String rideId;
    private String time;

    public HistoryObject(String rideId, String time){
        this.rideId = rideId;
        this.time = time;
    }

    public String getRideId(){return rideId;}
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getTime(){return time;}
    public void setTime(String time) {
        this.time = time;
    }
}
