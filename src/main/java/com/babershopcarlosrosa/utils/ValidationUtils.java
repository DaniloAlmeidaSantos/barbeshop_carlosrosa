package com.babershopcarlosrosa.utils;

/**
 * 
 * @author Elvis - PC
 *
 */

public class ValidationUtils {

//	** Fica a critério do cliente
//	public static boolean authenticateCpf(String cpf) {
//		
//		if(cpf.matches("[0-9]{11}")) {
//			return true;
//		}
//		return false;
//	}
	
	
	public static boolean authenticateName(String name) {
		
		try {
			if(name.matches("[A-Za-z]{120}")) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
	public static boolean authenticateEmail(String email) {
		
		try {
			
			if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$){11}")) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
	public static boolean authenticatePhone(String telephone) {
		
		try {
			
			if(telephone.matches("[0-9]{11}")) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	
}
