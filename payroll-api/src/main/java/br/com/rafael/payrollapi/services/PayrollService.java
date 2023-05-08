package br.com.rafael.payrollapi.services;

import br.com.rafael.payrollapi.domain.Payroll;
import br.com.rafael.payrollapi.feignClients.UserFeign;
import br.com.rafael.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERIVE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            var user = feign.findyById(workerId).getBody();
            if (!ObjectUtils.isEmpty(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHouryPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHouryPrice()
                );
            }

        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}
