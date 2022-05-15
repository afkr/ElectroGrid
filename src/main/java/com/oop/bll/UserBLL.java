package com.oop.bll;

import java.util.ArrayList;

import com.oop.model.User;
import com.oop.repository.UserRepository;

public class UserBLL {
	
	public void CreateUser(User user) {
		new UserRepository().CreateUser(user);	
	}
	
	public void EditUser(User user) {
		new UserRepository().EditUser(user);
	}
	
	public void DeleteUser(int id) {
		new UserRepository().DeleteUser(id);
	}
	
	public User GetUserByTel(String tel){
		User user= new UserRepository().GetUserByTel(tel);
		return user;
	}

	public ArrayList<User> GetListOfUsers(){
		ArrayList<User> userList = new UserRepository().GetListOfUsers();
		return userList;
	}
	
	public User AuthenticateUser(User user) {
		User isExist = new UserRepository().GetUserByUsernameAndPassword(user.getUsername(), user.getPassword());	
		return isExist;
	}

}
