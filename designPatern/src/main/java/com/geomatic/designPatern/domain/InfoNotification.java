package com.geomatic.designPatern.domain;

public class InfoNotification extends Notification{
    @Override
    public void send() {
        System.out.println("Sending info notification : "+getMessage());
    }
}
