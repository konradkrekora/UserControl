package pl.kk.UserControl.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

import static pl.kk.UserControl.Constants.EMAIL_REGEX;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return s.matches(EMAIL_REGEX);
    }
}
