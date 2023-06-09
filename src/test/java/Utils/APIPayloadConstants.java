package Utils;

import APIStepDefinitions.APIWorkflowSteps;
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

    public static String createEmployeePayloadDynamic(String emp_firstname, String emp_lastname, String emp_middle_name,
                                                      String emp_gender, String emp_birthday, String emp_status,
                                                      String emp_job_title) {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();

    }

    public static String updateEmployeePayloadJson() {

        JSONObject obj = new JSONObject();
        obj.put("employee_id", "58040A");
        obj.put("emp_firstname", "Leez");
        obj.put("emp_lastname", "Truss");
        obj.put("emp_middle_name", "Anna");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "1986-01-01");
        obj.put("emp_status", "Fired");
        obj.put("emp_job_title", "MedRep");

        return obj.toString();

    }
}
