package StructuralPattern.Decorator.Solution;

/**
 * Demonstrates different wrapping orders and resulting costs.
 */
public class Client {
    public static void main(String[] args) {
        Order base = new BasicOrder(1000.0);

        // Case A: Discount -> Tax -> GiftWrap
        Order caseA = new GiftWrapDecorator(new TaxDecorator(new DiscountDecorator(base, 10.0), 18.0));
        System.out.println(caseA.getDescription() + " -> ₹" + caseA.getCost());

        // Case B: Tax -> Discount -> GiftWrap
        Order caseB = new GiftWrapDecorator(new DiscountDecorator(new TaxDecorator(base, 18.0), 10.0));
        System.out.println(caseB.getDescription() + " -> ₹" + caseB.getCost());

        // Case C: GiftWrap -> Discount -> Tax
        Order caseC = new TaxDecorator(new DiscountDecorator(new GiftWrapDecorator(base), 10.0), 18.0);
        System.out.println(caseC.getDescription() + " -> ₹" + caseC.getCost());

        // Case D: Tax -> GiftWrap -> Discount
        Order caseD = new DiscountDecorator(new GiftWrapDecorator(new TaxDecorator(base, 18.0)), 10.0);
        System.out.println(caseD.getDescription() + " -> ₹" + caseD.getCost());
    }
}
