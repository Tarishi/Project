package loginapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requestBook")
public class Order {

    @Override
    public String toString() {
        return "Order [book=" + book + ", requestId=" + requestId + ", userId="
                + userId + ", userName=" + userName + ", deliveryType="
                + deliveryType + ", returnType=" + returnType
                + ", deliveryDate=" + deliveryDate + ", returnRequestDate="
                + returnRequestDate + ", deliveryrequestDate="
                + deliveryrequestDate + ", returnDate=" + returnDate + "]";
    }

    @OneToOne
    @JoinColumn(name = "bookId")
    private BookID book;

    public BookID getBook() {
        return book;
    }

    public void setBook(BookID book) {
        this.book = book;
    }

    /** The request id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "requestId")
    private Integer requestId;

    /** The user id. */
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "userName")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** The request type. */
    @Column(name = "deliveryType")
    private String deliveryType;

    /** The request status. */
    @Column(name = "returnType")
    private String returnType;

    /** The delivery date. */
    @Column(name = "deliveryDate")
    private Date deliveryDate;

    @Column(name = "returnRequestDate")
    private Date returnRequestDate;

    @Column(name = "deliveryrequestDate")
    private Date deliveryrequestDate;

    /** The return date. */
    @Column(name = "returnDate")
    private Date returnDate;

    /**
     * Gets the request id.
     * 
     * @return the request id
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * Sets the request id.
     * 
     * @param requestId
     *            the new request id
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets the user id.
     * 
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     * 
     * @param userId
     *            the new user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the delivery date.
     * 
     * @return the delivery date
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the delivery date.
     * 
     * @param deliveryDate
     *            the new delivery date
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Gets the return date.
     * 
     * @return the return date
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the return date.
     * 
     * @param returnDate
     *            the new return date
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Date getReturnRequestDate() {
        return returnRequestDate;
    }

    public void setReturnRequestDate(Date returnRequestDate) {
        this.returnRequestDate = returnRequestDate;
    }

    public Date getDeliveryrequestDate() {
        return deliveryrequestDate;
    }

    public void setDeliveryrequestDate(Date deliveryrequestDate) {
        this.deliveryrequestDate = deliveryrequestDate;
    }

}
