package examlpe.storage;

import examlpe.buyer.Buyer;
import examlpe.buyer.BuyerPetrovich;
import examlpe.buyer.BuyerRishar;
import examlpe.product.Product;
import examlpe.provider.Provider;
import examlpe.provider.ProviderAbsolut;
import examlpe.provider.ProviderAist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Setter
@Getter
@ToString

@Component

public class Storage {
    private HashMap <String, List<Product>> storageProduct =new HashMap<>();
    @Autowired
    private Worker misha;
    @Autowired
    private Worker zelya;


    //Отгрузка со склада водки
    private void buyerPetrovich(List<Product> listStorage, List<Product> listBuyer){
        List<Product> tempList = new ArrayList<>();
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).isBroken()) {
                listBuyer.add(listStorage.get(i));
            }
            else {
                tempList.add(listStorage.get(i));
            }
        }
        listStorage.clear();
        listStorage.addAll(tempList);
    }

    //Отгрузка со склада велосипедов
    private void BuyerRishar(List<Product> listStorage, List<Product> listBuyer){
        List<Product> tempList = new ArrayList<>();
        for (int i = 0; i < listStorage.size(); i++) {
            if (!listStorage.get(i).isBroken()) {
                listBuyer.add(listStorage.get(i));
            }
            else {
                tempList.add(listStorage.get(i));
            }
        }
        listStorage.clear();
        listStorage.addAll(tempList);
    }

    //Отгрузка товаров покупетелю
    public void giveProduct(Buyer buyer) {
        List<Product> listBuyer = buyer.getProduct();

        if (buyer.getClass().getSimpleName() == BuyerPetrovich.class.getSimpleName()) {
            List<Product> listStorage = storageProduct.get("Vodka");
            buyerPetrovich(listStorage,listBuyer);
            buyer.setProduct(listBuyer);
            storageProduct.replace("Vodka",listStorage);
        }
        if (buyer.getClass().getSimpleName() == BuyerRishar.class.getSimpleName()) {
            List<Product> listStorage = storageProduct.get("Bicycle");
            BuyerRishar(listStorage, listBuyer);
            buyer.setProduct(listBuyer);
            storageProduct.replace("Bicycle",listStorage);
        }
    }

    //получение на склад товара
    public void addProduct(Provider provider) {
        List<Product> supplyProduct = provider.sellProduct();
        //получение товара на склад
        misha.receptionProduct(supplyProduct);

        if (provider.getClass().getSimpleName() == ProviderAbsolut.class.getSimpleName()) {
            if (storageProduct.containsKey("Vodka")) {
                List<Product> tempList = storageProduct.get("Vodka");
                tempList.addAll(supplyProduct);
                storageProduct.replace("Vodka", tempList);
            } else {
                storageProduct.put("Vodka", supplyProduct);
            }
        }

        if (provider.getClass().getSimpleName() == ProviderAist.class.getSimpleName()) {
            if (provider.getClass().getSimpleName() == ProviderAist.class.getSimpleName()) {
                if (storageProduct.containsKey("Bicycle")) {
                    List<Product> tempList = storageProduct.get("Bicycle");
                    tempList.addAll(supplyProduct);
                    storageProduct.replace("Bicycle", tempList);
                } else {
                    storageProduct.put("Bicycle", supplyProduct);
                }
            }
        }
    }
}
