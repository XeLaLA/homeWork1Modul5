package examlpe.provider;

import examlpe.product.Product;
import examlpe.product.Vodka;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderAbsolut extends Provider{
    @Override
    public List<Product>  sellProduct() {
        List<Product> vodkaList = new ArrayList<>();
        vodkaList.add(new Vodka());
        vodkaList.add(new Vodka());
        vodkaList.add(new Vodka());
        return vodkaList;
    }
}
