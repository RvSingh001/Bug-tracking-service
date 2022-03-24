package com.bugtracking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ApplicationProperty {

	@Autowired
	private Environment environment;

	public String getTokenSecret() {
		return environment.getProperty("token.secret");
	}

	public String getExpritionTime() {
		return environment.getProperty("token.exparation.in.millis");
	}

	public String getEmailVerificationTokenExpritionTime() {
		return environment.getProperty("email.verification.token.exparation.in.millis");
	}

	public String getTokenPrefix() {
		return environment.getProperty("token.prefix");
	}

	public String getSignupUrl() {
		return environment.getProperty("signup.url");
	}

	public String getHeaderString() {
		return environment.getProperty("header.string");
	}

}
