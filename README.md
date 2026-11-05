# Low-Level Design in Java

A learning repository for understanding object-oriented design and applying low-level design (LLD) concepts in Java. It combines concise explanations, code examples, and larger practice problems to help connect design ideas with implementation.

## What You'll Learn

- Object-oriented relationships: association, aggregation, composition, and dependency
- General design principles and the SOLID principles
- Creational, structural, and behavioral design patterns
- How to apply these concepts when modeling larger systems

## Contents

1. **[Object-Oriented Foundations](ClassRelationships/)**
   - [Association](ClassRelationships/Association/)
   - [Aggregation](ClassRelationships/Aggregation/)
   - [Composition](ClassRelationships/Composition/)
   - [Dependency](ClassRelationships/Dependency/)
2. **[Design Principles](DesignPrinciples/)**
   - [KISS](DesignPrinciples/%20KISS/)
   - [DRY](DesignPrinciples/DRY/)
   - [YAGNI](DesignPrinciples/YAGNI/)
   - [Composition Over Inheritance](DesignPrinciples/CompositionOverInheritance/)
   - [Encapsulate What Varies](DesignPrinciples/EncapsulateWhatVaries/)
   - [Fail Fast](DesignPrinciples/FailFast/)
   - [Favor Immutability](DesignPrinciples/FavorImmutability/)
   - [High Cohesion, Low Coupling](DesignPrinciples/HighCohesionLowCoupling/)
   - [Law of Demeter](DesignPrinciples/LawOfDemeter/)
   - [Principle of Least Astonishment](DesignPrinciples/PrincipleOfLeastAstonishment/)
   - [Program to Interfaces](DesignPrinciples/ProgramToInterfaces/)
   - [Separation of Concerns](DesignPrinciples/SeparationOfConcerns/)
3. **[SOLID Principles](SOLIDPrinciples/)**
   - [Single Responsibility](SOLIDPrinciples/SingleResponsibilityPrinciple/)
   - [Open/Closed](SOLIDPrinciples/OpenClosedPrinciple/)
   - [Liskov Substitution](SOLIDPrinciples/LiskovSubstitutionPrinciple/)
   - [Interface Segregation](SOLIDPrinciples/InterfaceSegregationPrinciple/)
   - [Dependency Inversion](SOLIDPrinciples/DependencyInversionPrinciple/)
4. **[Design Patterns](DesignPatterns/)**
   - **[Creational](DesignPatterns/CreationalPattern/):** [Abstract Factory](DesignPatterns/CreationalPattern/AbstractFactory/), [Builder](DesignPatterns/CreationalPattern/Builder/), [Factory](DesignPatterns/CreationalPattern/Factory/), [Prototype](DesignPatterns/CreationalPattern/Prototype/), [Singleton](DesignPatterns/CreationalPattern/Singleton/)
   - **[Structural](DesignPatterns/StructuralPattern/):** [Adapter](DesignPatterns/StructuralPattern/Adapter/), [Composite](DesignPatterns/StructuralPattern/Composite/), [Decorator](DesignPatterns/StructuralPattern/Decorator/), [Facade](DesignPatterns/StructuralPattern/Facade/), [Proxy](DesignPatterns/StructuralPattern/Proxy/)
   - **[Behavioral](DesignPatterns/BehavioralPattern/):** [Command](DesignPatterns/BehavioralPattern/Command/), [Iterator](DesignPatterns/BehavioralPattern/Iterator/), [Observer](DesignPatterns/BehavioralPattern/Observer/), [State](DesignPatterns/BehavioralPattern/State/), [Strategy](DesignPatterns/BehavioralPattern/Strategy/)
5. **[LLD Practice Problems](PracticeProblems/)**
6. **[UML Diagrams for Design Patterns and SOLID Principles](assets/uml-images/)**
   - [Design Pattern diagrams](assets/uml-images/design-patterns-uml/)
   - [SOLID diagrams](assets/uml-images/solid-umls/)

## Practice Problems

Explore complete LLD examples, including:

- [ATM](PracticeProblems/src/main/java/com/lld/practice/ATMMachine/) - [UML](PracticeProblems/src/main/java/com/lld/practice/ATMMachine/ATMMachineUML.svg)
- [BookMyShow](PracticeProblems/src/main/java/com/lld/practice/BookMyShow/) - [UML](PracticeProblems/src/main/java/com/lld/practice/BookMyShow/BookMyShowUML.svg)
- [Car Rental](PracticeProblems/src/main/java/com/lld/practice/CarRental/) - [UML](PracticeProblems/src/main/java/com/lld/practice/CarRental/CarRentalUML.svg)
- [Chess](PracticeProblems/src/main/java/com/lld/practice/Chess/) - [UML](PracticeProblems/src/main/java/com/lld/practice/Chess/ChessUML.svg)
- [HashMap](PracticeProblems/src/main/java/com/lld/practice/HashMap/)
- [Logger](PracticeProblems/src/main/java/com/lld/practice/Logger/) - [UML](PracticeProblems/src/main/java/com/lld/practice/Logger/LoggerUML.svg)
- [Parking Lot](PracticeProblems/src/main/java/com/lld/practice/ParkingLot/) - [UML](PracticeProblems/src/main/java/com/lld/practice/ParkingLot/ParkingLotUML.svg)
- [Snake and Ladders](PracticeProblems/src/main/java/com/lld/practice/SnakeAndLadders/) - [UML](PracticeProblems/src/main/java/com/lld/practice/SnakeAndLadders/SnakeAndLaddersUML.svg)
- [Splitwise](PracticeProblems/src/main/java/com/lld/practice/SplitWise/) - [UML](PracticeProblems/src/main/java/com/lld/practice/SplitWise/SplitwiseUML.svg)
- [Tic-Tac-Toe](PracticeProblems/src/main/java/com/lld/practice/TicTacToe/) - [UML](PracticeProblems/src/main/java/com/lld/practice/TicTacToe/TicTacToeUML.svg)

Examples are organized by responsibility, with packages such as models, services, repositories, factories, and strategies where appropriate. This makes it easier to see how the parts of each design fit together. UML diagrams are included for most practice problems.

## Suggested Learning Order

1. Start with [ClassRelationships](ClassRelationships/) to review object-oriented fundamentals.
2. Read [DesignPrinciples](DesignPrinciples/) and [SOLIDPrinciples](SOLIDPrinciples/).
3. Study patterns in [DesignPatterns](DesignPatterns/), beginning with the pattern family or topic you need.
4. Apply what you have learned to the exercises in [PracticeProblems](PracticeProblems/).

For each topic, read its README first. Where both `Problem` and `Solution` examples are provided, compare them to understand the design trade-offs before reviewing the implementation.

## Running the Java Examples

The project uses Maven and requires JDK 21 or later.

```bash
mvn test
```

This compiles the Java sources configured for the project. Individual examples may also be run from an IDE by opening the relevant source and running its main class.
