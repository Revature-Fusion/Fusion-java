package repositories;

import models.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class AddressRepoTest {

    static AddressRepo ar = new AddressRepoImpl();

    static Address address;

    static Address createdAddress;

    public AddressRepoTest() {}

    @Before
    public void setUp() {
        Address a = new Address(1, 1, "K St", "K Town", "77777", "USA");
        address = ar.createAddress(a);
    }

    @After
    public void tearDown() {

        if (address != null) {
            ar.deleteAddress(address.getA_id());
            address = null;
        }
        if (createdAddress != null) {
            ar.deleteAddress(createdAddress.getA_id());
            createdAddress = null;
        }

    }

    @Test
    public void createAddress() {
        Address expected = new Address(1, 1, "K St", "K Town", "77777", "USA");
        createdAddress = ar.createAddress(expected);
        expected.setA_id(createdAddress.getA_id());
        Assertions.assertEquals(expected, createdAddress);
    }

    @Test
    public void getAddress() {
        Address actual = ar.getAddress(address.getA_id());
        Address expected = new Address(address.getA_id(), 1, "K St", "K Town", "77777", "USA");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAddressByUser() {
        List<Address> actual = ar.getAddressByUser(address.getU_id());
        Address expected = new Address(address.getA_id(), address.getU_id(), "K St", "K Town", "77777", "USA");
        Assertions.assertTrue(actual.contains(expected));
    }

    @Test
    public void updateAddress() {
        String newCity = "L Town";
        address.setCity(newCity);
        Address actual = ar.updateAddress(address);
        Assertions.assertEquals(actual.getCity(), newCity);
    }

    @Test
    public void deleteAddress() {
        Address actual = ar.deleteAddress(address.getA_id());
        Assertions.assertEquals(address, actual);
    }

}
