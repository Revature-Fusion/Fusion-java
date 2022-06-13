package models;

import java.util.Objects;

public class Orders {

    private int oID;    // Order ID
    private int uID;    // User ID
    private long dateOfPurchase;   // Date Of Purchasing as UNIX Timestamp
    private int aID;    // Address ID

    public Orders(){ }

    public Orders(int oID, int uID, long dateOfPurchase, int aID) {
        this.oID = oID;
        this.uID = uID;
        this.dateOfPurchase = dateOfPurchase;
        this.aID = aID;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public long getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(long dateOfPurchase) {this.dateOfPurchase = dateOfPurchase;}

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return oID == orders.oID && uID == orders.uID && dateOfPurchase == orders.dateOfPurchase && aID == orders.aID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(oID, uID, dateOfPurchase, aID);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oID=" + oID +
                ", uID=" + uID +
                ", dateOfPurchase=" + dateOfPurchase +
                ", aID=" + aID +
                '}';
    }

}
