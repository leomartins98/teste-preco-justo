package com.leonardo.duck.dto.response;
import com.leonardo.duck.entity.Sale;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSaleDTO {

    private Long id;

    private Float price;

    private Long idDuck;

    private Long idClient;

    public ResponseSaleDTO(Sale sale) {

        this.id = sale.getId();
        this.price = sale.getPrice();
        this.idDuck = sale.getDuck().getId();
        this.idClient = sale.getClient().getId();

    }

}
