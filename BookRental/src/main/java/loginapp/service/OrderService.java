package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.Order;

public interface OrderService {

    String orderBook(int userId, int iSBN) throws SystemException;

    List<Order> booksheld(int uid) throws SystemException;

    String returnBook(int userId, int iSBN) throws SystemException;

    String cancelBook(int userId, int iSBN) throws SystemException;

    List booksRequested(int userId) throws SystemException;

    String cancelRequest(int userId, int iSBN) throws SystemException;

}
