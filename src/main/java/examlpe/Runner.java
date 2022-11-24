package examlpe;

import examlpe.buyer.BuyerPetrovich;
import examlpe.buyer.BuyerRishar;
import examlpe.config.MyConfig;
import examlpe.product.Product;
import examlpe.provider.ProviderAbsolut;
import examlpe.provider.ProviderAist;
import examlpe.storage.Storage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Runner {
        public static void main(String[] args) {
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

                Storage storage = context.getBean(Storage.class);
                ProviderAbsolut absolut = context.getBean(ProviderAbsolut.class);
                ProviderAist aist = context.getBean(ProviderAist.class);
                BuyerRishar rishar = context.getBean(BuyerRishar.class);
                BuyerPetrovich petrovich = context.getBean(BuyerPetrovich.class);

                storage.addProduct(absolut);
                storage.addProduct(aist);
                storage.addProduct(absolut);
                storage.addProduct(aist);

                List<Product> products = storage.getStorageProduct().get("Vodka");
                System.out.println("Vodka:");
                products.forEach((a)->System.out.println(a));
                System.out.println("Bicycle:");
                products = storage.getStorageProduct().get("Bicycle");
                products.forEach((a)->System.out.println(a));

                storage.giveProduct(rishar);
                storage.giveProduct(petrovich);

                products = storage.getStorageProduct().get("Vodka");
                System.out.println("Vodka Sklad:");
                products.forEach((a)->System.out.println(a));
                System.out.println("Bicycle Sklad:");
                products = storage.getStorageProduct().get("Bicycle");
                products.forEach((a)->System.out.println(a));

                System.out.println("Vodka Petrovich:");
                products = petrovich.getProduct();
                products.forEach((a)->System.out.println(a));

                System.out.println("Bicycle Rishar:");
                products = rishar.getProduct();
                products.forEach((a)->System.out.println(a));


        }
}
