package com.geomatic.designPatern.domain;

public class MarketingNotification extends Notification{
    @Override
    public void send() {
        System.out.println("Sending marketing notification : "+getMessage());
    }
}
