package com.example.testservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestServiceApplication.class, args);
	}

	@RestController
	static class TestController {

		@GetMapping("/")
		public String test() {
			return "test";
		}

		@PostMapping(value = "/test", produces = "application/json", consumes = "application/json")
		public TestReturnType testTypesForReflection(@RequestBody TestArgType testArg) {
			return new TestReturnType(testArg.getTest());
		}

	}

}

class TestReturnType {

	private String test;

	public TestReturnType(String test) {
		this.test = test;
	}

	public TestReturnType() {
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}

class TestArgType {

	private String test;

	public TestArgType(String test) {
		this.test = test;
	}

	public TestArgType() {
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}