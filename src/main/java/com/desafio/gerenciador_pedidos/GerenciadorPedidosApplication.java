package com.desafio.gerenciador_pedidos;

import com.desafio.gerenciador_pedidos.model.Categoria;
import com.desafio.gerenciador_pedidos.model.Fornecedor;
import com.desafio.gerenciador_pedidos.model.Pedido;
import com.desafio.gerenciador_pedidos.model.Produto;
import com.desafio.gerenciador_pedidos.repository.CategoriaRepository;
import com.desafio.gerenciador_pedidos.repository.FornecedorRepository;
import com.desafio.gerenciador_pedidos.repository.PedidoRepository;
import com.desafio.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criando categorias
		Categoria categoriaEletronicos = new Categoria(1L, "Eletrônicos");
		Categoria categoriaLivros = new Categoria(2L, "Livros");
		categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

		// Criando fornecedores
		Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
		Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
		fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));

		// Criando produtos
		Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
		Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
		Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
		produto1.setFornecedor(fornecedorTech);
		produto2.setFornecedor(fornecedorTech);
		produto3.setFornecedor(fornecedorLivros);
		produtoRepository.saveAll(List.of(produto1, produto2, produto3));

		// Criando pedidos e associando produtos
		Pedido pedido1 = new Pedido(1L, LocalDate.now());
		pedido1.setProdutos(List.of(produto1, produto3));
		Pedido pedido2 = new Pedido(2L, LocalDate.now().minusDays(1));
		pedido2.setProdutos(List.of(produto2));
		pedidoRepository.saveAll(List.of(pedido1, pedido2));

		// Testando consultas e verificando os relacionamentos
		System.out.println("Produtos na categoria Eletrônicos:");
		categoriaRepository.findById(1L).ifPresent(categoria ->
				categoria.getProdutos().forEach(produto ->
						System.out.println(" - " + produto.getNome())
				)
		);

		System.out.println("\nPedidos e seus produtos:");
		pedidoRepository.findAll().forEach(pedido -> {
			System.out.println("Pedido " + pedido.getId() + ":");
			pedido.getProdutos().forEach(produto ->
					System.out.println(" - " + produto.getNome())
			);
		});

		System.out.println("\nProdutos e seus fornecedores:");
		produtoRepository.findAll().forEach(produto ->
				System.out.println("Produto: " + produto.getNome() +
						", Fornecedor: " + produto.getFornecedor().getNome())
		);
	}
}
