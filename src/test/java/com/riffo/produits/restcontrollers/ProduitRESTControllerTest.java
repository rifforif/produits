package com.riffo.produits.restcontrollers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.riffo.produits.model.Produit;
import com.riffo.produits.repos.ProduitRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProduitRESTControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    public void testGetAllProduits() {
        ResponseEntity<Produit[]> response = restTemplate.getForEntity("/api/", Produit[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).extracting(Produit::getNomProduit).contains("PC Asus");
    }

    @Test
    public void testGetProduit() {
        Produit prod = produitRepository.save(new Produit("PC Asus", new java.util.Date(), 100.0));
        ResponseEntity<Produit> response = restTemplate.getForEntity("/api/" + prod.getIdProduit(), Produit.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getNomProduit()).isEqualTo("PC Asus");
    }

    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PC Asus", new java.util.Date(), 1500.0);
        ResponseEntity<Produit> response = restTemplate.postForEntity("/api/", prod, Produit.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getNomProduit()).isEqualTo("PC Asus");
    }

    @Test
    public void testUpdateProduit() {
        Produit prod = produitRepository.save(new Produit("PC Asus", new java.util.Date(), 100.0));
        prod.setPrixProduit(200.0);
        restTemplate.put("/api/", prod);
        Produit updatedProd = produitRepository.findById(prod.getIdProduit()).get();
        assertThat(updatedProd.getPrixProduit()).isEqualTo(200.0);
    }

    @Test
    public void testDeleteProduit() {
        Produit prod = produitRepository.save(new Produit("PC Asus", new java.util.Date(), 100.0));
        restTemplate.delete("/api/" + prod.getIdProduit());
        assertThat(produitRepository.findById(prod.getIdProduit())).isEmpty();
    }
}
