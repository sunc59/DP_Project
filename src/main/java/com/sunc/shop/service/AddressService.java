package com.sunc.shop.service;


import com.sunc.shop.dao.AddressDao;
import com.sunc.shop.model.Address;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/20 23:16
 */
public class AddressService {

    private AddressDao addressDao = new AddressDao();

    public void addAddress(Address address, String uid){
        addressDao.insertAddress(address,uid);
    }

    public List<Address> findAddressByUser(String uid) {
        List<Address> list = addressDao.findByUserId(uid);
        return list;
    }

    public void deleteAddress(String id) {
        addressDao.deleteById(id);
    }

    public Address findAddressById(String id) {
        Address address = addressDao.findById(id);
        return address;
    }
}
