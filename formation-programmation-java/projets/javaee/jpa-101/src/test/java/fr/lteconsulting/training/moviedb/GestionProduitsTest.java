package fr.lteconsulting.training.moviedb;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;
import fr.lteconsulting.training.moviedb.ejb.GestionFabricants;
import fr.lteconsulting.training.moviedb.ejb.GestionProduits;
import fr.lteconsulting.training.moviedb.model.Categorie;
import fr.lteconsulting.training.moviedb.model.Produit;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.List;

@RunWith(Arquillian.class)
public class GestionProduitsTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Categorie.class.getPackage())
                .addPackage(GestionCategories.class.getPackage())
                // on inclut POI, ca ne sert pas mais ca vous montre commen ont fait
                .addAsLibraries(Maven.resolver().resolve("org.apache.poi:poi:3.17").withTransitivity().as(JavaArchive.class))
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private GestionCategories gestionCategories;

    @EJB
    private GestionFabricants gestionFabricants;

    @EJB
    private GestionProduits gestionProduits;

    @Before
    public void beforeTest() {
        for (Produit produit : gestionProduits.findAll())
            gestionProduits.deleteById(produit.getId());
    }

    @Test
    public void testRechercheProduits() {
        Produit produit = new Produit();
        produit.setNom("toto");
        gestionProduits.add(produit);

        List<Produit> produits = gestionProduits.findByName("toto");
        Assert.assertNotNull("liste devrait etre non nulle", produits);
        Assert.assertEquals("on devrait en trouver un", 1, produits.size());

        produits = gestionProduits.findByName("tot");
        Assert.assertNotNull("liste devrait etre non nulle", produits);
        Assert.assertEquals("on devrait en trouver un", 1, produits.size());
    }
}
