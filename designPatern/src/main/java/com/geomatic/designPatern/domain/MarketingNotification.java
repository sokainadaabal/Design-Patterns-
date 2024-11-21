package com.geomatic.designPatern.domain;

import com.geomatic.designPatern.enums.NotificationType;
import com.geomatic.designPatern.singleton.NotificationManager;
import com.geomatic.designPatern.strategy.NotificationStrategy;

public class MarketingNotification extends Notification{
    public MarketingNotification(String message, NotificationStrategy notificationStrategy) {
        super(message, notificationStrategy);
    }

    @Override
    public void send() {
        String formatMessage= getNotificationStrategy().formateMessage("[MARKETING] "+getMessage());
        NotificationManager.getInstance().notify(formatMessage, NotificationType.MARKETING);

    }
}
