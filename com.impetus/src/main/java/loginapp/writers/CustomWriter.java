/*package loginapp.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import loginapp.dao.BookDAO;
import loginapp.model.BookDTO;

// TODO: Auto-generated Javadoc
*//**
 * The Class CustomWriter.
 *//*
public class CustomWriter implements ItemWriter<BookDTO> {

     (non-Javadoc)
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 
	public void write(List<? extends BookDTO> items) throws Exception {
		System.out.println("writer..." + items.size());		
		for(BookDTO item : items){
			System.out.println(item);
			BookDAO bookdao = null;
			bookdao.addBook(item);
		}
		
	}

}*/