package examlpe.provider;

import examlpe.product.Bicycle;
import examlpe.product.Product;
import examlpe.product.Vodka;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderAist extends Provider{
    @Override
    public List<Product> sellProduct() {
        List<Product> BicycleList = new ArrayList<>();
        BicycleList.add(new Bicycle());
        BicycleList.add(new Bicycle());
        BicycleList.add(new Bicycle());
        return BicycleList;
    }
}
