# Architecture

SINENSIS v0.1 uses a small and explicit separation of concerns to keep the core mathematical model simple, testable and reusable.

Main packages

- br.com.sinensis.model
  - Contains plain Java objects (POJOs) that represent the domain: Farm, AgriculturalMachine, AgriculturalOperation and OperationalSizingResult.
  - Responsibilities: encapsulate data, validate constructor input and provide read-only accessors.

- br.com.sinensis.service
  - Contains the OperationalSizingService which implements the core business logic for fleet sizing.
  - Responsibilities: orchestrate calculations using model objects, perform input checks and produce a rich result object (OperationalSizingResult).

- br.com.sinensis (root)
  - Contains Main.java, a simple application entrypoint that demonstrates a study case (Fazenda Rosa de Saron).
  - Responsibilities: compose model objects and call the service. The Main class is only for demonstration and must not contain domain logic.

Design rationale

- model ≠ service ≠ Main
  - Models represent data and simple behaviors tightly related to that data (for instance: machine capacity formulas belong to AgriculturalMachine).
  - Services orchestrate domain objects to perform use-case specific calculations (for instance: how many machines are required for an operation).
  - Main composes and demonstrates; it must not host domain logic so the core can be reused in other contexts (CLI, API, UI).

- Keep the core free of frameworks
  - No Spring, no persistence, no external integrations in v0.1. This ensures the mathematical core is easy to test and evolve.

- Tests
  - Unit tests target the OperationalSizingService, validating expected numeric results and input validation behavior.

- Extensibility
  - Future versions can add repository, API layer, UI or job scheduling, while keeping the model and service as the single source of truth for calculations.

- Simplicity and traceability
  - Calculations are explicit and documented (JavaDoc in important methods). Exceptions are thrown on invalid input to fail fast and make problems visible during development.