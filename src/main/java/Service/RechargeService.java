package Service;

import Exception.RechargeNotFoundException;
import Model.MobileRecharge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RechargeService {

    private final List<MobileRecharge> rechargeStore = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public MobileRecharge processRecharge(MobileRecharge recharge) {
        recharge.setRechargeId(idCounter.getAndIncrement());
        rechargeStore.add(recharge);
        return recharge;
    }

    public List<MobileRecharge> getAllRecharges() {
        return rechargeStore;
    }

    public MobileRecharge getRechargeById(Long id) {
        return rechargeStore.stream()
                .filter(r -> r.getRechargeId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RechargeNotFoundException("Recharge record not found with ID: " + id));
    }
}