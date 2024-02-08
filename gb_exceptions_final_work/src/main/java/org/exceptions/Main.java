package org.exceptions;

import model.DataReader;
import model.DataSaver;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean repeat = true;

        while (repeat){
            System.out.println("Введите данные в виде Фамилия Имя Отчество дата_рождения номер_телефона пол, обязательно разделите пробелами, дата в формате дд.мм.гггг, пол f или m. 'q' для выхода");
            String dataLine = new Scanner(System.in).nextLine();

            if (dataLine.equals("q")){
                break;
            }

            try {
                DataReader dr = new DataReader();
                dr.parseData(dataLine);
                DataSaver.saveData(dr.getData());
            }catch (IOException e){
                System.out.println("Возникла ошибка при сохранении файла");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }


    }
}