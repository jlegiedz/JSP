package sdaLibrary;

import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;

/**
 * Created by RENT on 2017-10-03.
 */
public class ModelAndViewWithMenu extends ModelAndView {

    public ModelAndViewWithMenu(){
        super();
        addObject("menu", Element.values());
    }
}
