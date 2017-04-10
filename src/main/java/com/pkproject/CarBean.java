package com.pkproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Component
@ManagedBean
@SessionScoped
public class CarBean {

	@Autowired
	CarDao carDao;

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public List<String> fetchCarDetails() {

		return carDao.getCarDetails();
	}

}
