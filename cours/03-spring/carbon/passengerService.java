import java.sql.Driver;mport java.sql.Driver;

class PassengerService {
    private PaymentService paymentService = new PaymentService();
    private NotificationService notificationService = new NotificationService();
    void pay(Trip trip){
        this.paymentService.pay(trip.getPrice(), trip.getDriver());
        var event = new TripPaidEvent(trip.getDriver());
        this.notify(event);
    }
    void notify(Event event){
        [...]
    }
}
class PaymentService {
    void pay(float price, Driver driver){
        [...]
    }
}