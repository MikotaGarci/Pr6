package Pr2;

public class TextResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return "Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult();
    }
}