package org.generation.blog.repository;

import java.util.List;

import org.generation.blog.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	//botar o tipo primario para fazer a busca
	public List<Categoria> findAllByCategoriaContainingIgnoreCase (String categoria);
}
