package com.geomatic.designPatern;

import com.geomatic.designPatern.Observer.EmailNotificationObserver;
import com.geomatic.designPatern.Observer.PushNotificationObserver;
import com.geomatic.designPatern.Observer.SMSNotificationObserver;
import com.geomatic.designPatern.domain.Notification;
import com.geomatic.designPatern.domain.UrgentNotification;
import com.geomatic.designPatern.enums.NotificationType;
import com.geomatic.designPatern.factory.NotificationFactory;
import com.geomatic.designPatern.singleton.NotificationManager;
import com.geomatic.designPatern.strategy.JSONNotificationStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPaternApplication {

	public static void main(String[] args) {

		NotificationManager notificationManager= NotificationManager.getInstance();
		notificationManager.addObserver(new EmailNotificationObserver());
		notificationManager.addObserver(new SMSNotificationObserver());
		notificationManager.addObserver(new PushNotificationObserver());

		Notification infoNotification = NotificationFactory.createNotification("Message Failed", NotificationType.INFO);
		Notification urgentNotification = NotificationFactory.createNotification("Message Failed", NotificationType.URGENT);
		Notification marketingNotification = NotificationFactory.createNotification("Message Failed", NotificationType.MARKETING);

		infoNotification.send();
		System.out.println("-------------------------------------------------");
		urgentNotification.send();
		System.out.println("-------------------------------------------------");
		marketingNotification.send();

	}

}
