/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Lakmal
 */
public class Validation {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean validateEmail(JTextField email) {
        Matcher matcher;
        matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email.getText());
        return matcher.find();
    }
    
    public static boolean checkTextField(JTextField text, int length) {
        return text.getText().length() > length;
    }
    
    public static boolean checkPassField(JPasswordField text, int length) {
        return text.getPassword().length > length;
    }
}
