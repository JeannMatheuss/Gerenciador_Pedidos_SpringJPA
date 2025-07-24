package com.desafio.gerenciador_pedidos;

import com.desafio.gerenciador_pedidos.model.Categoria;
import com.desafio.gerenciador_pedidos.model.Pedido;
import com.desafio.gerenciador_pedidos.model.Produto;
import com.desafio.gerenciador_pedidos.repository.CategoriaRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = new Categoria(1L, "Eletrônicos");
		categoriaRepository.save(categoria);

		Produto produto1 = new Produto("Celular", 4500.0);
		produto1.setCategoria(categoria);

		Produto produto2 = new Produto("Notebook", 6500.0);
		produto2.setCategoria(categoria);

		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		Pedido pedido = new Pedido(1L, LocalDate.now());
		pedido.setProdutos(List.of(produto1, produto2)); // Associando produtos ao pedido

		pedidoRepository.save(pedido);
	}
}
