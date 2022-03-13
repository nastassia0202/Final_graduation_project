package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDress {

    protected int id;
    protected String type;
    protected String size;
    protected String color;

}
