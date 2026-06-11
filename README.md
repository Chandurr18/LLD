# Design Patterns

A Java-based low-level design repository for learning software design through examples, comparisons, and interview-style practice problems.

This repo brings together:

- design patterns
- SOLID principles
- core software design principles
- OOP class relationships
- practice LLD problems

Instead of only describing concepts, the repository shows how they look in code. Many topics include both a `Problem` version and a `Solution` version so you can clearly see why the pattern or principle matters.

## Overview

This repository is organized as a learning reference, not a single deployable application.

It is most useful if you want to:

- understand design patterns with Java examples
- revise LLD concepts before interviews
- compare bad design against better design
- connect principles like SOLID with practical implementations
- practice modeling larger systems such as Splitwise or Parking Lot

## What's Inside

| Section | What it contains | Best use |
|---|---|---|
| [DesignPatterns](DesignPatterns/) | Creational, Structural, and Behavioral patterns | Learn reusable object-oriented design solutions |
| [SOLIDPrinciples](SOLIDPrinciples/) | Concrete examples for SRP, OCP, LSP, ISP, DIP | Understand maintainable class design |
| [DesignPrinciples](DesignPrinciples/) | Notes and examples for general engineering principles | Strengthen design thinking beyond patterns |
| [ClassRelationships](ClassRelationships/) | Association, Aggregation, Composition, Dependency | Build strong OOP fundamentals |
| [PracticeProblems](PracticeProblems/) | End-to-end LLD style problems | Apply concepts in larger systems |
| [assets](assets/) | UML images used by topic docs | Visual support for learning |

## Pattern Coverage

### Creational Patterns

- [Abstract Factory](DesignPatterns/CreationalPattern/AbstractFactory/)
- [Builder](DesignPatterns/CreationalPattern/Builder/)
- [Factory](DesignPatterns/CreationalPattern/Factory/)
- [Prototype](DesignPatterns/CreationalPattern/Prototype/)
- [Singleton](DesignPatterns/CreationalPattern/Singleton/)

### Structural Patterns

- [Adapter](DesignPatterns/StructuralPattern/Adapter/)
- [Composite](DesignPatterns/StructuralPattern/Composite/)
- [Decorator](DesignPatterns/StructuralPattern/Decorator/)
- [Facade](DesignPatterns/StructuralPattern/Facade/)
- [Proxy](DesignPatterns/StructuralPattern/Proxy/)

### Behavioral Patterns

- [Command](DesignPatterns/BehavioralPattern/Command/)
- [Iterator](DesignPatterns/BehavioralPattern/Iterator/)
- [Observer](DesignPatterns/BehavioralPattern/Observer/)
- [State](DesignPatterns/BehavioralPattern/State/)
- [Strategy](DesignPatterns/BehavioralPattern/Strategy/)

## Principles Coverage

### SOLID

- [Single Responsibility Principle](SOLIDPrinciples/SingleResponsibilityPrinciple/)
- [Open/Closed Principle](SOLIDPrinciples/OpenClosedPrinciple/)
- [Liskov Substitution Principle](SOLIDPrinciples/LiskovSubstitutionPrinciple/)
- [Interface Segregation Principle](SOLIDPrinciples/InterfaceSegregationPrinciple/)
- [Dependency Inversion Principle](SOLIDPrinciples/DependencyInversionPrinciple/)

### General Design Principles

- [KISS](DesignPrinciples/%20KISS/)
- [DRY](DesignPrinciples/DRY/)
- [YAGNI](DesignPrinciples/YAGNI/)
- [Composition Over Inheritance](DesignPrinciples/CompositionOverInheritance/)
- [Encapsulate What Varies](DesignPrinciples/EncapsulateWhatVaries/)
- [Fail Fast](DesignPrinciples/FailFast/)
- [Favor Immutability](DesignPrinciples/FavorImmutability/)
- [High Cohesion Low Coupling](DesignPrinciples/HighCohesionLowCoupling/)
- [Law of Demeter](DesignPrinciples/LawOfDemeter/)
- [Program to Interfaces](DesignPrinciples/ProgramToInterfaces/)
- [Separation of Concerns](DesignPrinciples/SeparationOfConcerns/)
- [Principle of Least Astonishment](DesignPrinciples/PrincipleOfLeastAstonishment/)

## OOP Foundations

The [ClassRelationships](ClassRelationships/) folder covers:

- [Association](ClassRelationships/Association/)
- [Aggregation](ClassRelationships/Aggregation/)
- [Composition](ClassRelationships/Composition/)
- [Dependency](ClassRelationships/Dependency/)

If you are new to LLD, this is a good place to start before jumping into patterns.

## Practice Problems

The [PracticeProblems](PracticeProblems/) section includes larger system-design style examples such as:

