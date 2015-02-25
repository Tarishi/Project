package loginapp.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class UserSubscribeDTO.
 */
@Entity
@Table(name = "user_sub")
@SuppressWarnings("serial")
public class UserSubscribeDTO implements Serializable {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserSubscribeDTO [id=" + id + ", start_date=" + startDate
                + ", end_date=" + endDate + ", user=" + user + ", plan=" + plan
                + "]";
    }

    /** The id. */
    @Column(name = "usid")
    @Id
    @GeneratedValue
    private Integer id;

    /** The start_date. */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * Gets the start_date.
     * 
     * @return the start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start_date.
     * 
     * @param startDate
     *            the new start_date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end_date.
     * 
     * @return the end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end_date.
     * 
     * @param endDate
     *            the new end_date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /** The end_date. */
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "status")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Column(name = "booksOrdered")
    private Integer booksOrdered;

    public Integer getBooksOrdered() {
        return booksOrdered;
    }

    public void setBooksOrdered(Integer booksOrdered) {
        this.booksOrdered = booksOrdered;
    }

    /** The user. */
    @OneToOne
    @JoinColumn(name = "userid")
    private UserDTO user;

    /** The plan. */
    @ManyToOne
    @JoinColumn(name = "subid")
    private PlanDTO plan;

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
     * Gets the user.
     * 
     * @return the user
     */
    public UserDTO getUser() {
        return user;
    }

    /**
     * Sets the user.
     * 
     * @param user
     *            the new user
     */
    public void setUser(UserDTO user) {
        this.user = user;
    }

    /**
     * Gets the plan.
     * 
     * @return the plan
     */
    public PlanDTO getPlan() {
        return plan;
    }

    /**
     * Sets the plan.
     * 
     * @param plan
     *            the new plan
     */
    public void setPlan(PlanDTO plan) {
        this.plan = plan;
    }

}
