package br.com.sinensis.service;

import br.com.sinensis.model.AgriculturalMachine;
import br.com.sinensis.model.AgriculturalOperation;
import br.com.sinensis.model.Farm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationalSizingServiceTest {

    @Test
    void shouldCalculateSprayerFleetCorrectly() {

        AgriculturalMachine machine =
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
                        18000,
                        29,
                        6
                );

        OperationalSizingService service = new OperationalSizingService();

        var result = service.sizeFleet(operation, machine);

        assertEquals(57.60, result.getTheoreticalCapacityHaPerHour(), 0.001);
        assertEquals(46.08, result.getEffectiveCapacityHaPerHour(), 0.001);
        assertEquals(39.168, result.getPlanningCapacityHaPerHour(), 0.001);
        assertEquals(174.0, result.getGrossAvailableHours(), 0.001);
        assertEquals(6815.232, result.getAreaCapacityPerMachineHa(), 0.001);
        assertEquals(3, result.getRequiredMachines());
    }

    @Test
    void shouldRejectInvalidMachineEfficiency() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalMachine("John Deere", "230M", 36, 16, 1.20, 0.85)
        );
    }

    @Test
    void shouldRejectEmptyFarmName() {
        assertThrows(IllegalArgumentException.class, () -> new Farm("", 1000));
    }

    @Test
    void shouldRejectNonPositiveFarmArea() {
        assertThrows(IllegalArgumentException.class, () -> new Farm("Fazenda", 0));
    }

    @Test
    void shouldRejectNonPositiveMachineWidth() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalMachine("John Deere", "X", 0, 10, 0.8, 0.9)
        );
    }

    @Test
    void shouldRejectNonPositiveMachineSpeed() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalMachine("John Deere", "X", 3, 0, 0.8, 0.9)
        );
    }

    @Test
    void shouldRejectFieldEfficiencyLessOrEqualZero() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalMachine("John Deere", "X", 3, 10, 0.0, 0.9)
        );
    }

    @Test
    void shouldRejectFieldEfficiencyGreaterThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalMachine("John Deere", "X", 3, 10, 1.1, 0.9)
        );
    }

    @Test
    void shouldRejectMechanicalAvailabilityLessOrEqualZero() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalMachine("John Deere", "X", 3, 10, 0.8, 0.0)
        );
    }

    @Test
    void shouldRejectMechanicalAvailabilityGreaterThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalMachine("John Deere", "X", 3, 10, 0.8, 1.5)
        );
    }

    @Test
    void shouldRejectOperationWithNonPositiveArea() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalOperation("Op", 0, 10, 6)
        );
    }

    @Test
    void shouldRejectOperationWithNonPositiveDays() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalOperation("Op", 100, 0, 6)
        );
    }

    @Test
    void shouldRejectOperationWithInvalidWorkingHoursPerDayZero() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalOperation("Op", 100, 10, 0)
        );
    }

    @Test
    void shouldRejectOperationWithInvalidWorkingHoursPerDayGreater24() {
        assertThrows(IllegalArgumentException.class, () ->
                new AgriculturalOperation("Op", 100, 10, 25)
        );
    }

    @Test
    void shouldRejectNullOperationInSizing() {
        AgriculturalMachine machine = new AgriculturalMachine("John Deere", "230M", 36, 16, 0.8, 0.85);
        OperationalSizingService service = new OperationalSizingService();
        assertThrows(IllegalArgumentException.class, () -> service.sizeFleet(null, machine));
    }

    @Test
    void shouldRejectNullMachineInSizing() {
        AgriculturalOperation operation = new AgriculturalOperation("Op", 100, 10, 6);
        OperationalSizingService service = new OperationalSizingService();
        assertThrows(IllegalArgumentException.class, () -> service.sizeFleet(operation, null));
    }
}
