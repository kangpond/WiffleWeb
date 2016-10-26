package gov.nia.nrs.utils;

import java.io.IOException;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public class EscapeUtils {
    @SuppressWarnings("rawtypes")
    public static final HashMap m = new HashMap();
    static {
        m.put(34, "&quot;"); // < - less-than
        m.put(60, "&lt;"); // < - less-than
        m.put(62, "&gt;"); // > - greater-than


        // User needs to map all html entities with their corresponding decimal values.
        // Please refer to below table for mapping of entities and integer value of a char
    }

    public static String escapeHtml(String str) {
        // String str = "<script>alert(\"abc\")</script>";
        try {
            StringBuffer writer = new StringBuffer("");
            int len = str.length();


            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                int ascii = (int) c;
                String entityName = (String) m.get(ascii);
                if (entityName == null) {

                    writer.append(String.valueOf(c));

                } else {
                    writer.append(entityName);

                }


            }

            return writer.toString();
        } catch (Exception ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

  /*  public static  String escapeSelf(String str) throws IOException {

        StringBuffer writer = new StringBuffer("");
        int len = str.length();


        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int ascii = (int) c;
            String entityName = (String) m.get(ascii);
            if (entityName == null) {

                writer.append(String.valueOf(c));

            } else {
                writer.append(entityName);

            }


        }

        return writer.toString();
    }*/
}
