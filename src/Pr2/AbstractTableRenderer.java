package Pr2;

public abstract class AbstractTableRenderer implements CalculationResultRenderer {
    public abstract String renderTable(CalculationResult result, int displayOption);
}