package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.MyShelf;

public interface MyShelfService {

    String addBookToShelf(int iSBN, int userId) throws SystemException;

    List<MyShelf> viewshelf(int userid) throws SystemException;

    void remove(int iSBN, int userId) throws SystemException;

    String isAdded(Integer isbn, int uid);

    List<String> isOrdered(int userid);

}
