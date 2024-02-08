package model;

import exceptions.*;

public class DataReader {
    private String[] data;

    public void parseData(String dataLine) throws NotEnoughDataException, NameFormatException, BirthdayFormatException, PhoneFormatException, GenderException {
        data = dataLine.split(" ");

        checkLength();
        checkNameSurname(0, "фамилии");
        checkNameSurname(1, "имени");
        checkNameSurname(2, "отчества");
        checkBirthday();
        checkPhone();
        checkGender();
    }

    public String[] getData(){
        return data;
    }

    private void checkLength() throws NotEnoughDataException{
        if (data.length != 6){
            throw new NotEnoughDataException("Проверьте ввод, или чего то не хватает или что то лишнее");
        }
    }

    private void checkNameSurname(int index, String addErrorPoint) throws NameFormatException{
        String regex = "^[А-Яа-я]+$";

        if (!data[index].matches(regex)){
            throw new NameFormatException("Ошибка при вводе " + addErrorPoint);
        }
    }

    private void checkBirthday() throws BirthdayFormatException {
        String regex = "\\d\\d.\\d\\d.\\d\\d\\d\\d";

        if (!data[3].matches(regex)){
            throw new BirthdayFormatException("Ошибка при вводе даты рождения");
        }
    }

    private void checkPhone() throws PhoneFormatException {
        String regex = "^([1-9][0-9]*)$";

        if (!data[4].matches(regex)){
            throw new PhoneFormatException("Ошибка при вводе даты рождения");
        }
    }

    private void checkGender() throws GenderException{
        String regex = "^[f,m]*$";
        if (!data[5].matches(regex)){
            throw new GenderException("Ошибка при вводе пола");
        }
    }
}
