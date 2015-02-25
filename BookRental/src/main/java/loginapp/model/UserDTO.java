package loginapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class DTO.
 */
/**
 * @author tarishi.upadhyay
 * 
 */
@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    /** The id. */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "role_id")
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPlanid() {
        return planid;
    }

    public void setPlanid(Integer planId2) {
        this.planid = planId2;
    }

    @Column(name = "plan_id")
    private Integer planid;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", roleId=" + roleId + ", planid="
                + planid + ", userName=" + userName + ", firstName="
                + firstName + ", userPassword=" + userPassword + ", lastName="
                + lastName + ", email=" + email + ", address=" + address
                + ", role=" + role + ", enabled=" + enabled + ", contact="
                + contact + "]";
    }

    /** The user name. */
    @Column(name = "user_name")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** The user password. */
    @Column(name = "user_password")
    private String userPassword;

    /** The last name. */
    @Column(name = "lastname")
    private String lastName;

    /** The email. */
    @Column(name = "email_id")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Integer enabled;
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "contact")
    private String contact;

    /**
     * Gets the last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * 
     * @param lastName
     *            the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     * 
     * @param email
     *            the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the user name.
     * 
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     * 
     * @param userName
     *            the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user password.
     * 
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the user password.
     * 
     * @param userPassword
     *            the new user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}