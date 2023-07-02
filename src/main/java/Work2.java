//2) Дана json-строка (можно сохранить в файл и читать из файла)
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

import java.io.*;

public class Work2 {
    public static void main(String[] args) throws Exception {
        StringBuilder finish = new StringBuilder("");
        File student2 = new File("student2");
        String s = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        if (!student2.exists()) {
            FileWriter writer = new FileWriter(student2);
            writer.write(s);
            writer.close();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("student2"));
            String student = reader.readLine();
            student = student.replace("[", "");
            student = student.replace("]", "");
            student = student.replace("\"", "");
            String[] stud = student.split("},");
            String[] change = {" Студент ", " получил ", " по предмету " };

            for (int i = 0; i < stud.length; i++) {
                stud[i] = stud[i].replace("{", "");
                stud[i] = stud[i].replace("}", "");
                String[] finishStud = stud[i].split(",");
                for (int j = 0; j < finishStud.length; j++) {
                    finish.append(change[j]);
                    finish.append(finishStud[j].split(":")[1]);
                }
            }
            System.out.println(finish);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

