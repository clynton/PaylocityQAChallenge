package utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmployeeFeeCalculator {

    // assumptions (but can send in as data variables)
    // BigDecimal perPaycheckPayment = new BigDecimal(2000); // not needed
    private static BigDecimal numPayChecksPerYear = new BigDecimal(26);
    private static BigDecimal costOfEmployeeBenefitsPerYear = new BigDecimal(1000);
    private static BigDecimal costOfPerDependentBenefitsPerYear = new BigDecimal(500);
    // 10% discount means multiple by 90% - could do that different ways...
    private static BigDecimal discountAmout = new BigDecimal("0.90");

    public static double CalculateFee(String firstName, Integer dependents) {
        if (firstName != null && (firstName.startsWith("A") || firstName.startsWith("a"))) {
            // starts with A - return discount
            return CalculateFee(dependents, true);
        } else {
            return CalculateFee(dependents, false);
        }
    }

    public static double CalculateFee(Integer dependents, boolean withDiscount) {

        BigDecimal dependentsCount = new BigDecimal(dependents);

        BigDecimal feeSubTotal = (costOfEmployeeBenefitsPerYear
                .add(costOfPerDependentBenefitsPerYear.multiply(dependentsCount))).divide(numPayChecksPerYear, 2, RoundingMode.HALF_UP);

        logCollector.debug("Cost for self + " + dependents + " dependents = " + feeSubTotal.toString());

        BigDecimal finalCost = feeSubTotal;// Currency.getInstance("USD").

        if (withDiscount) {
            finalCost = finalCost.multiply(discountAmout);
        }

        double returnVal = finalCost.setScale(2, RoundingMode.HALF_UP).doubleValue();

        logCollector.debug("Final cost for self + " + dependents + " dependents = " + returnVal + " (discounted? "
                + withDiscount + ")");

        return returnVal;
    }

}