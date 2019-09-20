package com.firstboot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.firstboot.entity.MemberEntity;

@Repository
public class MemberDaoImpl implements MemberDao<MemberEntity> {

	private EntityManager entityManager;

	public MemberDaoImpl() {
		super();
	}

	public MemberDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<MemberEntity> getAll() {
		
		//Query 클래스 : sql로 데이터베이스를 처리하는 쿼리 기능을 가진 클래스
		Query query = entityManager.createQuery("from MemberEntity");
		
		//query 실행 결과를 가져와서 List<> 타입으로 받아준다. 
		List<MemberEntity> list = query.getResultList();
		
		//entity manager를 다 사용한 뒤에는 close() 
		entityManager.close();
		
		return list;
	}

	@Override
	public MemberEntity findByIdx(long idx) {
		
		//1. 실행할 쿼리문 정의 
		Query query = entityManager.createQuery("from MemberEntity where idx="+idx);
		
		//2. 쿼리문 실행 결과 : 1개 
		MemberEntity entity = (MemberEntity) query.getSingleResult();
		
		return entity;
	}

	@Override
	public List<MemberEntity> findByUname(String username) {
		
		//1. 실행할 쿼리문 정의 
		Query query = entityManager.createQuery("from MemberEntity where username='"+username+"'"); 
		
		//2. 뭐리문 실행 결과 
		List<MemberEntity> entities = query.getResultList();
		
		//entity manager를 다 사용한 뒤에는 close() 
		entityManager.close();
		
		return entities;
	}

	/* idx 로 검색하기 
	@Override
	public List<MemberEntity> find(String keyword) {
		
		List<MemberEntity> list = null;
		
		String qstr = "from MemberEntity where idx= :keyword";
		Query query = entityManager.createQuery(qstr).setParameter("keyword", Long.parseLong(keyword));
		
		list = query.getResultList();
		
		return list;
	}*/
	
	/* idx or uname or uid 로 검색하기 
	@Override
	public List<MemberEntity> find(String fstr) {
		System.out.println("데이터 확인 : " + fstr);
		
		List<MemberEntity> list = null;
		
		String qStr = "from MemberEntity where idx= ?1 or uname like ?2 or uid like ?3 ";
		
		Long fidx = 0L;
		
		try {
			fidx = Long.parseLong(fstr);
		} catch (Exception e) {// TODO: handle exception}
		
		Query query = entityManager.createQuery(qStr).setParameter(1, fidx)
		
		.setParameter(2, "%"+fstr+"%").setParameter(3, "%"+fstr);
		
		list = query.getResultList();
		
		return list;
	}*/
	
	/*@Override
	public List<MemberEntity> find(String fstr) {
		List<MemberEntity> list = null;

		String qSql = "from MemberEntity where idx=:fidx "
				+ " or username like :fname "
				+ " or userid like :fid ";

		int fIdx = 0;
		
		try {
		
			fIdx = Integer.parseInt(fstr);
		
		} catch (Exception e) {}

		Query query = entityManager.createQuery(qSql)
				.setParameter("fidx", fIdx)
				.setParameter("fname", "%"+fstr+"%")
				.setParameter("fid", "%"+fstr+"%");

		list = query.getResultList();

		return list;
	}*/
	
	@Override
	public List<MemberEntity> find(String fstr) {
		List<MemberEntity> list = null;

		int fIdx = 0;
		
		try {
		
			fIdx = Integer.parseInt(fstr);
		
		} catch (Exception e) {}
		
		//@Named
		Query query = entityManager.createNamedQuery("findWithParam")
				.setParameter("fidx", fIdx)
				.setParameter("fusername", "%"+fstr+"%")
				.setParameter("fuserid", "%"+fstr+"%");

		list = query.getResultList();

		return list;
	}
	

}
/* JPQL
 * - SQL의 쿼리와 닮은 쿼리문을 실행 해서 데이터베이스를 처리하기 위한 간이 언어 
 * 
 * */