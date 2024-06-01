package com.lakkam.jobapplication.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createjob(Job job);


    Job getById(Long id);
    boolean deleteJob(Long id);

    boolean updateJob(long id, Job updateJob);


}
