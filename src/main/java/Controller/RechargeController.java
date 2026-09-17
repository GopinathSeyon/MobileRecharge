package Controller;

import Model.MobileRecharge;
import Service.RechargeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recharge")
public class RechargeController {

    private final RechargeService rechargeService;

    public RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }

    @PostMapping
    public ResponseEntity<MobileRecharge> createRecharge(@Valid @RequestBody MobileRecharge recharge) {
        MobileRecharge savedRecharge = rechargeService.processRecharge(recharge);
        return new ResponseEntity<>(savedRecharge, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MobileRecharge>> getAllRecharges() {
        return ResponseEntity.ok(rechargeService.getAllRecharges());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MobileRecharge> getRechargeById(@PathVariable Long id) {
        return ResponseEntity.ok(rechargeService.getRechargeById(id));
    }
}