package br.com.sinensis.model;

public class Farm {

    private final String name;
    private final double totalAreaHa;

    public Farm(String name, double totalAreaHa) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Farm name cannot be empty."
            );
        }

        if (totalAreaHa <= 0) {
            throw new IllegalArgumentException(
                    "Farm area must be greater than zero."
            );
        }

        this.name = name;
        this.totalAreaHa = totalAreaHa;
    }

    public String getName() {
        return name;
    }

    public double getTotalAreaHa() {
        return totalAreaHa;
    }
}
