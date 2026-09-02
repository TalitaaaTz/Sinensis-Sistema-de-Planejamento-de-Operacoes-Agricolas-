package br.com.sinensis.model;

public class AgriculturalMachine {

    private final String manufacturer;
    private final String model;

    private final double workingWidthMeters;
    private final double operatingSpeedKmh;

    private final double fieldEfficiency;
    private final double mechanicalAvailability;

    public AgriculturalMachine(
            String manufacturer,
            String model,
            double workingWidthMeters,
            double operatingSpeedKmh,
            double fieldEfficiency,
            double mechanicalAvailability
    ) {

        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException(
                    "Manufacturer cannot be empty."
            );
        }

        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException(
                    "Machine model cannot be empty."
            );
        }

        if (workingWidthMeters <= 0) {
            throw new IllegalArgumentException(
                    "Working width must be greater than zero."
            );
        }

        if (operatingSpeedKmh <= 0) {
            throw new IllegalArgumentException(
                    "Operating speed must be greater than zero."
            );
        }

        if (fieldEfficiency <= 0 || fieldEfficiency > 1) {
            throw new IllegalArgumentException(
                    "Field efficiency must be greater than 0 and less than or equal to 1."
            );
        }

        if (mechanicalAvailability <= 0 || mechanicalAvailability > 1) {
            throw new IllegalArgumentException(
                    "Mechanical availability must be greater than 0 and less than or equal to 1."
            );
        }

        this.manufacturer = manufacturer;
        this.model = model;
        this.workingWidthMeters = workingWidthMeters;
        this.operatingSpeedKmh = operatingSpeedKmh;
        this.fieldEfficiency = fieldEfficiency;
        this.mechanicalAvailability = mechanicalAvailability;
    }

    /**
     * Calculates theoretical field capacity.
     *
     * Formula:
     * CT = (V * L) / 10
     *
     * @return theoretical field capacity in hectares per hour
     */
    public double calculateTheoreticalFieldCapacity() {

        return (operatingSpeedKmh * workingWidthMeters) / 10.0;
    }

    /**
     * Calculates effective field capacity after applying
     * field efficiency.
     *
     * @return effective field capacity in hectares per hour
     */
    public double calculateEffectiveFieldCapacity() {

        return calculateTheoreticalFieldCapacity()
                * fieldEfficiency;
    }

    /**
     * Calculates planning field capacity after applying
     * mechanical availability.
     *
     * Mechanical availability must not be applied again
     * to available hours during fleet sizing.
     *
     * @return planning capacity in hectares per hour
     */
    public double calculatePlanningFieldCapacity() {

        return calculateEffectiveFieldCapacity()
                * mechanicalAvailability;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getWorkingWidthMeters() {
        return workingWidthMeters;
    }

    public double getOperatingSpeedKmh() {
        return operatingSpeedKmh;
    }

    public double getFieldEfficiency() {
        return fieldEfficiency;
    }

    public double getMechanicalAvailability() {
        return mechanicalAvailability;
    }

    public String getDescription() {
        return manufacturer + " " + model;
    }
}
