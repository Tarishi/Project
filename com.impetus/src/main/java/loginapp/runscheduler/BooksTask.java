package loginapp.runscheduler;

import loginapp.service.BooksSchedulerManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class BooksTask {

    private static Logger logger = Logger.getLogger(BooksTask.class);

    @Autowired
    private BooksSchedulerManager booksSchedulerManager;

    public void setBooksSchedulerManager(
            BooksSchedulerManager booksSchedulerManager) {
        this.booksSchedulerManager = booksSchedulerManager;
    }

    public void addBooks() {

        booksSchedulerManager.addBooks();
    }

    public void deleteBooks()

    {

        booksSchedulerManager.deleteBooks();
    }

    public void printMessage() {
        logger.info("booksTask schedular ~");
    }

}
