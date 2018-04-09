package school.service;

import school.domain.User;

public interface UserService {

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 通过邮箱查找用户
	 * @param email
	 * @return
	 */
	User selectByEmail(String email);
	User selectByUsername(String username);
}