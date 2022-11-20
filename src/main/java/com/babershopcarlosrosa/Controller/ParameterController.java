package com.babershopcarlosrosa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.babershopcarlosrosa.model.dto.ApiResponseDTO;
import com.babershopcarlosrosa.model.dto.JobDTO;
import com.babershopcarlosrosa.model.dto.ParameterDTO;
import com.babershopcarlosrosa.service.JobService;
import com.babershopcarlosrosa.service.ParameterService;


@RestController
@RequestMapping("/barbershop")
public class ParameterController {
	
    @Autowired
    private ParameterService parameterService;
    
    @Autowired
    private JobService jobService;

    @PostMapping(value = "/parameter", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponseDTO> inputParameter(@RequestBody ParameterDTO request) {
    	
        boolean verifyParameter = parameterService.parameter(request);

        if (verifyParameter) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("200", "Parameter save success!"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO("500", "Error to save parameter"));
    }
    
    @GetMapping(value = "/parameter", produces = "application/json")
    public ResponseEntity<ParameterDTO> getParameters() {
    	
    	ParameterDTO response = parameterService.getParameters();
    	
    	if (response != null) {
    		return ResponseEntity.ok(response);
    	}
    	
    	return ResponseEntity.badRequest().body(null);
    }
    
    @GetMapping(value = "/parameter/service", produces = "application/json")
    public ResponseEntity<List<JobDTO>> getAllJobs() {
    	
    	List<JobDTO> response = jobService.getJob();
    	
    	if (response.size() > 0) {
    		return ResponseEntity.ok(response);
    	}
    	
    	return ResponseEntity.badRequest().body(null);
    }
    
    @PostMapping(value = "/parameter/service", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiResponseDTO> createJob(@RequestBody JobDTO request) {
    	
    	boolean isCreated = jobService.insertJob(request);
    	
    	if (isCreated) {
        	return ResponseEntity.ok().body(new ApiResponseDTO("200", "Service created success"));

    	}
    	
    	return ResponseEntity.badRequest().body(new ApiResponseDTO("400", "Error to create service"));
    }
}
