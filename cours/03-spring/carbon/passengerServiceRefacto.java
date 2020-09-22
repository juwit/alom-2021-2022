public interface PassengerService {
    void validate(Trip trip);
}
class PassengerServiceImpl implements PassengerService {
    private PaymentService paymentService;

    void setPaymentService(PaymentService service) {
        this.paymentService = service;
    }
    void validate(Trip trip){
        this.paymentService.pay(trip.getPrice(), trip.getDriver());
    }
}
public interface PaymentService {
    void pay(float price, Driver driver);
}
class PaymentServiceImpl implements PaymentService {
    private NotificationService notificationService;
    void setNotificationService(NotificationService service) {
        this.notificationService = service;
    }
    void pay(float price, Driver driver) {
        var event = new TripPaidEvent(driver);
        this.notificationService.notify(event);
    }
}

public interface NotificationService {
    void notify(Event event);
}