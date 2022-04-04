package com.loja_virtual.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja_virtual.Model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long>{

}
