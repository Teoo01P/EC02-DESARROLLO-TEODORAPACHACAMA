package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "EC02 desarrollo=> ,  %s!";
	private static final String template2 = "Codigo de Estudiante: , %s!";
	private static final String template3 = "Nombre Completo: , %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "sm46714183 - Teodora Pachacama") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/idat/codigo")
	public Greeting greetingCodigo(@RequestParam(value = "name", defaultValue = "sm46714183") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template2, name));
	}

	@GetMapping("/idat/nombrecompleto")
	public Greeting greetingNombre(
			@RequestParam(value = "name", defaultValue = "Teodora Pachacama Coscco") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template3, name));
	}

}