package com.loja_virtual.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja_virtual.Model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}
