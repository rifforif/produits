package com.riffo.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riffo.produits.model.Categorie;
import com.riffo.produits.model.Produit;
import com.riffo.produits.repos.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService{
	
	@Autowired
	ProduitRepository produitRepo;

	@Override
	public Produit saveProduit(Produit p) {
		return produitRepo.save(p);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepo.save(p);
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepo.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepo.deleteById(id);
		
	}

	@Override
	public Produit getProduit(Long id) {
		return produitRepo.findById(id).get();
	}

	@Override
	public List<Produit> getAllProduits() {
		return produitRepo.findAll();
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		// TODO Auto-generated method stub
		return produitRepo.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		// TODO Auto-generated method stub
		return produitRepo.findByNomProduitLike(nom);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return produitRepo.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return produitRepo.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return produitRepo.findByCategorieIdCat(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		// TODO Auto-generated method stub
		return produitRepo.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> trierProduitsNomsPrix() {
		// TODO Auto-generated method stub
		return produitRepo.trierProduitsNomsPrix();
	}

}
