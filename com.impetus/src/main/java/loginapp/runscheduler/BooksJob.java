package loginapp.runscheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BooksJob extends QuartzJobBean {

    private BooksTask booksTask;

    public void setBooksTask(BooksTask booksTask) {
        this.booksTask = booksTask;
    }

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {

        booksTask.printMessage();
        booksTask.addBooks();
        /** booksTask.deleteBooks(); */

    }

}
