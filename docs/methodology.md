# Methodology

This document describes the methodology used by SINENSIS v0.1 — Operational Sizing Core.

The goal is to compute, for a given mechanized agricultural operation, how many machines are required to complete the operation within an available time window, considering machine characteristics and operational losses.

Workflow overview:

1. Theoretical field capacity (CT)
   - CT = (V × L) / 10
   - V: operating speed in km/h
   - L: working width in meters
   - Result in hectares per hour (ha/h)

2. Field efficiency (Ec)
   - Represents operational losses during execution (maneuvers, overlaps, refueling, adjustments, internal displacements, interruptions).
   - Expressed as a fraction between 0 and 1 (for example, 80% = 0.80).

3. Effective field capacity (CE)
   - CE = CT × Ec
   - Represents the realistic productivity of the machine while working on the field.

4. Mechanical availability (DM)
   - Fraction between 0 and 1 representing the percentage of time the machine is mechanically capable to operate.
   - This is applied after CE to obtain the planning capacity.

5. Planning field capacity (CP)
   - CP = CE × DM
   - CP is used to estimate the area that a single machine can cover within the planning horizon.

6. Time window
   - grossAvailableHours = availableDays × workingHoursPerDay
   - Do not apply mechanical availability again to the available hours if it was already applied to obtain CP (avoid double counting).

7. Area covered per machine
   - areaCapacityPerMachine = CP × grossAvailableHours

8. Number of machines
   - exactMachinesRequired = operationArea / areaCapacityPerMachine
   - requiredMachines = ceil(exactMachinesRequired)

Notes on separation of concepts

- Field efficiency vs mechanical availability
  - Field efficiency models operational losses during execution (human and process-related interruptions), and is applied to CT to obtain CE.
  - Mechanical availability models the mechanical uptime of the machine and is applied to CE to obtain CP.
  - Keep these factors separate to preserve traceability and avoid mixing different sources of loss.

Rounding and precision

- The system preserves double precision for intermediate calculations.
- Final number of machines must be rounded up to the nearest integer (you cannot have a fraction of machine in the fleet).

This document complements the documentation in the project README and the case study describing the Fazenda Rosa de Saron example.