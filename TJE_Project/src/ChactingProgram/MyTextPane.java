package ChactingProgram;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class MyTextPane extends JTextPane {
    private boolean lineWrap;
    
    private String msg;
    private boolean flag;
    public MyTextPane(final boolean lineWrap, String msg, boolean flag) {
        this.lineWrap = lineWrap;
        this.msg = msg;
        this.flag = flag;
        
        if (lineWrap)
            setEditorKit(new WrapEditorKit());
        
        
        
        setEditable(true);
        setFont(new Font("맑은 고딕", Font.PLAIN, 15)); 
        //textpane 이용해서 text에 스타일 주기
        StyledDocument doc = getStyledDocument();
        SimpleAttributeSet left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(left, Color.RED);

        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(right, Color.BLUE);
        
        //boolean 으로 식별
        try {
        	if(flag) {
        		doc.insertString(doc.getLength(),msg, right );
        		doc.setParagraphAttributes(doc.getLength(), 1, right, false);
        	}else if(!flag) {
        		
        		doc.insertString(doc.getLength(), /*"다른사람  :  " +*/ msg, left);
        		doc.setParagraphAttributes(doc.getLength(), 1, left, false);
        	}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
        
        //이미지 사이즈 변경해주는거 따로 뺴놈
//         icon = ResizeImageIcon.resizeImageIcon(path, 70, 70);
//        textPane.insertIcon(icon);
        
        
        
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        if (lineWrap)
            return super.getScrollableTracksViewportWidth();
        else
            return getParent() == null
                  || getUI().getPreferredSize(this).width <= getParent().getSize().width;
    }

    private class WrapEditorKit extends StyledEditorKit {
        private final ViewFactory defaultFactory = new WrapColumnFactory();

        @Override
        public ViewFactory getViewFactory() {
            return defaultFactory;
        }
    }

    private class WrapColumnFactory implements ViewFactory {
        @Override
        public View create(final Element element) {
            final String kind = element.getName();
            if (kind != null) {
                switch (kind) {
                    case AbstractDocument.ContentElementName:
                        return new WrapLabelView(element);
                    case AbstractDocument.ParagraphElementName:
                        return new ParagraphView(element);
                    case AbstractDocument.SectionElementName:
                        return new BoxView(element, View.Y_AXIS);
                    case StyleConstants.ComponentElementName:
                        return new ComponentView(element);
                    case StyleConstants.IconElementName:
                        return new IconView(element);
                }
            }

            // Default to text display.
            return new LabelView(element);
        }
    }

    private class WrapLabelView extends LabelView {
        public WrapLabelView(final Element element) {
            super(element);
        }

        @Override
        public float getMinimumSpan(final int axis) {
            switch (axis) {
                case View.X_AXIS:
                    return 0;
                case View.Y_AXIS:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }
    }
}
