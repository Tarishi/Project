package loginapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class SubscriptionHistory.
 */
@Entity
@Table(name="subscriptionHistory")

public class SubscriptionHistory {
	
	/** The Id. */
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "Id")
	 private Integer Id;
	
	/** The user id. */
	@Column(name = "userId")
	 private Integer userId;
	
	/** The plan id. */
	@Column(name = "planId")
	 private Integer planId;
	 
	
	 
	 /**
 	 * Gets the id.
 	 *
 	 * @return the id
 	 */
 	public Integer getId() {
		  return Id;
	 }
	 
	 /**
 	 * Sets the id.
 	 *
 	 * @param Id the new id
 	 */
 	public void setId(Integer Id) {
		  this.Id = Id;
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
 	 * @param userId the new user id
 	 */
 	public void setUserId(Integer userId) {
		  this.userId = userId;
	 }
	
	 /**
 	 * Gets the plan id.
 	 *
 	 * @return the plan id
 	 */
 	public Integer getPlanId() {
		  return planId;
	 }
	 
 	/**
 	 * Sets the plan id.
 	 *
 	 * @param planId the new plan id
 	 */
 	public void setPlanId(Integer planId) {
		  this.planId = planId;
	 }
		 
 		
}
