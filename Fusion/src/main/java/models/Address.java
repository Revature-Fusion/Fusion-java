package models;

import java.util.Objects;

public class Address {

    private int a_id;

    private int u_id;

    private String address;

    private String city;

    private String postal_code;

    private String country;

    public Address(int a_id, int u_id, String address, String city, String postal_code, String country) {

        this.a_id = a_id;
        this.u_id = u_id;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;

    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return getA_id() == address1.getA_id() && getU_id() == address1.getU_id() && Objects.equals(getAddress(), address1.getAddress()) && Objects.equals(getCity(), address1.getCity()) && Objects.equals(getPostal_code(), address1.getPostal_code()) && Objects.equals(getCountry(), address1.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA_id(), getU_id(), getAddress(), getCity(), getPostal_code(), getCountry());
    }

    @Override
    public String toString() {
        return "Address{" +
                "a_id=" + a_id +
                ", u_id=" + u_id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
