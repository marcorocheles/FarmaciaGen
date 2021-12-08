package org.generation.blog.controller;

import java.util.List;


import org.generation.blog.model.Produto;
import org.generation.blog.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/produto")
	public class ProdutoController {

		@Autowired
		private ProdutoRepository produtoRepository;
		
		@GetMapping
		public ResponseEntity<List<Produto>> getAll(){
			return ResponseEntity.ok(produtoRepository.findAll());
		}
		
	    @GetMapping("/{id}")
	    public ResponseEntity<Produto> GetById(@PathVariable long id){
	        return produtoRepository.findById(id)
	                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	    }
	 
	    @GetMapping("/nome/{nome}")
	    public ResponseEntity<List<Produto>> GetByDescricao(@PathVariable String nome){
	        return ResponseEntity.ok(produtoRepository. findAllByNomeContainingIgnoreCase(nome));
	    }
	    
	    //post, put e delete
	    
	    @PostMapping
		public ResponseEntity<Produto> post (@RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
		}
	    
	    @PutMapping
		public ResponseEntity<Produto> put (@RequestBody Produto produto){
			return ResponseEntity.ok(produtoRepository.save(produto));
		}
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete (@PathVariable long id) {
	        return produtoRepository.findById(id).map(resposta -> {
	        	produtoRepository.deleteById(id);
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        }).orElse(ResponseEntity.notFound().build());
	    }
}
