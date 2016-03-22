package com.mears.entities;


public enum DriverRequestType {
    DAYOFF(1) {
        @Override
        public int id () {
            return 1;
        }

        @Override
        public String description () {
            return "Day Off";
        }

        @Override
        public int maxDays () {
            return 60;
        }

        @Override
        public int minDays () {
            return 0;
        }
    },
    WORK(2){
        @Override
        public int id () {
            return 2;
        }

        @Override
        public String description () {
            return "Work";
        }

        @Override
        public int maxDays () {
            return 60;
        }

        @Override
        public int minDays () {
            return 7;
        }
    };
    private int value;

    public abstract int id ();
    public abstract String description ();
    public abstract int maxDays ();
    public abstract int minDays ();

    private DriverRequestType(int n) {
        this.value = n;
    }
}
