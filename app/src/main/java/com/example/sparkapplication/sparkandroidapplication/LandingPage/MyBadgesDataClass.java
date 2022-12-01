package com.example.sparkapplication.sparkandroidapplication.LandingPage;

public class MyBadgesDataClass {
    public String MyBadgesName;

    public MyBadgesDataClass(String myBadgesName, int myBadgespath) {
        MyBadgesName = myBadgesName;
        MyBadgespath = myBadgespath;
    }

    public String getMyBadgesName() {
        return MyBadgesName;
    }

    public void setMyBadgesName(String myBadgesName) {
        MyBadgesName = myBadgesName;
    }

    public String getMyBadgesId() {
        return MyBadgesId;
    }

    public void setMyBadgesId(String myBadgesId) {
        MyBadgesId = myBadgesId;
    }

    public int getMyBadgespath() {
        return MyBadgespath;
    }

    public void setMyBadgespath(int myBadgespath) {
        MyBadgespath = myBadgespath;
    }

    //APi side data
    public String MyBadgesId;
    public int MyBadgespath;
}
