package com.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Cache {

	private Map<Integer,String> altNameMap;
	
	public Map<Integer, String> getAltNameMap() {
		return altNameMap;
	}

	public void setAltNameMap(Map<Integer, String> altNameMap) {
		this.altNameMap = altNameMap;
	}

	@PostConstruct
	private void populateAltNameMap() {
		this.alternateNameMap();
	}
	
	private void alternateNameMap(){
		Map<Integer, String> altrNameMap = new HashMap<Integer,String>();
		
		altrNameMap.put(756560, "prnjn");
		altrNameMap.put(756575, "Anonymous");
		
		this.setAltNameMap(altrNameMap);
	}
}
