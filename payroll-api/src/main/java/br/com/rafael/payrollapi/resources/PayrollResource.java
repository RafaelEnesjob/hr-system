package br.com.rafael.payrollapi.resources;

import br.com.rafael.payrollapi.domain.Payroll;
import br.com.rafael.payrollapi.services.impl.PayrollServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/payments")
public class PayrollResource {

    private final PayrollServiceImpl service;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayments(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(service.getPayment(workerId, payment));

    }
}
