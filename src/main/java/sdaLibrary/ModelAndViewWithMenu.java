package sdaLibrary;

import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;

public class ModelAndViewWithMenu extends ModelAndView {

    public ModelAndViewWithMenu(){
        super();
        addObject("menu", Element.values());
    }
}
