package com.company;

import com.company.Patient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char task;
        boolean check = true;
        ArrayList<Patient> obj = new ArrayList<Patient>();
        while (check) {
            System.out.println("\nМеню:\nВведіть q, якщо хочете вийти\nВведіть r, щоб переглянути\nВведіть w, щоб внести дані у файл\nВведіть c, щоб очистити файл\nВведіть e, щоб редагувати запис\nВведіть s, щоб сортувати записи.");
            task = in.next().charAt(0);
            switch (task) {
                case 'q':
                    return;
                case 'r':
                    obj = readFromFile();
                    output(obj);
                    break;
                case 'o':
                    output(obj);
                    break;
                case 'w':
                    obj.add(insertInClass());
                    writeInFile(obj.get(obj.size()-1));
                    break;
                case 'c':
                    clearFile();
                    break;
                case 'e':
                    redactInFile();
                    obj = readFromFile();
                    output(obj);
                    break;
                case 's':
                    //Patient.QuickSort(obj);
                    obj.sort(Comparator.comparing(Patient::getSecondname));
                    output(obj);
                    break;

            }
        }
    }

    public static void clearFile()
    {
        try(BufferedWriter writter = new BufferedWriter(new FileWriter("Patients.txt")))
        {
            writter.write("");
            writter.close();
            System.out.println("Вдалося очистити файл");
        }
        catch (IOException e)
        {
            System.out.println("Не вдалося очистити файл.");
        }
    }

    public static void redactInFile()
    {
        String tmp, tmpGender;
        ArrayList<Patient> obj = readFromFile();
        output(obj);
        System.out.println("Введіть стать: ");
        tmpGender = in.next();
        System.out.println("Введіть прізвище, за яким редагувати запис: ");
        tmp = in.next();
        int i = 0;
        String tmp1 = null;
        while(!tmp.equals(tmp1))
        {
            tmp1 = obj.get(i).getSecondname();
            i++;
        }
        obj.set(i-1, insertInClass());
        clearFile();
        for(int j = 0; j < obj.size(); j ++)
        {
            writeInFile(obj.get(j));
        }
        System.out.println("Дані успішно відредаговані");
    }

    public static void writeInFile(Patient obj)
    {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter("Patients.txt", true)))
        {
            writter.write(obj.getCardId() + "\n");
            writter.write(obj.getFirstname() + "\n");
            writter.write(obj.getSecondname() + "\n");
            writter.write(obj.getThirdname() + "\n");
            writter.write(obj.getDateOfBirth() + "\n");
            writter.write(obj.getGender() + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Patient insertInClass()
    {
        Patient obj = new Patient();
        System.out.println("Введіть айді карти пацієнта: ");
        int i = in.nextInt();
        obj.setCardId(i);
        System.out.println("Введіть ім'я пацієнта: ");
        String n = in.next();
        obj.setFirstname(n);
        System.out.println("Введіть прізвище пацієнта: ");
        String sn = in.next();
        obj.setSecondname(sn);
        System.out.println("Введіть по-батькові пацієнта: ");
        String tn = in.next();
        obj.setThirdname(tn);
        System.out.println("Введіть день народження пацієнта: ");
        String dob = in.next();
        obj.setDateOfBirth(dob);
        System.out.println("Введіть стать пацієнта: ");
        String g = in.next();
        obj.setGender(g);

        return obj;

    }

    public static void output(ArrayList<Patient> obj)
    {
        if(obj.isEmpty()) { System.out.println(); return;}
        for(int i = 0; i < obj.size(); i ++)
        {
            System.out.println(obj.get(i).getCardId());
            System.out.println("\n" +  obj.get(i).getFirstname());
            System.out.println("\n" +  obj.get(i).getSecondname());
            System.out.println("\n" +  obj.get(i).getThirdname());
            System.out.println("\n" +  obj.get(i).getDateOfBirth());
            System.out.println("\n" +  obj.get(i).getGender());
        }
    }

    public static ArrayList<Patient> readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("Patients.txt")))
        {
            String tempLine;
            int cardId;
            String firstname;
            String secondname;
            String thirdname;
            String dateOfBirth;
            String gender;
            ArrayList<Patient> text = new ArrayList<Patient>();
            while((tempLine = br.readLine()) != null)
            {
                cardId = Integer.parseInt(tempLine);
                tempLine = br.readLine();
                firstname = tempLine;
                tempLine = br.readLine();
                secondname = tempLine;
                tempLine = br.readLine();
                thirdname = tempLine;
                tempLine = br.readLine();
                dateOfBirth = tempLine;
                tempLine = br.readLine();
                gender = tempLine;
                text.add(new Patient(cardId, firstname, secondname, thirdname, dateOfBirth, gender));
            }
            return text;
        } catch (IOException e) {
            System.out.println("Не вдалося зчитати дані з файлу");
        }
        return null;
    }
}