- [Splitwise System](PracticeProblems/SplitwiseSystem/)
- [Parking Lot System](PracticeProblems/ParkingLotSystem/)
- [Movie Ticket Booking System](PracticeProblems/MovieTicketBookingSystem/)
- [Elevator System](PracticeProblems/ElevetorSystem/)

These are useful for:

- interview preparation
- turning concepts into entities and flows
- identifying where patterns naturally fit into bigger systems

## Repository Structure

```text
Design-Patterns/
|-- assets/
|   `-- uml-images/
|-- ClassRelationships/
|   |-- Aggregation/
|   |-- Association/
|   |-- Composition/
|   `-- Dependency/
|-- DesignPatterns/
|   |-- BehavioralPattern/
|   |-- CreationalPattern/
|   `-- StructuralPattern/
|-- DesignPrinciples/
|-- PracticeProblems/
|-- SOLIDPrinciples/
`-- README.md
```

## How to Use This Repo

### Read by topic

Open a topic folder, read its `README.md`, then inspect the code.

Good starting points:

- [DesignPatterns/CreationalPattern/Factory](DesignPatterns/CreationalPattern/Factory/)
- [DesignPatterns/BehavioralPattern/Strategy](DesignPatterns/BehavioralPattern/Strategy/)
- [DesignPatterns/StructuralPattern/Proxy](DesignPatterns/StructuralPattern/Proxy/)
- [SOLIDPrinciples/OpenClosedPrinciple](SOLIDPrinciples/OpenClosedPrinciple/)

### Compare problem vs solution

Many topics are intentionally split into:

- `Problem`
- `Solution`

This makes it easier to understand:

- what the original design issue was
- why the pattern or principle is needed
- how the improved design reduces coupling or improves extensibility

### Use it as an LLD revision repo

You can also use the repository as a revision checklist:

1. Review relationships
2. Review principles
3. Review SOLID
4. Study pattern families
5. Solve practice problems on your own

## Running the Examples

This repository does not currently use Maven or Gradle at the root. Most examples can be compiled directly with `javac`.

### Recommended setup

- JDK 17 or later
- IntelliJ IDEA, VS Code, or any Java-capable IDE

### Verify Java

```powershell
java -version
javac -version
```

### Example: packaged source

Some examples declare packages and should be compiled to an output directory.

```powershell
javac -d out DesignPatterns\CreationalPattern\Singleton\Solution\*.java
java -cp out CreationalPattern.Singleton.Solution.Client
```

Another example:

```powershell
javac -d out DesignPatterns\BehavioralPattern\Strategy\Solution\*.java
java -cp out BehavioralPattern.Strategy.Solution.Client
```

### Example: default-package source

Some practice files do not declare packages and can be run directly.

```powershell
javac PracticeProblems\ParkingLotSystem\ParkingSystem.java
java -cp PracticeProblems\ParkingLotSystem ParkingSystem
```

If you prefer, run the examples from your IDE by opening the relevant folder and executing the `Client` class or the main class for that topic.

## Suggested Learning Path

If you want a structured path through the repo:

1. Start with [ClassRelationships](ClassRelationships/)
2. Move to [DesignPrinciples](DesignPrinciples/)
3. Study [SOLIDPrinciples](SOLIDPrinciples/)
4. Learn [Creational Patterns](DesignPatterns/CreationalPattern/)
5. Learn [Structural Patterns](DesignPatterns/StructuralPattern/)
6. Learn [Behavioral Patterns](DesignPatterns/BehavioralPattern/)
7. Practice with [PracticeProblems](PracticeProblems/)

## Why This Repo Is Useful

- It is code-first, not theory-only.
- It covers both fundamentals and interview-style applications.
- It uses practical examples instead of abstract textbook placeholders.
- It includes multiple comparisons between rigid and extensible design.
- It groups principles, patterns, and system problems in one place.

## Notes

- Some folders contain only documentation, while others contain runnable Java code.
- Naming is topic-based rather than module-based.
- UML images referenced by topic READMEs live under [assets/uml-images](assets/uml-images/).

## Ideal Audience

This repository is a strong fit for:

- students learning object-oriented design
- engineers preparing for LLD interviews
- developers revising design patterns in Java
- anyone building stronger intuition around extensible software design

## Contributing

Useful contributions could include:

- adding missing design patterns
- adding tests for examples
- standardizing package naming
- introducing a build system
- improving diagrams and documentation
- expanding the practice problem set

## Quick Start

If you only want a short path:

1. Read [DesignPrinciples](DesignPrinciples/)
2. Review [SOLIDPrinciples](SOLIDPrinciples/)
3. Run one creational example
4. Run one structural example
5. Run one behavioral example
6. Attempt one practice problem without looking at the solution first

## Final Takeaway

This repository is a compact Java handbook for low-level design. It connects principles, patterns, relationships, and practice problems so you can move from concept to implementation in one place.

---

## 👨‍💻 Author

Chandra Sekhar Chinthala

---

🔥 Happy Coding!