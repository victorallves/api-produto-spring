package br.com.magnasistemas.projetospring.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.magnasistemas.projetospring.dto.ProdutoDto;
import br.com.magnasistemas.projetospring.servico.ProdutoServico;

@Controller
@RequestMapping("/produtos")
public class ProdutoControle {

	@Autowired
	ProdutoServico produtoServico;

	@GetMapping
	public ResponseEntity<Page<ProdutoDto>> listarProdutos(@PageableDefault(size = 5) Pageable page) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoServico.listarProdutos(page));
	}

	@PostMapping
	public ResponseEntity<ProdutoDto> criarProduto(@RequestBody ProdutoDto produtoDto) {
		produtoServico.criaProduto(produtoDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{produtoId}")
	public ResponseEntity<ProdutoDto> deletarProduto(@PathVariable Long produtoId) {
		produtoServico.deletarProduto(produtoId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<ProdutoDto> listarProdutoPorId(@PathVariable Long produtoId) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoServico.listarProdutoPorId(produtoId));
	}

}
