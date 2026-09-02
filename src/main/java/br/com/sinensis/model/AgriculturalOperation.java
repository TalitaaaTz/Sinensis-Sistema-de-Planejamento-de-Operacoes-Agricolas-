package br.com.sinensis.model;

public class AgriculturalOperation {

    private final String name;
    private final double areaHa;

    private final int availableDays;
    private final double workingHoursPerDay;

    public AgriculturalOperation(
            String name,
            double areaHa,
            int availableDays,
            double workingHoursPerDay
    ) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Operation name cannot be empty."
            );
        }

        if (areaHa <= 0) {
            throw new IllegalArgumentException(
                    "Operation area must be greater than zero."
            );
        }

        if (availableDays <= 0) {
            throw new IllegalArgumentException(
                    "Available days must be greater than zero."
            );
        }

        if (workingHoursPerDay <= 0
                || workingHoursPerDay > 24) {

            throw new IllegalArgumentException(
                    "Working hours per day must be between 0 and 24."
            );
        }

        this.name = name;
        this.areaHa = areaHa;
        this.availableDays = availableDays;
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public double calculateGrossAvailableHours() {

        return availableDays * workingHoursPerDay;
    }

    public String getName() {
        return name;
    }

    public double getAreaHa() {
        return areaHa;
    }

    public int getAvailableDays() {
        return availableDays;
    }

    public double getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }
}
