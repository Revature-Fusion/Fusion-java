package services;

import models.Address;
import repositories.AddressRepo;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressRepo ar;

    public AddressServiceImpl(AddressRepo ar) {
        this.ar = ar;
    }

    @Override
    public Address createAddress(Address a) {
        return ar.createAddress(a);
    }

    @Override
    public Address getAddress(int a_id) {
        return ar.getAddress(a_id);
    }

    @Override
    public List<Address> getAddressByUser(int u_id) {
        return ar.getAddressByUser(u_id);
    }

    @Override
    public Address updateAddress(Address change) {
        return ar.updateAddress(change);
    }

    @Override
    public Address deleteAddress(int a_id) {
        return ar.deleteAddress(a_id);
    }
}
