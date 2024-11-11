package com.geomatic.designPatern.singleton;

import com.geomatic.designPatern.Observer.NotificationObserver;
import com.geomatic.designPatern.enums.NotificationType;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {

    private  static NotificationManager instance;
    private List<NotificationObserver> observers=new ArrayList<>();

    private NotificationManager(){

    }

    // singleton (assure que nous avons creer qu'un seul instance de class notificationManager
    public  static NotificationManager getInstance(){
        if(instance==null){
            instance= new NotificationManager();
        }
        return instance;
    }


    public  void addObserver(NotificationObserver observer){
        observers.add(observer);
    }
    public void removeObserver(NotificationObserver observer){
        observers.remove(observer);
    }

    public void notify(String message, NotificationType type){
        for(NotificationObserver observer:observers){
            observer.update(message,type);
        }
    }

}
