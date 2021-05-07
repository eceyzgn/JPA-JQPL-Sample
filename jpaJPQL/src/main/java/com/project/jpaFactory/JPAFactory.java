package com.project.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface JPAFactory {

	EntityManager getEntityManager();
	
	EntityTransaction getTransaction();
}
