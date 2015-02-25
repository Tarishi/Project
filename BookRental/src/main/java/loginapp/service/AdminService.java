package loginapp.service;

import java.util.List;

import loginapp.exception.SystemException;
import loginapp.model.BookDTO;
import loginapp.model.Order;

public interface AdminService {
    List<BookDTO> search(String searchBook) throws SystemException;

    String delete(int iSBN) throws SystemException;

    String update(int iSBN);

    List<BookDTO> getbook(int iSBN) throws SystemException;

    String savebook(BookDTO bookdto) throws SystemException;

    List<Order> deliveryRequest() throws SystemException;

    String closeDelivery(int iSBN, int userId) throws SystemException;

    List<Order> returnRequest() throws SystemException;

    String closeReturn(int iSBN, int userId) throws SystemException;

}
