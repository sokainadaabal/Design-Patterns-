package com.geomatic.designPatern.factory;

import com.geomatic.designPatern.domain.InfoNotification;
import com.geomatic.designPatern.domain.MarketingNotification;
import com.geomatic.designPatern.domain.Notification;
import com.geomatic.designPatern.domain.UrgentNotification;
import com.geomatic.designPatern.enums.NotificationType;
import com.geomatic.designPatern.strategy.HTMLNotificationStrategy;
import com.geomatic.designPatern.strategy.JSONNotificationStrategy;
import com.geomatic.designPatern.strategy.PlainTextNotificationStrategy;

public class NotificationFactory {
    public static Notification createNotification(String message, NotificationType type){
        return switch (type){
            case INFO -> new InfoNotification(message,new JSONNotificationStrategy());
            case URGENT-> new UrgentNotification(message, new PlainTextNotificationStrategy());
            case MARKETING-> new MarketingNotification(message, new HTMLNotificationStrategy());};

    }
}
