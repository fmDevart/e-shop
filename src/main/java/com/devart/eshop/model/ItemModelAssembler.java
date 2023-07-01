package com.devart.eshop.model;

import com.devart.eshop.entities.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
public class ItemModelAssembler implements RepresentationModelAssembler<Item, ItemModel> {
    @Override
    public ItemModel toModel(Item entity) {
         ItemModel model = new ItemModel();
        BeanUtils.copyProperties(entity,model);
        return model;

    }
}
