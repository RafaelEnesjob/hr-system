package br.com.rafael.payrollapi.services;

import br.com.rafael.payrollapi.domain.Payroll;

public interface PayrollService {


    Payroll getPayment(Long workerId, Payroll payroll);

}
