package com.mears.entities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum DriverRequestType {
    DAYOFF(1) {
        @Override
        public int getId() {
            return 1;
        }

        @Override
        public String getDescription() {
            return "Day Off";
        }

        @Override
        public long getEarliestDayToSubmitRequest() {

            return 60;
        }

        @Override
        public long getLatestDayToSubmitRequest() {
            return 0;
        }
    },
    WORK(2){
        @Override
        public int getId() {
            return 2;
        }

        @Override
        public String getDescription() {
            return "Work";
        }

        @Override
        public long getEarliestDayToSubmitRequest() {
            return 60;
        }

        @Override
        public long getLatestDayToSubmitRequest() {
            return 7;
        }
    };
    private int value;

    public abstract int getId();
    public abstract String getDescription();
    public abstract long getEarliestDayToSubmitRequest();
    public abstract long getLatestDayToSubmitRequest();

    private DriverRequestType(int n) {
        this.value = n;
    }

    public boolean isWithinDateBounds (String reqDateString) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        Date reqDate = sd.parse(reqDateString.replaceAll("-", "/"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(reqDate);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date newReqDate = new GregorianCalendar(year, month, day).getTime();
        /** Today's date */
        Date today = new Date();

        /** Get msec from each, and subtract. */
        long diff = newReqDate.getTime() - today.getTime();
        diff = (diff / (1000 * 60 * 60 * 24));
        if (diff >= this.getLatestDayToSubmitRequest() &&
                diff <= this.getEarliestDayToSubmitRequest()) {
            return true;
        } else {
            return false;
        }
    }
}
