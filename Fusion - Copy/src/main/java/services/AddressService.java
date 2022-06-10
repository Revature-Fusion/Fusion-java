package services;

import models.Address;

import java.util.List;

public interface AddressService {

    Address createAddress(Address a);

    Address getAddress(int a_id);

    List<Address> getAddressByUser(int u_id);

    Address updateAddress(Address change);

    Address deleteAddress(int a_id);

}
