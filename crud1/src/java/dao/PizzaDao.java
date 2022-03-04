package dao;

import Model.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PizzaDao implements PizzaDaoInterface {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addPizza(Pizza p) {
        em.persist(p);
    }

    @Override
    public void deletePizza(int id) {
        Pizza p = em.find(Pizza.class, id);
        em.remove(p);
    }

    @Override
    public List<Pizza> getAllPizzas() {

        return em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
    }

    @Override
    public void updatePizza(Pizza p) {
        em.merge(p);
    }

    @Override
    public Pizza getPizza(int id) {
        return em.find(Pizza.class, id);
    }
}
