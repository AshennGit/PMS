package com.cao.pms.part3.service;

public interface SalaryComputeService {
    float computeDayperformence(int eid);

    float computeSuggestSalary(int eid,float coefficient);

}
