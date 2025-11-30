package net.HM.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HC {

	@GetMapping("/status")
	public String hotel() {
		return "starting project";
	}
}
