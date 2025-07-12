package com.jocata.cibil.cibil.Dao;

import com.jocata.cibil.cibil.entity.Address;
import com.jocata.cibil.cibil.entity.Customers;

public interface CustomerDao {
    public Customers saveCustomer(Customers entity);
    public Customers findCustomerByPan(String pan);
}
