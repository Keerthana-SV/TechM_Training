public class AlternateCapitalization {
    public static void main(String[] args) {
        String input = "hello world";
        String result = capitalizeAlternate(input);
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
    }

    public static String capitalizeAlternate(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(ch)); 
            } else {
                sb.append(Character.toLowerCase(ch)); 
            }
        }

        return sb.toString();
    }
}
