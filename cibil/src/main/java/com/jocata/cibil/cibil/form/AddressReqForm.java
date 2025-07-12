package com.jocata.cibil.cibil.form;

import com.jocata.cibil.cibil.entity.Customers;


public class AddressReqForm {

    private String addressId;
    private String line;
    private String street;
    private String city;
    private String state;
    private String pincode;


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }



    public String getLine() {
        return line;
    }

    public String getPincode() {
        return pincode;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setLine(String line) {
        this.line = line;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
