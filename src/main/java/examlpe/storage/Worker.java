package examlpe.storage;

import examlpe.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@Scope("prototype")
public class Worker {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    //получение товара на склад
    public void receptionProduct(List<Product> supplyProduct){

            for (int i = 0; i < supplyProduct.size(); i++) {
            if(i % 2 != 0){
                breakProduct(supplyProduct.get(i));
            }
        }
    }

    //поломка товара
    private void breakProduct(Product product){
        product.setBroken(true);
    }

}
