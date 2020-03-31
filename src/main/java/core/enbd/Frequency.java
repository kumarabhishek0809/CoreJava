package core.enbd;

public class Frequency {

    static int MAX = 26;

    // Function to print the frequency
    // of each of the characters of
    // s in alphabetical order
    public String compressString(String s) {
        // To store the frequency
        // of the characters
        int freq[] = new int[MAX];
        int n = s.length();
        String charactercount = "";

        // Update the frequency array
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Print the frequency in alphatecial order
        for (int i = 0; i < MAX; i++) {
            // If the current alphabet doesn't
            // appear in the string
            if (freq[i] == 0)
                continue;

            charactercount = charactercount + (char) (i + 'a') + "" + freq[i];
        }
        return charactercount;
    }

    // Driver code
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int n = s.length();
        Frequency frequency = new Frequency();
        String compressString = frequency.compressString(s);
        System.out.println("e4f1g2k2o1r1s2".equals(compressString));
    }
}