package com.goray.member;

import com.goray.service.Service;

public class ServiceImpl implements Service {

	@Override
	public memberDTO login(memberDTO mdto) {
		MemberDAO mdao = new MemberDAO();
		mdto = mdao.login(mdto);
		return null;
	}

	@Override
	public void join(memberDTO mdto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(memberDTO mdto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(memberDTO mdto) {
		// TODO Auto-generated method stub

	}

}
