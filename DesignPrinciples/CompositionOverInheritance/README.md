# Composition Over Inheritance — Favor Flexibility Over Hierarchy

> **Definition:** Prefer **composition** (combining small, focused classes) over **inheritance** (extending large hierarchies) to achieve flexibility and reusability.

---

## 🚫 Common Mistake

Developers often rely too heavily on inheritance to share behavior — creating rigid and tightly coupled class hierarchies.

```java
// Violation: Using inheritance to share behavior
public class Report {
    public void generate() {
        System.out.println("Generating base report...");
    }
}

public class PDFReport extends Report {
    public void exportPDF() {
        generate();
        System.out.println("Exporting report as PDF...");
    }
}

public class ExcelReport extends Report {
    public void exportExcel() {
        generate();
        System.out.println("Exporting report as Excel...");
    }
}
```

🔴 **Issue:**  
- Adding new export formats (like CSV or HTML) forces new subclasses.  
- Common logic (generate) is coupled to a parent that may not scale.  
- Difficult to modify without breaking existing subclasses.

---

## ✅ Correct Approach

Use **composition** — combine small, dedicated classes instead of rigid inheritance chains.

```java
// Composition-based approach
public interface ExportStrategy {
    void export(String content);
}

public class PDFExportStrategy implements ExportStrategy {
    public void export(String content) {
        System.out.println("Exporting as PDF: " + content);
    }
}

public class ExcelExportStrategy implements ExportStrategy {
    public void export(String content) {
        System.out.println("Exporting as Excel: " + content);
    }
}

public class ReportGenerator {
    private final ExportStrategy exportStrategy;

    public ReportGenerator(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public void generate(String content) {
        System.out.println("Generating report: " + content);
        exportStrategy.export(content);
    }
}

// Client code
public class ClientMain {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new ReportGenerator(new PDFExportStrategy());
        pdfReport.generate("Annual Report");

        ReportGenerator excelReport = new ReportGenerator(new ExcelExportStrategy());
        excelReport.generate("Sales Report");
    }
}
```

✅ Each export format is independent — add new formats (CSV, HTML, JSON) without touching existing classes.

---

## 💡 Core Idea

- **Inheritance** is an *“is-a”* relationship. (Rigid, hierarchical)  
- **Composition** is a *“has-a”* relationship. (Flexible, modular)  
- Composition allows runtime flexibility by delegating behavior.  
- You can change behavior without altering existing code.

---

## 🧠 Real-World Analogy

Think of a **smartphone** — it “has” a camera, GPS, and Bluetooth.  
You can upgrade or replace each module independently.  
If the phone *inherited* from a camera, it would lose flexibility.

---

## 💬 When to Apply

Use **composition** when:
- You need to combine multiple independent behaviors.  
- Classes may need to change behavior at runtime.  
- You want to follow **Open/Closed Principle** (extend without modifying).

Avoid **inheritance** when:
- It’s used only for code reuse, not conceptual relationship.  
- Parent classes become too generic or bloated.  
- Changing parent behavior risks breaking all subclasses.

---

## 🧠 Interview Angle

Common questions:
- “What is the difference between inheritance and composition?”  
- “Why is composition preferred in modern design?”  
- “Can you give an example from your project where you replaced inheritance with composition?”  

✅ Mention that composition promotes **flexibility**, **testability**, and **maintainability**, while inheritance often leads to **tight coupling**.

---

## 🏁 One-Liner Summary

> **Composition over Inheritance** promotes modular, reusable, and flexible designs by combining behaviors rather than extending rigid hierarchies.

---

Happy coding! 🚀
