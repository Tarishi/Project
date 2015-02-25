package loginapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanDTO.
 */
@Entity
@Table(name = "subscription_plan")
/* @SuppressWarnings("serial") */
public class PlanDTO implements Serializable {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((planId == null) ? 0 : planId.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlanDTO [plan_name=" + planName + ", amount=" + amount
                + ", duration=" + duration + ", max_books=" + maxBooks
                + ", plan_id=" + planId + "]";
    }

    /** The plan_name. */
    @Column(name = "Plan_name")
    private String planName;

    /** The amount. */
    @Column(name = "Amount")
    private String amount;

    /** The duration. */
    @Column(name = "Duration")
    private Integer duration;

    /** The max_books. */
    @Column(name = "Max_books")
    private Integer maxBooks;

    /** The plan_id. */
    @Id
    @GeneratedValue
    @Column(name = "plan_id", length = 11)
    private Integer planId;

    /**
     * Gets the plan_name.
     * 
     * @return the plan_name
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Sets the plan_name.
     * 
     * @param planName
     *            the new plan_name
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * Gets the amount.
     * 
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     * 
     * @param amount
     *            the new amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the duration.
     * 
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     * 
     * @param duration
     *            the new duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the max_books.
     * 
     * @return the max_books
     */
    public Integer getMaxBooks() {
        return maxBooks;
    }

    /**
     * Sets the max_books.
     * 
     * @param maxBooks
     *            the new max_books
     */
    public void setMaxBooks(Integer maxBooks) {
        this.maxBooks = maxBooks;
    }

    /**
     * Gets the plan_id.
     * 
     * @return the plan_id
     */
    public Integer getPlanId() {
        return planId;
    }

    /**
     * Sets the plan_id.
     * 
     * @param planId
     *            the new plan_id
     */
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

}
