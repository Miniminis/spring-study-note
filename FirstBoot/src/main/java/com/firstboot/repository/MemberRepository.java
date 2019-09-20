package com.firstboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstboot.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
	//JPA 내부에는 : ‘JPQL’ 이라는 SQL을 간략화한 언어를 내장! 
	//	- 아래에 직접 정의된 구문을 JpaRepository 가 알아서 해석함 
	//1. 기본 구조 : CRUD 지원 
	//2. Repository 내 매서드 직접 정의
	//3. Mapper 직접정의 
	
	public MemberEntity findByIdx(Integer idx);
	public List<MemberEntity> findByUsernameLike(String username); //인자에는 "%"+str+"%" 형태로 지정필요
	public List<MemberEntity> findByIdxBetween(int idx1, int idx2);
}
