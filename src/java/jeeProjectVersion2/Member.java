package jeeProjectVersion2;

/**
 *
 * @author Administrateur
 */
public class Member {
    private int id;
    private String firstname;
    private String lastname;
    private String homeNum;
    private String mobileNum;
    private String workNum;
    private String address;
    private int postalCode;
    private String city;
    private String email;
    
    public Member ()
    {
        
    }

    public Member(int id,String firstname, String lastname, String homeNum, String mobileNum, String workNum, String address, int postalCode, String city, String email) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.homeNum = homeNum;
        this.mobileNum = mobileNum;
        this.workNum = workNum;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", homeNum=" + homeNum + ", mobileNum=" + mobileNum + ", workNum=" + workNum + ", address=" + address + ", postalCode=" + postalCode + ", city=" + city + ", email=" + email + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(String homeNum) {
        this.homeNum = homeNum;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
