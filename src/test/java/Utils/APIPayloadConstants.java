package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    // we will pass the body in multiple formats, for doing this we created this class

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Moazzam\",\n" +
                "  \"emp_lastname\": \"Teacher\",\n" +
                "  \"emp_middle_name\": \"Mrs\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2000-01-22\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"SDET Engineer\"\n" +
                "}";
    return createEmployeePayload;
    }

    public static String createEmployeePayloadJson() {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Moazzam");
        obj.put("emp_lastname", "Teacher");
        obj.put("emp_middle_name", "MR");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1977-01-22");
        obj.put("emp_status", "Hired");
        obj.put("emp_job_title", "Professor");

        return obj.toString();

    }
}
