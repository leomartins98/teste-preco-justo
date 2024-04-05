package com.leonardo.duck.dto.response;
import com.leonardo.duck.entity.Duck;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDuckDTO {

    private Long id;

    private String name;

    private Long mae;

    public ResponseDuckDTO(Duck duck) {

        this.id = duck.getId();
        this.name = duck.getName();
        if (duck.getMae() != null) {
            this.mae = duck.getMae().getId();
        } else {
            this.mae = null; // Define como null se a mãe for nula
        }

    }

}
