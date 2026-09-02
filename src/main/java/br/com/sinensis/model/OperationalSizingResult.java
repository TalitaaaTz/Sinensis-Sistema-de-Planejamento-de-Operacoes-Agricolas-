package br.com.sinensis.model;

public class OperationalSizingResult {

    private final String operationName;
    private final String machineDescription;

    private final double theoreticalCapacityHaPerHour;
    private final double effectiveCapacityHaPerHour;
    private final double planningCapacityHaPerHour;

    private final double grossAvailableHours;
    private final double areaCapacityPerMachineHa;

    private final double exactMachinesRequired;
    private final int requiredMachines;

    public OperationalSizingResult(
            String operationName,
            String machineDescription,
            double theoreticalCapacityHaPerHour,
            double effectiveCapacityHaPerHour,
            double planningCapacityHaPerHour,
            double grossAvailableHours,
            double areaCapacityPerMachineHa,
            double exactMachinesRequired,
            int requiredMachines
    ) {

        this.operationName = operationName;
        this.machineDescription = machineDescription;

        this.theoreticalCapacityHaPerHour =
                theoreticalCapacityHaPerHour;

        this.effectiveCapacityHaPerHour =
                effectiveCapacityHaPerHour;

        this.planningCapacityHaPerHour =
                planningCapacityHaPerHour;

        this.grossAvailableHours =
                grossAvailableHours;

        this.areaCapacityPerMachineHa =
                areaCapacityPerMachineHa;

        this.exactMachinesRequired =
                exactMachinesRequired;

        this.requiredMachines =
                requiredMachines;
    }

    public String getOperationName() {
        return operationName;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public double getTheoreticalCapacityHaPerHour() {
        return theoreticalCapacityHaPerHour;
    }

    public double getEffectiveCapacityHaPerHour() {
        return effectiveCapacityHaPerHour;
    }

    public double getPlanningCapacityHaPerHour() {
        return planningCapacityHaPerHour;
    }

    public double getGrossAvailableHours() {
        return grossAvailableHours;
    }

    public double getAreaCapacityPerMachineHa() {
        return areaCapacityPerMachineHa;
    }

    public double getExactMachinesRequired() {
        return exactMachinesRequired;
    }

    public int getRequiredMachines() {
        return requiredMachines;
    }
}
