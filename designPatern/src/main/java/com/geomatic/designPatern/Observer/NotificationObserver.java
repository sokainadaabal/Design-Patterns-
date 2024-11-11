package com.geomatic.designPatern.Observer;

import com.geomatic.designPatern.enums.NotificationType;

public interface NotificationObserver {


    void update(String message, NotificationType type);
}
