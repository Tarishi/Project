package loginapp.runscheduler;

import java.io.IOException;

import loginapp.controller.LoginController;
import loginapp.exception.SystemException;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderJob.
 */
public class PlanReminderJob extends QuartzJobBean {

    /** The plan reminder task. */
    private PlanReminderTask planReminderTask;

    /** The logger. */
    private static Logger logger = Logger.getLogger(PlanReminderJob.class);
    
    /**
     * Sets the plan reminder task.
     * 
     * @param planReminderTask
     *            the new plan reminder task
     */
    public void setPlanReminderTask(PlanReminderTask planReminderTask) {
        this.planReminderTask = planReminderTask;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org
     * .quartz.JobExecutionContext)
     */
    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {

        planReminderTask.printMessage();

       try
       {
            planReminderTask.getUsersByMonth();
            planReminderTask.getUsersByDays();
            planReminderTask.getUsersByWeek();
       }
       catch(SystemException e)
       {
           logger.error("exception in job execution ",e);
           
       }
       catch(IOException e)
       {
           logger.error("exception in job execution ",e);
           
       }

    }

}
