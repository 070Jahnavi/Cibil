package com.jocata.cibil.cibil.form;

import com.jocata.cibil.cibil.entity.Customers;

public class AddressResForm {

    //private String addressId;
    private String line;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public void setStreet(String street) {
        this.street = street;
    }


    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPincode() {
        return pincode;
    }

    /*public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressId() {
        return addressId;
    }*/



    public void setLine(String line) {
        this.line = line;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public String getLine() {
        return line;
    }

    public String getCity() {
        return city;
    }


}
