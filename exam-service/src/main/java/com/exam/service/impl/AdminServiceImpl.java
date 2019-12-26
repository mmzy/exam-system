package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.AdminMapper;
import com.exam.pojo.Admin;
import com.exam.pojo.AdminExample;
import com.exam.pojo.AdminExample.Criteria;
import com.exam.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin login(String id, String password) {
		
		Admin admin = adminMapper.selectByPrimaryKey(id);
		
		if (admin != null){
			if (admin.getPassword().equals(password)){
				return admin;
			}
		}
		
		return null;
	}

	@Override
	public boolean updatePassword(String id, String password, String newpassword) {
		
		Admin admin = adminMapper.selectByPrimaryKey(id);
		if (admin != null){
			if (admin.getPassword().equals(password)){
				admin.setPassword(newpassword);
				AdminExample example = new AdminExample();
				Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(id);
				adminMapper.updateByExample(admin, example);
				return true;
			}
		}
		return false;
		
	}

	
	
}
