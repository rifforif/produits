package com.riffo.produits.restcontrollers;

import com.riffo.produits.model.Produit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riffo.produits.service.ProduitService;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ProduitRESTController {

	@Autowired
	ProduitService produitService;

	@GetMapping()
	public List<Produit> getAllProduits() {
		return produitService.getAllProduits();
	}

	@GetMapping("/{id}")
	public Produit getProduit(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}

	@PostMapping()
	public Produit createProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
	}

	@PutMapping()
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}

	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduitById(id);
	}

}
