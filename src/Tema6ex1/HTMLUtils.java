package Tema6ex1;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class HTMLUtils {
    private HTMLUtils() {}

    public static List<String> extractLinks(Reader reader) throws IOException {
        final ArrayList<String> list = new ArrayList<String>();

        ParserDelegator parserDelegator = new ParserDelegator();
        ParserCallback parserCallback = new ParserCallback() {
            public void handleText(final char[] data, final int pos) { }
            public void handleStartTag(Tag tag, MutableAttributeSet attribute, int pos) {
                if (tag == Tag.A) {
                    String address = (String) attribute.getAttribute(Attribute.HREF);
                    list.add(address);
                }
            }
            public void handleEndTag(Tag t, final int pos) {  }
            public void handleSimpleTag(Tag t, MutableAttributeSet a, final int pos) { }
            public void handleComment(final char[] data, final int pos) { }
            public void handleError(final java.lang.String errMsg, final int pos) { }
        };
        parserDelegator.parse(reader, parserCallback, false);
        return list;
    }


}