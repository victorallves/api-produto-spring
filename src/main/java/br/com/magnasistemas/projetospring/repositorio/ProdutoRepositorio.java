package br.com.magnasistemas.projetospring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.magnasistemas.projetospring.entidades.ProdutoEntidade;

public interface ProdutoRepositorio extends JpaRepository<ProdutoEntidade, Long> {

}
