package word.wrap.kata;

public class Wrapper {

    private static final String BLANK = " ";
    private static final String NEWLINE = "\n";

    public String wrap(final String line, final int maxLineLen) {
        final StringBuilder accumulator = new StringBuilder();
        int pos = 0;
        while (pos + maxLineLen < line.length()) {
            final int indexOfBlank = line.lastIndexOf(BLANK, pos + maxLineLen);
            int split;
            int offset;
            if (indexOfBlank > pos - 1) {
                split = indexOfBlank;
                offset = 1;
            } else {
                split = pos + maxLineLen;
                offset = 0;
            }
            accumulator.append(line.substring(pos, split));
            accumulator.append(NEWLINE);
            pos = split + offset;
        }
        accumulator.append(line.substring(pos));
        return accumulator.toString();
    }
}
