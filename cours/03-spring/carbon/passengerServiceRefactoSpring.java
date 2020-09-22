public interface PassengerService {
    void pay(Trip trip);
}
@Service
class PassengerServiceImpl implements PassengerService {
    private PaymentService paymentService;
    private NotificationService notificationService;
    @Autowired
    void setPaymentService(PaymentService service) {
        this.paymentService = service;
    }
    @Autowired
    void setNotificationService(NotificationService service) {
        this.notificationService = service;
    }
    void pay(Trip trip){
        this.paymentService.pay(trip.getPrice(), trip.getDriver());
        var event = new TripPaidEvent(trip);
        this.notificationService.notify(event);
    }
}

@Service
class PassengerServiceImpl implements PassengerService {
    private PaymentService paymentService;
    private NotificationService notificationService;
    @Autowired
    PassengerServiceImpl(PaymentService paymentService, NotificationService notificationService){
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }
    void pay(Trip trip){
        this.paymentService.pay(trip.getPrice(), trip.getDriver());
        var event = new TripPaidEvent(trip);
        this.notificationService.notify(event);
    }
}

public interface PaymentService {
    void pay(float price, Driver driver);
}
@Service
class PaymentServiceImpl implements PaymentService{}

public interface NotificationService {
    void notify(Event event);
}
@Service
class NotificationServiceImpl implements NotificationService{}