package com.babershopcarlosrosa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.babershopcarlosrosa.model.dto.ApiResponseDTO;
import com.babershopcarlosrosa.model.dto.ParameterDTO;
import com.babershopcarlosrosa.service.ParameterService;


@RestController
@RequestMapping("/barbershop")
public class ParameterController {
	
    @Autowired
    private ParameterService parameterService;

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
    
}
