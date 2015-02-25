package loginapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class BookDTO.
 */
@Entity
@Table(name = "book")
public class BookDTO {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + iSBN;
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

   
    @Override
    public String toString() {
        return "BookDTO [ISBN=" + iSBN + ", bookTitle=" + bookTitle
                + ", bookAuthor=" + bookAuthor + ", bookDescription="
                + bookDescription + ", bookPublisher=" + bookPublisher
                + ", no_of_copies=" + noOfCopies + ", bookCategory="
                + bookCategory + ", bookImage=" + bookImage + ", booksOrdered="
                + booksOrdered + "]";
    }

    /** The book id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ISBN")
    private Integer iSBN;

    @OneToMany(mappedBy = "bookdto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<BookID> bookid;

    /** The book title. */
    @Column(name = "bookTitle")
    private String bookTitle;

    public Set<BookID> getBookid() {
        return bookid;
    }

    public void setBookid(Set<BookID> bookid) {
        this.bookid = bookid;
    }

    /** The book author. */
    @Column(name = "bookAuthor")
    private String bookAuthor;

    @Column(name = "isactive")
    private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /** The book description. */
    @Column(name = "bookDescription")
    private String bookDescription;

    /** The book publisher. */
    @Column(name = "bookPublisher")
    private String bookPublisher;

    /** The book availability. */
    @Column(name = "no_of_copies")
    private Integer noOfCopies;

    /** The book category. */
    @Column(name = "bookCategory")
    private String bookCategory;

    /** The book image. */

    @Column(name = "bookImage")
    private String bookImage;

    /** The books ordered. */
    @Column(name = "booksOrdered")
    private Integer booksOrdered;
    /**
     * Gets the book id.
     * 
     * @return the book id
     */

    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getISBN() {
        return iSBN;
    }

    /**
     * Sets the book id.
     * 
     * @param isbn
     *            the new isbn
     */
    public void setISBN(Integer isbn) {
        this.iSBN = isbn;
    }

    /**
     * Gets the book title.
     * 
     * @return the book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Sets the book title.
     * 
     * @param bookTitle
     *            the new book title
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Gets the book description.
     * 
     * @return the book description
     */
    public String getBookDescription() {
        return bookDescription;
    }

    /**
     * Sets the book description.
     * 
     * @param bookDescription
     *            the new book description
     */
    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    /**
     * Gets the book author.
     * 
     * @return the book author
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * Sets the book author.
     * 
     * @param bookAuthor
     *            the new book author
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * Gets the book publisher.
     * 
     * @return the book publisher
     */
    public String getBookPublisher() {
        return bookPublisher;
    }

    /**
     * Sets the book publisher.
     * 
     * @param bookPublisher
     *            the new book publisher
     */
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    /**
     * Gets the no_of_copies.
     * 
     * @return the no_of_copies
     */
    public Integer getNoOfCopies() {
        return noOfCopies;
    }

    /**
     * Sets the no_of_copies.
     * 
     * @param noOfCopies
     *            the new no_of_copies
     */
    public void setNoOfCopies(Integer noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    /**
     * Gets the books ordered.
     * 
     * @return the books ordered
     */
    public Integer getBooksOrdered() {
        return booksOrdered;
    }

    /**
     * Sets the books ordered.
     * 
     * @param booksOrdered
     *            the new books ordered
     */
    public void setBooksOrdered(Integer booksOrdered) {
        this.booksOrdered = booksOrdered;
    }

    /**
     * Gets the book image.
     * 
     * @return the book image
     */
    public String getBookImage() {
        return bookImage;
    }

    /**
     * Sets the book image.
     * 
     * @param bookImage
     *            the new book image
     */
    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    /**
     * Gets the book category.
     * 
     * @return the book category
     */
    public String getBookCategory() {
        return bookCategory;
    }

    /**
     * Sets the book category.
     * 
     * @param bookCategory
     *            the new book category
     */
    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

}
