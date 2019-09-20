package com.firstboot.repository;

import java.io.Serializable;
import java.util.List;

public interface MemberDao<T> extends Serializable {
	
	public List<T> getAll();

	public T findByIdx(long idx);

	public List<T> findByUname(String name); 
	
	// JPQL 
	public List<T> find(String keyword);

	/*
	 * JpaRepository를 이용하면 - 장점 : 반복적이고 일상적인 쿼리문 코드 작성 없이 구현 가능 - 단점 : 복잡한 검색과 JOIN
	 * 이 필요한 쿼리문은 구현에 어려움이 있음
	 * 
	 * 따라서 복잡한 쿼리문 같은 경우에는
	 * 
	 */

}
