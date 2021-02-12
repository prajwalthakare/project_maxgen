package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.dao.dao;

import com.java.entity.User;

public class service {
	@Autowired
	dao mvcd;
	public boolean checklogin(User user) {
		System.out.println("111566");
		// TODO Auto-generated method stub
		boolean result=mvcd.checklogin(user);
		return result;
	}

}
