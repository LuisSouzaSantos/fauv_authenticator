package com.fauv.authenticator.message;

public class UserMessage {

	public static final String VW_ID_FORM = "VW_ID_IS_MANDATORY";
	public static final String PASSWORD_FORM = "PASSWORD_IS_MANDATORY";
	public static final String PASSWORD_CONFIRMATION_FORM = "PASSWORD_CONFIRMATION_IS_MANDATORY";
	public static final String ROLES_FORM = "AT_LEAST_ONE_ROLE_IS_MANDATORY";
	public static final String VW_ID_FORM_SIZE = "VW_ID_MUST_HAVE_A_MINIMUM_OF_7_AND_MAXIMUM_OF_10_CHARACTERS";
	
	public static final String ERROR_DUPLICATE = "DUPLICATE_USER";
	public static final String ERROR_PASSWORD_CONFIRMATION = "WRONG_PASSWORD_CONFIRMATION";
	public static final String ERROR_INVALID_GROUPED_ROLES = "CONSULTANT_CANNOT_BE_ADMIN_IN_THE_SAME_TIME";
}
