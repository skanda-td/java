class Product {
    private String attribute1;
    private int attribute2;
    private boolean attribute3;

    // Private constructor to enforce the usage of builder
    private Product(Builder builder) {
        this.attribute1 = builder.attribute1;
        this.attribute2 = builder.attribute2;
        this.attribute3 = builder.attribute3;
    }

    // Builder class
    public static class Builder {
        private String attribute1;
        private int attribute2;
        private boolean attribute3;

        public Builder() {
            // Set default values if needed
        }

        public Builder attribute1(String value) {
            this.attribute1 = value;
            return this;
        }

        public Builder attribute2(int value) {
            this.attribute2 = value;
            return this;
        }

        public Builder attribute3(boolean value) {
            this.attribute3 = value;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product [attribute1=" + attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3 + "]";
    }
}



public class BuilderPattern {
    public static void main(String[] args) {
        Product product = new Product.Builder()
        .attribute1("Value1")
        .attribute2(10)
        .attribute3(true)
        .build();
        
        System.out.println(product);
    }
}