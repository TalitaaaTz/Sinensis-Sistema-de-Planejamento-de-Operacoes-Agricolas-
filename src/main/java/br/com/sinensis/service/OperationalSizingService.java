package br.com.sinensis.service;

import br.com.sinensis.model.AgriculturalMachine;
import br.com.sinensis.model.AgriculturalOperation;
import br.com.sinensis.model.OperationalSizingResult;

public class OperationalSizingService {

    public OperationalSizingResult sizeFleet(
            AgriculturalOperation operation,
            AgriculturalMachine machine
    ) {

        if (operation == null) {
            throw new IllegalArgumentException(
                    "Operation cannot be null."
            );
        }

        if (machine == null) {
            throw new IllegalArgumentException(
                    "Machine cannot be null."
            );
        }

        double theoreticalCapacity =
                machine.calculateTheoreticalFieldCapacity();

        double effectiveCapacity =
                machine.calculateEffectiveFieldCapacity();

        double planningCapacity =
                machine.calculatePlanningFieldCapacity();

        double grossAvailableHours =
                operation.calculateGrossAvailableHours();

        double areaCapacityPerMachine =
                planningCapacity * grossAvailableHours;

        double exactMachinesRequired =
                operation.getAreaHa()
                        / areaCapacityPerMachine;

        int requiredMachines =
                (int) Math.ceil(exactMachinesRequired);

        return new OperationalSizingResult(
                operation.getName(),
                machine.getDescription(),
                theoreticalCapacity,
                effectiveCapacity,
                planningCapacity,
                grossAvailableHours,
                areaCapacityPerMachine,
                exactMachinesRequired,
                requiredMachines
        );
    }
}
