package loginapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class BookID.
 * 
 * @author tarishi.upadhyay
 */

@Entity
@Table(name = "book_id")
public class BookID implements Serializable {

    @Override
    public String toString() {
        return "BookID [bookdto=" + bookdto + ", bookID=" + bookID
                + ", availabilty=" + availabilty + "]";
    }

    /** The bookdto. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "BISBN", referencedColumnName = "ISBN")
    private BookDTO bookdto;

    /**
     * Gets the bookdto.
     * 
     * @return the bookdto
     */
    public BookDTO getBookdto() {
        return bookdto;
    }

    /**
     * Sets the bookdto.
     * 
     * @param bookdto
     *            the new bookdto
     */
    public void setBookdto(BookDTO bookdto) {
        this.bookdto = bookdto;
    }

    /**
     * Gets the book id.
     * 
     * @return the book id
     */
    public Integer getBookID() {
        return bookID;
    }

    /**
     * Sets the book id.
     * 
     * @param bookID
     *            the new book id
     */
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    /**
     * Gets the availabilty.
     * 
     * @return the availabilty
     */
    public Boolean getAvailabilty() {
        return availabilty;
    }

    /**
     * Sets the availabilty.
     * 
     * @param availabilty
     *            the new availabilty
     */
    public void setAvailabilty(Boolean availabilty) {
        this.availabilty = availabilty;
    }

    /** The book id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookID")
    private Integer bookID;

    /** The Availabilty. */
    @Column(name = "Availabilty")
    private Boolean availabilty;

}
