package com.goray.service;

import com.goray.member.memberDTO;

public interface Service {
	
	//�α���
	public memberDTO login(memberDTO mdto);
	
	//ȸ������
	public void join(memberDTO mdto);

	//ȸ������
	public void update(memberDTO mdto);
	
	//ȸ������
	public void delete(memberDTO mdto);
}
