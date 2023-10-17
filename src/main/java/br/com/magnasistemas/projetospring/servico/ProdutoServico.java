package br.com.magnasistemas.projetospring.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.projetospring.dto.ProdutoDto;
import br.com.magnasistemas.projetospring.entidades.ProdutoEntidade;
import br.com.magnasistemas.projetospring.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	ProdutoRepositorio produtoRepositorio;
	
	public Page<ProdutoDto> listarProdutos(Pageable page) {
		return produtoRepositorio.findAll(page).map(this::converterEntidadeDto);
		
	}
	
	public void criaProduto(ProdutoDto produtoDto) {
		produtoRepositorio.save(converterDtoEntidade(produtoDto));
	}
	
	public ProdutoEntidade converterDtoEntidade(ProdutoDto produtoDto) {
		ProdutoEntidade produtoEntidade = new ProdutoEntidade();
		BeanUtils.copyProperties(produtoDto, produtoEntidade);
		return produtoEntidade;
	}

	public ProdutoDto converterEntidadeDto(ProdutoEntidade produtoEntidade) {
		ProdutoDto produtoDto = new ProdutoDto();
		BeanUtils.copyProperties(produtoEntidade, produtoDto);
		return produtoDto;
	}

	public ProdutoDto listarProdutoPorId(Long produtoId) {
		ProdutoEntidade produtoEntidade = produtoRepositorio.findById(produtoId).orElseThrow(RuntimeException :: new);
		return converterEntidadeDto(produtoEntidade);
	}

	public void deletarProduto(Long produtoId) {
		produtoRepositorio.deleteById(produtoId);
	}

}
