package com.java.ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.dao;
import com.java.entity.Addcard;
import com.java.entity.Stock;
import com.java.entity.User;
@Service
public class service {
	@Autowired
	dao mvcd;
	public boolean checklogin(User user) {
		System.out.println("111566");
		// TODO Auto-generated method stub
		boolean result=mvcd.checklogin(user);
		return result;
	}
	
	
	public List<Stock> getstock() {
		 List<Stock> liststock=mvcd.getstock();
			return liststock;
	}


	public boolean addmed(Stock stock) {
		// TODO Auto-generated method stub
		return mvcd.addmed(stock);
	}


	public boolean deletestock(int stid) {
		// TODO Auto-generated method stub
		return mvcd.deletestock(stid);
	}


	public boolean addcard(Addcard card) {
		// TODO Auto-generated method stub
		return mvcd.addcard(card);
	}


	public List<Addcard> getcard() {
		List<Addcard> listcard=mvcd.getcard();
		return listcard;
	}

}
