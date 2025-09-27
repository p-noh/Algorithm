import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String javaToCpp(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append('_').append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String cppToJava(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') {
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String checkType(String str) {
        if (str == null || str.isEmpty()) return "Error";
        if (str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_' || str.contains("__")) return "Error";

        boolean hasUnderscore = false;
        boolean hasUppercase = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') hasUnderscore = true;
            else if (Character.isUpperCase(c)) hasUppercase = true;
            else if (!Character.isLowerCase(c)) return "Error"; // 소문자/대문자/'_' 외 금지
        }

        if (hasUnderscore && hasUppercase) return "Error";

        if (hasUnderscore) {
            return "Cpp";
        } else {
            if (Character.isUpperCase(str.charAt(0))) return "Error";
            return "Java";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String type = checkType(str);
        if (type.equals("Java")) System.out.println(javaToCpp(str));
        else if (type.equals("Cpp")) System.out.println(cppToJava(str));
        else System.out.println("Error!");
    }
}
