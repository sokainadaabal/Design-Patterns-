package com.geomatic.designPatern.domain;

import com.geomatic.designPatern.enums.NotificationType;
import com.geomatic.designPatern.singleton.NotificationManager;

public class MarketingNotification extends Notification{
    @Override
    public void send() {
        String formatMessage= getNotificationStrategy().formateMessage("[INFO] "+getMessage());
        NotificationManager.getInstance().notify(formatMessage, NotificationType.INFO);

    }
}
