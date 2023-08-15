package com.vinh.fresherApp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		org.springframework.security.crypto.password.PasswordEncoder pass = new BCryptPasswordEncoder();
		System.out.println(pass.encode("admin"));
		System.out.println(pass.encode("123456789"));

	}

}
