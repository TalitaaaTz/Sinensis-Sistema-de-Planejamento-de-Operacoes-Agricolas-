# Sinensis---Agricultural-Operations-Planning-System
#  Sinensis

### Agricultural Operations Planning System

> **Academic Project — Work in Progress**

Sinensis is an agricultural operations planning system currently under development. The project originated from a practical assignment developed for the **Agricultural Mechanization** course, in which a large-scale corn production scenario was used to study machinery sizing, operational capacity, field efficiency, mechanical availability, agricultural scheduling, and operating costs.

The original academic study was based on the fictional **Rosa de Saron Farm**, a 18,000-hectare corn production scenario located in Timbaúba, Pernambuco, Brazil. The calculations and operational decisions developed during the course provided the foundation for the first version of Sinensis.

Rather than keeping the work only as a static academic report, this project aims to transform its calculations and methodologies into a reusable software system capable of modeling and evaluating agricultural mechanized operations.

##  Project Status

**Sinensis is currently incomplete and under active development.**

The current version represents only the initial core of the project. Some calculations, assumptions, agricultural parameters, documentation, tests, and software components are still being reviewed, validated, or implemented.

Therefore, the current repository should be considered an **academic and experimental software project**, not a production-ready agricultural management system.

The Rosa de Saron Farm is used as the project's first case study, but the long-term goal is to keep the calculation engine generic so that other farms, crops, machinery fleets, and operational scenarios can be modeled in future versions.

---

## Academic Background

The project began as part of a practical assignment for the **Agricultural Mechanization** course.

The original work involved planning the mechanized operations of a hypothetical large-scale agricultural property, including:

- soil preparation;
- subsoiling;
- planting;
- fertilization;
- spraying;
- harvesting;
- machinery sizing;
- operational capacity;
- field efficiency;
- mechanical availability;
- agricultural working windows;
- machinery operating costs.

During the development of the assignment, several calculations were initially performed manually. Sinensis emerged from the idea of converting these calculations into structured, reusable, and testable software.

---

## Project Goal

The main goal of Sinensis is to develop a computational tool for agricultural operational planning.

Instead of manually repeating machinery-sizing calculations for each agricultural operation, the system is intended to receive operational parameters and calculate indicators such as:

- Theoretical Field Capacity;
- Effective Field Capacity;
- Planning Field Capacity;
- available operational time;
- area capacity per machine;
- required fleet size;
- machinery utilization;
- operational costs;
- cost per hectare;
- agricultural scheduling feasibility.

Future versions may also incorporate weather constraints, operational calendars, concurrent field operations, cost analysis, and fleet optimization.

---

## First Case Study — Rosa de Saron Farm

The first case study used by Sinensis comes directly from the Agricultural Mechanization assignment.

### Farm scenario

- **Farm:** Rosa de Saron
- **Location:** Timbaúba, Pernambuco, Brazil
- **Total area:** 18,000 ha
- **Crop:** Corn
- **Production system:** No-tillage
- **Clay soil:** 80%
- **Sandy-loam soil:** 20%
- **Area requiring subsoiling:** 40%
- **Mechanical availability:** 85%

The case study includes the sizing and analysis of machinery for planting, spraying, fertilization, subsoiling, and harvesting.

Rosa de Saron is **not hard-coded as the system itself**. It serves as the initial reference scenario used to validate and demonstrate the calculation models implemented in Sinensis.

---

## Current Development Focus

The current development stage focuses on the operational sizing core.

The first implemented calculations include:

### Theoretical Field Capacity

CT = (V × W) / 10

Where:

- `CT` = Theoretical Field Capacity (ha/h)
- `V` = operating speed (km/h)
- `W` = working width (m)

### Effective Field Capacity

CE = CT × Ef

Where:

- `CE` = Effective Field Capacity (ha/h)
- `Ef` = field efficiency

### Planning Field Capacity

CP = CE × Ma

Where:

- `CP` = Planning Field Capacity (ha/h)
- `Ma` = mechanical availability

Field efficiency and mechanical availability are intentionally treated as separate parameters because they represent different sources of operational loss.

---

## Technology

The current version uses:

- Java 21
- Maven
- JUnit 5

The project intentionally starts with a small architecture before introducing frameworks or infrastructure that are not yet necessary.

---

## Current Architecture

```text
src/
├── main/
│   └── java/
│       └── br/com/sinensis/
│           ├── Main.java
│           ├── model/
│           │   ├── Farm.java
│           │   ├── AgriculturalMachine.java
│           │   ├── AgriculturalOperation.java
│           │   └── OperationalSizingResult.java
│           └── service/
│               └── OperationalSizingService.java
│
└── test/
    └── java/
        └── br/com/sinensis/
            └── service/
                └── OperationalSizingServiceTest.java
