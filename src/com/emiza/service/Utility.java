package com.emiza.service;

public class Utility {

	public String[] toInputArray(String input) {
		return input.split(";");
	}

	public String[] toValueArray(String input) {
		return input.split(",");
	}
}
