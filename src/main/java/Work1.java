//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder или String.
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class Work1 {
    public static void main(String[] args) {
        StringBuilder where = new StringBuilder();
        String[] s = {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"};
        for (int i = 0; i <s.length; i++){
            if (s[i].indexOf("null")==(-1)){
                where.append(s[i].replace(":", " "));
                if (i != s.length-2){
                    where.append(" ");

                }
            }
        }
        System.out.println(where);

    }

}
