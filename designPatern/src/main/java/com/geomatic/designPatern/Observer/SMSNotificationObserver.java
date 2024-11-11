package com.geomatic.designPatern.Observer;

import com.geomatic.designPatern.enums.NotificationType;

public class SMSNotificationObserver implements NotificationObserver{

    @Override
    public void update(String message, NotificationType type) {
        System.out.println("Sending SMS Notification : "+message );
    }
}
