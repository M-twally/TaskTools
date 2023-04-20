package query;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ejbs.Calculation;

@Stateless
	public class CalculationQ {
	    @PersistenceContext
	    private EntityManager entityManager;

	    public CalculationQ() {
	    }
	    public void insert(Calculation calculation) {
	        entityManager.persist(calculation);
	    }

	    public List<Calculation> selectAll() {
	    	TypedQuery<Calculation> query = entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class);
			 return query.getResultList();
	    }
	}

