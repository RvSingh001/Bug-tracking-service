package com.bugtracking.security;

import com.bugtracking.SpringApplicationContext;

public class SecurityConstants {

	private SecurityConstants() {
	}

	private static ApplicationProperty applicationProperty;

	static {
		applicationProperty = (ApplicationProperty) SpringApplicationContext.getBean("applicationProperty");
	}

	public static final String SING_UP_URL = "/api/users/";

	public static final String SWAGGER_URL = "/swagger-ui/index.html?configUrl=/bug/v3/api-docs/swagger-config";

	public static String getTokenSecret() {
		return applicationProperty.getTokenSecret();
	}

	public static int getExpritionTime() {
		return Integer.parseInt(applicationProperty.getExpritionTime());
	}

	public static int getEmailVerificationTokenExpritionTime() {
		return Integer.parseInt(applicationProperty.getEmailVerificationTokenExpritionTime());
	}

	public static String getTokenPrefix() {
		return applicationProperty.getTokenPrefix();
	}

	public static String getSignupUrl() {
		return applicationProperty.getSignupUrl();
	}

	public static String getHeaderString() {
		return applicationProperty.getHeaderString();
	}

}
