package com.goray.service;

import com.goray.member.memberDTO;

public interface Service {
	
	//로그인
	public memberDTO login(memberDTO mdto);
	
	//회원가입
	public void join(memberDTO mdto);

	//회원수정
	public void update(memberDTO mdto);
	
	//회원삭제
	public void delete(memberDTO mdto);
}
