import java.util.Objects;

class SmartphonePrice implements Cloneable {
    private String priceType;
    private double priceInEuros;

    public SmartphonePrice(String priceType, double priceInEuros) {
        this.priceType = priceType;
        this.priceInEuros = priceInEuros;
    }

    @Override
    public String toString() {
        return "SmartphonePrice{" +
                "priceType='" + priceType + '\'' +
                ", priceInEuros=" + priceInEuros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartphonePrice that = (SmartphonePrice) o;
        return Double.compare(that.priceInEuros, priceInEuros) == 0 && Objects.equals(priceType, that.priceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceType, priceInEuros);
    }

    @Override
    public SmartphonePrice clone() throws CloneNotSupportedException {
        SmartphonePrice clonedSmartphonePrice = (SmartphonePrice) super.clone();
        return clonedSmartphonePrice;
    }
}

class Smartphone implements Cloneable {
    private String brandName;
    private String modelName;
    private int batterymAh;
    private SmartphonePrice producerPrice;
    private SmartphonePrice retailPrice;

    public Smartphone(String brandName, String modelName, int batterymAh, SmartphonePrice producerPrice, SmartphonePrice retailPrice) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.batterymAh = batterymAh;
        this.producerPrice = producerPrice;
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", batterymAh=" + batterymAh +
                ", producerPrice=" + producerPrice +
                ", retailPrice=" + retailPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone smartphone = (Smartphone) o;
        return batterymAh == smartphone.batterymAh && Objects.equals(brandName, smartphone.brandName) && Objects.equals(modelName, smartphone.modelName) && Objects.equals(producerPrice, smartphone.producerPrice) && Objects.equals(retailPrice, smartphone.retailPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelName, batterymAh, producerPrice, retailPrice);
    }

    @Override
    public Smartphone clone() throws CloneNotSupportedException {
        Smartphone clonedSmartphone = (Smartphone) super.clone();
        clonedSmartphone.producerPrice = producerPrice.clone();
        clonedSmartphone.retailPrice = retailPrice.clone();
        return clonedSmartphone;
    }
}

public class SmartphoneTester {
    public static void main(String[] args) {
        SmartphonePrice producerPrice1 = new SmartphonePrice("Producer", 100.0);
        SmartphonePrice producerPrice2 = new SmartphonePrice("Producer", 100.0);
        SmartphonePrice retailPrice1 = new SmartphonePrice("Retail", 150.0);
        SmartphonePrice retailPrice2 = new SmartphonePrice("Retail", 150.0);

        Smartphone smartphone1 = new Smartphone("Brand A", "Model A", 3000, producerPrice1, retailPrice1);
        Smartphone smartphone2 = new Smartphone("Brand B", "Model B", 4000, producerPrice2, retailPrice2);

        System.out.println("Smartphone 1: " + smartphone1);
        System.out.println("Smartphone 2: " + smartphone2);

        if (smartphone1.equals(smartphone2)) {
            System.out.println("Smartphone 1 is equal to Smartphone 2.");
        } else {
            System.out.println("Smartphone 1 is not equal to Smartphone 2.");
        }

        try {
            Smartphone clonedSmartphone = smartphone2.clone();
            System.out.println("Cloned Smartphone: " + clonedSmartphone);

            if (smartphone2.equals(clonedSmartphone)) {
                System.out.println("Smartphone 2 is equal to the cloned Smartphone.");
            } else {
                System.out.println("Smartphone 2 is not equal to the cloned Smartphone.");
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("Cloning failed.");
        }
    }
}