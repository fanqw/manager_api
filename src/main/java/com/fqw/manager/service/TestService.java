package com.fqw.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fqw.manager.dao.Test;
import com.fqw.manager.vo.FamilyGroup;

@Service
public class TestService {
	@Autowired
	private Test test;

	public List<FamilyGroup> getFa() {
		return test.getFamily();
	}
}
