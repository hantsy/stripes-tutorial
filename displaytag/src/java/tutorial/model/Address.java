/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.model;

/**
 *
 * @author hantsy
 */
public class Address {
    private String zipcode;
    private String addressLine1;
    private String addressLine2;


    public Address() {
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }



    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
