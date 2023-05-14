import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VernamCypherEncryptor {
    public static void getStringsModular(String secret_phrase, String encryption_key) {
        List<Character> charList = new ArrayList<>();
        int[] secretPhraseIntArr = new int[secret_phrase.length()];
        int[] encryptionKeyIntArr = new int[encryption_key.length()];
        String[] phraseKeyArray = {secret_phrase, encryption_key};
        char[] alphabetArr = new char[26];
        String encryptedPhrase = "";



        for ( String encryptComponent : phraseKeyArray) {

            int counter = 0;
            int encryptComponentIndex = 0;
            for (String letter : encryptComponent.split("")) {

                counter = 0;

                for (char l = 'A'; l <= 'Z'; l++) {
                    alphabetArr[counter] = l;
                    Character cl = l;
                    String charLetter = cl.toString();

                    if (charLetter.equals(letter)) {
                        if (encryptComponent.equals(secret_phrase)) {

                            secretPhraseIntArr[encryptComponentIndex] = counter;

                        } else if (encryptComponent.equals(encryption_key)) {

                            encryptionKeyIntArr[encryptComponentIndex] = counter;

                        }
                    }
                    counter++;
                }
                encryptComponentIndex++;

            }

        }

        int[] resultArr = new int[9];
        for (int i = 0; i < secretPhraseIntArr.length; i++) {
            resultArr[i] = ((secretPhraseIntArr[i] + encryptionKeyIntArr[i]) % 26);
        }
        System.out.println(Arrays.toString(resultArr));

        for (int arrIndx : resultArr) {
            System.out.println(alphabetArr[arrIndx]);
            encryptedPhrase += alphabetArr[arrIndx];
        }
        System.out.println(encryptedPhrase);
    }
}

