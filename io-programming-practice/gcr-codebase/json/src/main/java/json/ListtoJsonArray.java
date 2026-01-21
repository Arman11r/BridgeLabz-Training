package json;

import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListtoJsonArray {

	public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Arman", 85));
        students.add(new Student(2, "Riya", 90));
        students.add(new Student(3, "rachit", 78));

        JSONArray jsonArray = new JSONArray();

        for (Student s : students) {

            JSONObject obj = new JSONObject();
            obj.put("id", s.id);
            
            obj.put("name", s.name);
            
            obj.put("marks", s.marks);
            

            jsonArray.add(obj);
        }

        
        System.out.println(jsonArray.toJSONString());
    }
}