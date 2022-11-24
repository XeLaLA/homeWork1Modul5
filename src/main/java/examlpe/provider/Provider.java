package examlpe.provider;

import examlpe.product.Product;
import java.util.List;

public abstract class Provider <T extends Product>{
  abstract public List<Product> sellProduct();
}
