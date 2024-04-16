package Pr2;

public class TextTableRenderer extends AbstractTableRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return renderTable(result, displayOption);
    }

    @Override
    public String renderTable(CalculationResult result, int displayOption) {
        StringBuilder table = new StringBuilder();

        table.append("+-----------------------+\n");
        table.append("|   Parameter   |   Value   |\n");
        table.append("+-----------------------+\n");
        table.append(String.format("|    Parameter1 |  %.2f   |\n", result.getParameter1()));
        table.append(String.format("|    Parameter2 |  %.2f   |\n", result.getParameter2()));
        table.append(String.format("|       Result   |  %.2f   |\n", result.getResult()));
        table.append("+-----------------------+\n");

        return table.toString();
    }
}