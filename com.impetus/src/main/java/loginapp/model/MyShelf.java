package loginapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "myshelf")
public class MyShelf implements Serializable {

    @Override
    public String toString() {
        return "MyShelf [iD=" + iD + ", user=" + user + ", book=" + book + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer iD;

    @OneToOne
    @JoinColumn(name = "User_id")
    private UserDTO user;
    @ManyToOne
    @JoinColumn(name = "Book_id")
    private BookDTO book;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

}
