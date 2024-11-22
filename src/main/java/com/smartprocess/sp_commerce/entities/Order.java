

package com.smartprocess.sp_commerce.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name ="tb_order")  //criação da tabela tb_order da classe Order
public class Order {

	@Id //informando que será rastreado pelo id no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//informa o tempo exato da realização do pedido
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	//chama a classe OrderStatus
	private OrderStatus status;
	
	//um pedido pode conter zero ou 1 pagamento (zero quando o pedido é feito mas não foi pago)
	@ManyToOne
	//faz a união da coluna id da classe Order com o id da classe cliente
	@JoinColumn(name = "client_id")
	private User client;
	
	//obrigatório ter um pagamento para cada pedido
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, OrderStatus status, User client) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public List<Product> getProducts() {
		return items.stream().map(x -> x.getProduct()).toList();
		}
	
	
}

