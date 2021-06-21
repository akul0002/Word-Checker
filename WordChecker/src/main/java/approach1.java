        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.Locale;
        import java.util.Map;

public class approach1 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        char[] values = {'W','O','R','K'};
        int n = values.length;
        System.out.println("All possible words you can make with those letters:");

        for (int i = 1; i <= n; i++) {
            int r = i;
            int output[] = new int[i];

            for (int numIterations = 0; numIterations < Math.pow(n, r); numIterations++) {
                print(values, r, output);
                int index = 0;
                while (index < r) {
                    if (output[index] < n - 1) {
                        output[index]++;
                        break;
                    } else {
                        output[index] = 0;
                    }
                    index++;
                }
            }
        }
    }

    private static void print(char[] values, int r, int[] output) throws IOException {
        //System.out.print(String.format("\n%2d", ++count) + ") ");
        String word="";
        while (r-- > 0) {
            //System.out.print(values[output[r]]);
            word=word+values[output[r]];
        }
        //System.out.print(word);
        Dictionary.isEnglishWord(word);
    }

    public static class Dictionary {

        public static boolean isEnglishWord(String word) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\akul0\\IdeaProjects\\WordChecker\\src\\main\\resources\\dictionary.txt"));

            for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
                if (word.equals(currentWord)) {
                    System.out.println(currentWord);
                }
            }
            return true;
        }
    }
}


