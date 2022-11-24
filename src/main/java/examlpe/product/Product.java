package examlpe.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class  Product {
    private boolean broken = false;
}
