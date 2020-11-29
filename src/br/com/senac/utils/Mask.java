package br.com.senac.utils;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Mask {

    DefaultFormatterFactory format;

    public MaskFormatter maskCep(JFormattedTextField textField) throws ParseException {
        MaskFormatter mask;
        mask = new MaskFormatter("#####-###");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        format = new DefaultFormatterFactory(mask);
        textField.setFormatterFactory(format);
        return mask;
    }
    public MaskFormatter maskCpf(JFormattedTextField textField) throws ParseException{
        MaskFormatter mask;
        mask = new MaskFormatter("###.###.###-##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        format = new DefaultFormatterFactory(mask);
        textField.setFormatterFactory(format);
        return mask;
    }
    public MaskFormatter maskData(JFormattedTextField textField) throws ParseException{
        MaskFormatter mask;
        mask = new MaskFormatter("##/##/####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        format = new DefaultFormatterFactory(mask);
        textField.setFormatterFactory(format);
        return mask;
    }
}
