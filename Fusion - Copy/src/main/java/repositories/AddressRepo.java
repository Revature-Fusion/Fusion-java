package repositories;

import models.Address;

import java.util.List;

public interface AddressRepo {

    Address createAddress(Address a);

    Address getAddress(int a_id);

    List<Address> getAddressByUser(int u_id);

    Address updateAddress(Address change);

    Address deleteAddress(int a_id);

}
