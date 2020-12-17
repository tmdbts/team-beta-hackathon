package org.academiadecodigo.jupiter.controllers.assembler;

import org.academiadecodigo.jupiter.persistance.model.dto.OrderCreationDto;
import org.academiadecodigo.jupiter.persistance.model.dto.PedidoDto;
import org.academiadecodigo.jupiter.persistance.model.dto.RecipeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeToPedidoDto {


    public OrderCreationDto convert(Integer userId, Integer defaultQty, List<RecipeDto> recipeDtoList){
        OrderCreationDto orderCreationDto = new OrderCreationDto();
        for (RecipeDto recipeDto:recipeDtoList){
            PedidoDto pedidoDto = new PedidoDto();
            pedidoDto.setQuantity(defaultQty);
            pedidoDto.setUserId(userId);
            pedidoDto.setRecipe(recipeDto);
            orderCreationDto.addPedido(pedidoDto);
        }
        return orderCreationDto;
    }
}
