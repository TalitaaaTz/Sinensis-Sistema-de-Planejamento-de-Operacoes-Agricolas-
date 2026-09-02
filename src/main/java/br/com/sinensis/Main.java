package br.com.sinensis;

import br.com.sinensis.model.AgriculturalMachine;
import br.com.sinensis.model.AgriculturalOperation;
import br.com.sinensis.model.Farm;
import br.com.sinensis.model.OperationalSizingResult;
import br.com.sinensis.service.OperationalSizingService;

public class Main {

    public static void main(String[] args) {

        Farm farm = new Farm(
                "Fazenda Rosa de Saron",
                18000
        );

        AgriculturalMachine sprayer =
                new AgriculturalMachine(
                        "John Deere",
                        "230M",
                        36,
                        16,
                        0.80,
                        0.85
                );

        AgriculturalOperation operation =
                new AgriculturalOperation(
                        "Pre-planting spraying",
                        farm.getTotalAreaHa(),
                        29,
                        6
                );

        OperationalSizingService sizingService =
                new OperationalSizingService();

        OperationalSizingResult result =
                sizingService.sizeFleet(
                        operation,
                        sprayer
                );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "               SINENSIS"
        );

        System.out.println(
                " Agricultural Operations Planning System"
        );

        System.out.println(
                "========================================"
        );

        System.out.println();

        System.out.println(
                "Farm: " + farm.getName()
        );

        System.out.println(
                "Operation: "
                        + result.getOperationName()
        );

        System.out.println(
                "Machine: "
                        + result.getMachineDescription()
        );

        System.out.println();

        System.out.printf(
                "Area: %.2f ha%n",
                operation.getAreaHa()
        );

        System.out.printf(
                "Available days: %d%n",
                operation.getAvailableDays()
        );

        System.out.printf(
                "Working hours/day: %.2f h%n",
                operation.getWorkingHoursPerDay()
        );

        System.out.println();

        System.out.printf(
                "Theoretical field capacity: %.2f ha/h%n",
                result.getTheoreticalCapacityHaPerHour()
        );

        System.out.printf(
                "Effective field capacity: %.2f ha/h%n",
                result.getEffectiveCapacityHaPerHour()
        );

        System.out.printf(
                "Planning field capacity: %.2f ha/h%n",
                result.getPlanningCapacityHaPerHour()
        );

        System.out.println();

        System.out.printf(
                "Gross available hours: %.2f h%n",
                result.getGrossAvailableHours()
        );

        System.out.printf(
                "Area capacity per machine: %.2f ha%n",
                result.getAreaCapacityPerMachineHa()
        );

        System.out.printf(
                "Exact machines required: %.2f%n",
                result.getExactMachinesRequired()
        );

        System.out.println(
                "Required machines: "
                        + result.getRequiredMachines()
        );

        System.out.println();

        System.out.println(
                "========================================"
        );
    }
}
