package onlineExamination.meililianhe;

public class Main2991 {
    public static void split(String string) {

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : string.toCharArray()) {
            if (c == '|') {
                System.out.println(stringBuilder);
                stringBuilder.delete(0, stringBuilder.length());
            } else {
                stringBuilder.append(c);
            }
        }

        System.out.println(stringBuilder);
    }
}
