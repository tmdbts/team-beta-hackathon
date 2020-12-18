package org.academiadecodigo.jupiter.persistance.model.dto;

import org.academiadecodigo.jupiter.persistance.model.cart.Pedidos;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class OrderCreationDto {

    private List<PedidoDto> pedidos;

    public OrderCreationDto(){
        pedidos = new LinkedList<>();
    }

    public void addPedido(PedidoDto pedido) {
        this.pedidos.add(pedido);
    }

    public List<PedidoDto> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDto> pedidos) {
        this.pedidos = pedidos;
    }

}
