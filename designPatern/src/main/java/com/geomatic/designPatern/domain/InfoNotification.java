package com.geomatic.designPatern.domain;

import com.geomatic.designPatern.enums.NotificationType;
import com.geomatic.designPatern.singleton.NotificationManager;
import com.geomatic.designPatern.strategy.NotificationStrategy;

public class InfoNotification extends Notification{
    public InfoNotification(String message, NotificationStrategy notificationStrategy) {
        super(message, notificationStrategy);
    }

    @Override
    public void send() {
        String formatMessage= getNotificationStrategy().formateMessage("[INFO] "+getMessage());
        NotificationManager.getInstance().notify(formatMessage, NotificationType.INFO);

    }
}
