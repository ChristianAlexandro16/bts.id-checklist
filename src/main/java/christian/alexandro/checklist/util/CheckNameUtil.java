package christian.alexandro.checklist.util;

import org.springframework.stereotype.Component;

@Component
public class CheckNameUtil {
    public static String checkEmptyNotNull(String data){
        if (data == null || data.trim().isEmpty()){
            return "Data is empty";
        } else {
            return null;
        }
    }
}
