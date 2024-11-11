package com.geomatic.designPatern.domain;


import com.geomatic.designPatern.strategy.NotificationStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Notification {
    private String message;
    private NotificationStrategy notificationStrategy;

    public abstract void  send(); // this method will be implemented by the concrete class
}
