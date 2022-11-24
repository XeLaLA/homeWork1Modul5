package examlpe.buyer;

import examlpe.product.Product;
import examlpe.provider.ProviderAbsolut;
import examlpe.storage.Storage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Buyer {
    private List<Product> product = new ArrayList<>();
}
