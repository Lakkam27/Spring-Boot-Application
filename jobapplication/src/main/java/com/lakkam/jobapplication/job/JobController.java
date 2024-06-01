package com.lakkam.jobapplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> createjob(@RequestBody Job job){
        jobService.createjob(job);
        return new ResponseEntity<>("Job is added Successful",HttpStatus.OK);
    }
    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getById(@PathVariable Long id ){
        Job job=jobService.getById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id ){
        boolean deleted=jobService.deleteJob(id);
        if(deleted){
        return new ResponseEntity<>("succesfully deleted job",HttpStatus.OK);
        }
        return new ResponseEntity<>("the job your looking is not fond ",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> UpdateJob(@PathVariable long id,@RequestBody Job updateJob){
        boolean update=jobService.updateJob(id,updateJob);
        if (update){
            return new ResponseEntity<>("Job is successfully updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job is NOT FOND",HttpStatus.NOT_FOUND);

    }
}
