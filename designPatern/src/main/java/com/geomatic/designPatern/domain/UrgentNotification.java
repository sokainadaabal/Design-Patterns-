package com.geomatic.designPatern.domain;

import com.geomatic.designPatern.enums.NotificationType;
import com.geomatic.designPatern.singleton.NotificationManager;
import com.geomatic.designPatern.strategy.NotificationStrategy;

public class UrgentNotification extends Notification{
    public UrgentNotification(String message, NotificationStrategy notificationStrategy) {
        super(message, notificationStrategy);
    }

    @Override
    public void send() {
        String formatMessage= getNotificationStrategy().formateMessage("[URGENT] "+getMessage());
        NotificationManager.getInstance().notify(formatMessage, NotificationType.URGENT);
    }
}
