package com.jocata.cibil.cibil.Dao;

import com.jocata.cibil.cibil.entity.Address;

public interface AddressDao {

    public Address saveAddress(Address entity);
    public Address findAddressByCustomerId(String pan);
}
