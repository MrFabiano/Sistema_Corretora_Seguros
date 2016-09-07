package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LowerCase extends PlainDocument {

    private int maxChars;

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str != null && (getLength() + str.length() > maxChars)) {
            str = str.substring(0, maxChars);
        }

        super.insertString(offset, str.toLowerCase(), attr);
    }

    public int getMaxChars() {
        return maxChars;
    }

    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }
}
