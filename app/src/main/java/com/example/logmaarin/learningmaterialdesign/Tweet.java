package com.example.logmaarin.learningmaterialdesign;

/**
 * Created by LogMaarIn on 15-5-2015.
 */
public class Tweet {

    int pf;
    User user;
    String tweet;
    Entity entity;

    public User getUser() {
        return user;
    }

    public Entity getEntity() {
        return entity;
    }

    public Tweet(String a, User user, Entity entity){
        this.user = user;
        this.entity =  entity;

        this.tweet=a;
    }

    public int getPf() {
        return pf;
    }


    public String getTweet() {
        return tweet;
    }



}
