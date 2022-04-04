package com.loja_virtual.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loja_virtual.Model.ProdutoModel;
import com.loja_virtual.Model.UsuarioModel;
import com.loja_virtual.Repository.ProdutoRepository;
import com.loja_virtual.Repository.UsuarioRepository;

@RestController
public class LojaController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@PostMapping("/cadUsuario")
	public ResponseEntity<UsuarioModel>saveProduto(@RequestBody UsuarioModel usuario){
		return new ResponseEntity<UsuarioModel>(usuarioRepository.save(usuario), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioModel>getOneUsuario(@PathVariable(value = "id")long id ){
		Optional<UsuarioModel>usuario_full = usuarioRepository.findById(id);
		if(!usuario_full.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<UsuarioModel>(usuario_full.get(), HttpStatus.OK);
		}
	}
	
	
	@PutMapping("/senha/{id}")
	public ResponseEntity<UsuarioModel> updateSenhaUsuario(@PathVariable(value="id") long id, @RequestBody UsuarioModel usuario) {
		Optional<UsuarioModel> senha = usuarioRepository.findById(id);
		if(!senha.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			usuario.setSenha(senha.get().getSenha());
			return new ResponseEntity<UsuarioModel>(usuarioRepository.save(usuario),HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/produtos")
	public ResponseEntity<List<ProdutoModel>>getAllProdutos(){
		List<ProdutoModel>produtoList = produtoRepository.findAll();
		if(produtoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<ProdutoModel>>(produtoList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<ProdutoModel>getOneProduto(@PathVariable(value = "id")long id){
		Optional<ProdutoModel>produtOO = produtoRepository.findById(id);
		if(!produtOO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<ProdutoModel>(produtOO.get(), HttpStatus.OK);
		}
	}
	
	
	@PostMapping("/cadProduto")
	public ResponseEntity<ProdutoModel>saveProduto(@RequestBody ProdutoModel produto){
		return new ResponseEntity<ProdutoModel>(produtoRepository.save(produto), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/produto/{id}")
	public ResponseEntity<ProdutoModel>updateProduto(@PathVariable(value="id") long id, @RequestBody ProdutoModel produto) {
		Optional<ProdutoModel> produtOO = produtoRepository.findById(id);
		if(!produtOO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			produto.setId_produto(produtOO.get().getId_produto());
			return new ResponseEntity<ProdutoModel>(produtoRepository.save(produto),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<?>deleteProduto(@PathVariable(value="id") long id){
		Optional<ProdutoModel>produtOO = produtoRepository.findById(id);
		if(!produtOO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			produtoRepository.delete(produtOO.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
