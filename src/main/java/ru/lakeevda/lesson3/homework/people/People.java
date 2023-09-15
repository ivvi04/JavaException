package ru.lakeevda.lesson3.homework.people;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lakeevda.lesson3.homework.people.exceptions.BirthdayException;
import ru.lakeevda.lesson3.homework.people.exceptions.GenderException;
import ru.lakeevda.lesson3.homework.people.exceptions.PhoneException;
import ru.lakeevda.lesson3.homework.people.exceptions.StringException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class People {
    private String lastName; // Фамилия
    private String firstName; // Имя
    private String patronymic; // Отчество
    private LocalDate birthday; // Дата рождения
    private Integer phone; // Номер телефона
    private Character gender; // Пол

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Пример: Иванов Иван Иванович 14.07.1943 431234324 m
     */
    public void setData (String s) throws PhoneException, GenderException, StringException, BirthdayException {
        List<String> stringList = checkString(s);

        this.lastName = getNameFromList(stringList, 0);
        this.firstName = getNameFromList(stringList, 1);
        this.patronymic = getNameFromList(stringList, 2);
        this.birthday = getBirthdayFromList(stringList, 3);
        this.phone = getPhoneFromList(stringList, 4);
        this.gender = getGenderFromList(stringList, 5);
    }

    private List<String> checkString(String s) throws StringException {
        if (s == null) throw new StringException("Введенная строка не может указывать на null!");
        if (s.equals("")) throw new StringException("Строка не может быть пустой!");
        if (s.split(" ").length != 6) throw new StringException("Строка содержит неверное количество параметров!");
        return Arrays.asList(s.split(" "));
    }

    private String getNameFromList (List<String> stringList, int index) throws StringException {
        String result = stringList.get(index);
        if (!Pattern.matches("^[\\p{L}\\s.’\\-,]+$", result))
            throw new StringException("Фамилия/Имя/Отчество содержит некорректные символы!");
        return result;
    }

    private LocalDate getBirthdayFromList (List<String> stringList, int index) throws BirthdayException {
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(stringList.get(index), formatter);
        } catch (Exception e) {
            throw new BirthdayException("Неверный формат даты рождения!");
        }
        return localDate;
    }

    private Integer getPhoneFromList (List<String> stringList, int index) throws PhoneException{
        Integer phone;
        try {
            phone = Integer.parseInt(stringList.get(index));
            return phone;
        } catch (NumberFormatException e) {
            throw new PhoneException("Неверный формат номера телефона!");
        }
    }

    private Character getGenderFromList (List<String> stringList, int index) throws GenderException{
        String s = stringList.get(index);
        if (s.length() > 1) throw new GenderException("Пол должен состоять из одного символа!");
        if (s.charAt(0) != 'f' && s.charAt(0) != 'm') throw new GenderException("Пол должен быть f или m!");
        return s.charAt(0);
    }

    @Override
    public String toString() {
        return String.format("<[%s]><[%s]><[%s]><[%s]><[%s]><[%s]>",
                lastName, firstName, patronymic, formatter.format(birthday), phone, gender);
    }
}
