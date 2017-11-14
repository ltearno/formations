package fr.lteconsulting.training.moviedb.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Ceci est une implémentation générique d'un EJB d'accès aux données (souvent appelé DAO).
 * <p>
 * Il apporte les opérations de base communes à toutes nos entités (Categorie, Fabricant et Produit).
 * <p>
 * Il stocke la classe sur laquelle il travaille dans son attribut 'managedClass'.
 * <p>
 * Les sous-classes concrètes pourront ajouter des méthodes selon les besoins spécifiques.
 *
 * @param <T> Le type que l'EJB gère
 */
@Stateless
public abstract class GestionGenerique<T> {
    @PersistenceContext(unitName = "Catalogue", name = "Catalogue")
    protected EntityManager em;

    private final Class<T> managedClass;
    private final Field idField;

    public GestionGenerique(Class<T> managedClass) throws NoSuchFieldException {
        this.managedClass = managedClass;

        idField = managedClass.getDeclaredField("id");
        idField.setAccessible(true);
    }

    public List<T> findAll() {
        return em.createQuery("select e from " + managedClass.getSimpleName() + " e", managedClass).getResultList();
    }

    public T add(T entity) {
        try {
            if (idField != null && idField.get(entity) == null) {
                em.persist(entity);
                return entity;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

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
