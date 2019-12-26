package com.exam.service;

import com.exam.pojo.Admin;

public interface AdminService {

	Admin login(String id, String password);

	boolean updatePassword(String id, String password, String newpassword);

}
