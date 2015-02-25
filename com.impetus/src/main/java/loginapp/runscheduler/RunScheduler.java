/*package loginapp.RunScheduler;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
*//**
 * The Class RunScheduler.
 *//*
@Component
public class RunScheduler {

	*//** The job launcher. *//*
	@Autowired
	private JobLauncher jobLauncher;

	*//** The job. *//*
	@Autowired
	private Job job;

	*//**
	 * Run.
	 *//*
	public void run() {

		try {

			String dateParam = new Date().toString();
			JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
			
			System.out.println(dateParam);
			
			JobExecution execution = jobLauncher.run(job, param);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}*/