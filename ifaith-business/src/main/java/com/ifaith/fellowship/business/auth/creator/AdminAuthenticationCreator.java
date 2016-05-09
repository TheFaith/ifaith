package com.ifaith.fellowship.business.auth.creator;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifaith.fellowship.dataaccess.common.RepositoryFactory;
import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.user.AdminUserModel;
import com.ifaith.fellowship.entity.user.SignInModel;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public class AdminAuthenticationCreator implements UserAuthenticationCreator {

	@Autowired
	protected UserRepository repoUser;

	public AdminAuthenticationCreator() {
		this.repoUser = RepositoryFactory.Create(UserRepository.class);
	}

	@Override
	public SignInModel authenticationUser(int userId, int churchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInModel authenticationUser(String userName, String password, String churchCode) throws Exception {
		AdminUserModel model = null;
		UserBasicInfo user = repoUser.findsBy(userName);
		if (user != null && password.equals(user.getPassword())) {
			model = new AdminUserModel();
			model.setUserSysNo(user.getSysNo());
			model.setUserName(user.getName());
			model.setChurchSysNo(8601);
		}
		return model;
	}

}
