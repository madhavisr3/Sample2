package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Stuff;

public class Staffdao {

	EntityManagerFactory e=Persistence.createEntityManagerFactory("dev");
	EntityManager m=e.createEntityManager();
	EntityTransaction t=m.getTransaction();
	public void save(Stuff staff) {
		t.begin();
		m.persist(staff);
		t.commit();
	}


	public Stuff fetchByMobile(long mobile)
	{
	List<Stuff> list=m.createQuery("select x from Staff x where mobile=?1").setParameter(1,mobile).getResultList();
	if(list.isEmpty()) {
		return null;
	}
	else {
		return list.get(0);
	}
	}
	public 	Stuff FetchByEmail(String email)
	{
		List<Stuff> list=m.createQuery("select x from Staff x where email=?1",Stuff.class).setParameter(1,email).getResultList();
		if(list.isEmpty()) {
			return null;
			
		}
		else {
			return list.get(0);
		}
	}

}