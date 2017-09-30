package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by User on 9/30/2017.
 */
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
    public StrikeThroughAction(String nm) {
        super(nm);
    }

    public StrikeThroughAction() {
        super("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
