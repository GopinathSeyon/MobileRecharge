package Exception;

public class RechargeNotFoundException extends RuntimeException {
    public RechargeNotFoundException(String message) {
        super(message);
    }
}