package com.errorResponse;

import org.springframework.stereotype.Component;

public class ServiceErrorResponse {
    private final String error;
    
    public ServiceErrorResponse(String error) {
    	this.error = error;
    }
    
    public String getError() {
    	return this.error;
    }
}
