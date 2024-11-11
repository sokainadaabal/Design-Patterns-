package com.geomatic.designPatern.domain;

public class UrgentNotification extends Notification{
    @Override
    public void send() {
        System.out.println("Sending urgent notification : "+getMessage());
    }
}
