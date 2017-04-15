package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Start with a vector of N Jobs. Each Job has a typeID, an arbitrary integer that can be used to
//associate Jobs with each other. Let's assume this can be obtained from int Job::getType().
//We would like to process all N Jobs using some technique, but for performance reasons (e.g. CPU
//utilization) cannot process more than K jobs at a time.
//We would like Jobs of the same type to be processed together (e.g. Cache Localization, etc)
//Develop and implement a strategy to break the N jobs into batches of less than or equal to size K.
//Strive to keep jobs with the same type in the same batch. Also strive to achieve batch sizes that
//approach K.


public class DivideNJobsIntoKGroups {
	
	private class JobTypeTracking {
		JobType jobType;
		int currentIndex;
		JobTypeTracking(JobType jobType, int i) {
			this.jobType = jobType;
			this.currentIndex = i;
		}
	}
	private int batchJobId = 1;
	List<BatchJobs> divideJobs(List<Job> jobs, int k) {
		List<BatchJobs> batchJobs = new ArrayList<BatchJobs>();
		
		Map<JobType, List<Job>> jobTypeMap = new HashMap<JobType, List<Job>>();
		for(Job job: jobs) {
			if(jobTypeMap.containsKey(job.jobType)) {
				jobTypeMap.get(job.jobType).add(job);
			} else {
				List<Job> jobList = new ArrayList<Job>();
				jobList.add(job);
				jobTypeMap.put(job.jobType, jobList);
			}
		}
		
		Map<Integer, List<JobTypeTracking>> countMap = new TreeMap<Integer, List<JobTypeTracking>>(Collections.reverseOrder());
		for(JobType jobType: jobTypeMap.keySet()) {
			int size = jobTypeMap.get(jobType).size();
			JobTypeTracking jobTypeTracking = new JobTypeTracking(jobType,0);
			if(countMap.containsKey(size)) {
				countMap.get(size).add(jobTypeTracking);
			} else {
				List<JobTypeTracking> jobTypeTrackingList = new ArrayList<JobTypeTracking>();
				jobTypeTrackingList.add(jobTypeTracking);
				countMap.put(size, jobTypeTrackingList);
			}
		}
		divideJobsHelper(jobTypeMap, countMap, batchJobs, k);
		return batchJobs;
	}
	
	
	private void divideJobsHelper(Map<JobType, List<Job>> jobTypeMap, Map<Integer, List<JobTypeTracking>> countMap,
									List<BatchJobs> batchJobs, int k) {
		
		for(Integer size : countMap.keySet()) {
			List<JobTypeTracking> jobTypeTrackingList = countMap.get(size);
			for(JobTypeTracking jobTypeTracking: jobTypeTrackingList) {
				if(size>k) {
					createJobForMoreSize(jobTypeTracking, jobTypeMap, countMap, batchJobs, k, size);
				} else if(size<k) {
					
				}
			}
		}
		
	}
	
	private void createJobForMoreSize(JobTypeTracking jobTypeTracking, Map<JobType, List<Job>> jobTypeMap, 
			Map<Integer, List<JobTypeTracking>> countMap, List<BatchJobs> batchJobs, int k, int size) {
	
			int batchs = size/k;
			int remaining = size%k;
			
			for(int i=1; i<= batchs; i++) {
				List<Job> jobs = jobTypeMap.get(jobTypeTracking.jobType)
										   .subList(jobTypeTracking.currentIndex, jobTypeTracking.currentIndex+k-1);
				jobTypeTracking.currentIndex += k; 
				BatchJobs batchJob = new BatchJobs(batchJobId,jobs);
				batchJobs.add(batchJob);
			}
			countMap.get(size).remove(jobTypeTracking);
			if(countMap.get(size).size()==0)
				countMap.remove(size);
			if(countMap.containsKey(remaining)) {
				countMap.get(remaining).add(jobTypeTracking);
			}
			else {
				List<JobTypeTracking> jobTypeTrackingList = new ArrayList<JobTypeTracking>();
				jobTypeTrackingList.add(jobTypeTracking);
				countMap.put(remaining, jobTypeTrackingList);
			}
	}
	
	
	public static void main(String[] args) {
		
	}
}


class Job {
	int jobId;
	JobType jobType;
}

class JobType {
	int jobTypeId;
}

class BatchJobs {
	public BatchJobs(int batchJobId, List<Job> jobs) {
		this.batchJobId = batchJobId;
		this.jobsList = jobs;
	}
	int batchJobId;
	List<Job> jobsList;
	
}