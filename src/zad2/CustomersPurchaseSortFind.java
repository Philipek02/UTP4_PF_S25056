/**
 *
 *  @author Pańczak Filip S25056
 *
 */

package zad2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomersPurchaseSortFind {
    List<Purchase> purchases;

    public CustomersPurchaseSortFind() {
        purchases = new ArrayList<>();
    }

    public void readFile(String path) {

        List<String> lineList;
        try {
            lineList = Files.readAllLines(Paths.get(path));

        for (String line:
             lineList) {
            List<String> data = new ArrayList<>(Arrays.asList(line.split("[; ]")));
            Purchase purchase = new Purchase(
                    data.get(0),
                    data.get(1),
                    data.get(2),
                    data.get(3),
                    Double.parseDouble(data.get(4)),
                    Double.parseDouble(data.get(5))
            );
            purchases.add(purchase);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSortedBy(String val){
        System.out.println(val + ": ");
        switch (val){
            case "Nazwiska": {
                purchases.sort((o1, o2) -> {
                    if (o1.getNazwisko().equals(o2.getNazwisko())){
                        return o1.getId_klienta().compareTo(o2.getId_klienta());
                    }else {
                        return o1.getNazwisko().compareTo(o2.getNazwisko());
                    }
                });
                break;

            }
            case "Koszty": {
                purchases.sort((o1, o2) -> {
                    double koszty1 = o1.getCena()*o1.getIlosc();
                    double koszty2 = o2.getCena()*o2.getIlosc();

                    if (koszty1 == koszty2){
                        return o1.getId_klienta().compareTo(o2.getId_klienta());
                    }else {
                        return (int)((koszty1-koszty2)*10);
                    }
                });
                break;
            }
        }

        purchases.forEach(System.out::println);
        System.out.println();

    }
    public void showPurchaseFor(String id){
        System.out.println("Klient " + id +": ");
        for (Purchase val:
             purchases) {
            if(val.getId_klienta().equals(id)){
                System.out.println(val);
            }
        }
    }



}
