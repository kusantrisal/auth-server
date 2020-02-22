package com.zerotoheroquick.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

	@GetMapping("/health")
	public Map<String, String> health() {
		return Collections.singletonMap("Status", "UP");
	}
	
}
