package com.lakkam.jobapplication.jobimpl;

import com.lakkam.jobapplication.job.Job;
import com.lakkam.jobapplication.job.JobRepository;
import com.lakkam.jobapplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    public JobRepository getJobRepository() {
        return jobRepository;
    }

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //    private List<Job> jobs=new ArrayList<>();
    JobRepository jobRepository;
    private long nextid=1L;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createjob(Job job) {
        job.setId(nextid++);
        jobRepository.save(job);
    }

    @Override
    public Job getById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {try {
             jobRepository.deleteById(id);
             return true;
        }catch (Exception e){
            return false;

        }
    }

    @Override
    public boolean updateJob(long id, Job updateJob) {
        Optional<Job> jobOptional=jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job=jobOptional.get();
                job.setTitle(updateJob.getTitle());
                job.setDescription(updateJob.getDescription());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setMinSalary(updateJob.getMinSalary());
                job.setLocation(updateJob.getLocation());
                jobRepository.save(job);
                return  true;
            }
        
        return false;
    }
}
