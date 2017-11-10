package fr.lteconsulting.training.moviedb.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public abstract class GestionGenerique<T> {
    @PersistenceContext(unitName = "Catalogue", name = "Catalogue")
    protected EntityManager em;

    private final Class<T> managedClass;

    public GestionGenerique(Class<T> managedClass) {
        this.managedClass = managedClass;
    }

    public List<T> findAll() {
        return em.createQuery("select e from " + managedClass.getSimpleName() + " e", managedClass).getResultList();
    }

    public T add(T entity) {
        return em.merge(entity);
    }

    public void deleteById(int id) {
        T entity = em.find(managedClass, id);
        if (entity != null)
            em.remove(entity);
    }

    public T findById(int id) {
        return em.find(managedClass, id);
    }

    public T update(T entity) {
        return em.merge(entity);
    }
}
