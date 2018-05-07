import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeURL {

    public static String[] validNameChecker(String givenName) {
        String[] nameParts;
        while (true) {
            Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$"); // regex to check for spaces, valid A-Z characters
            Matcher matcher = pattern.matcher(givenName);
            if (matcher.matches()) {
                nameParts = givenName.split(" ");
//                for (int i =0 ; i< nameParts.length; i++) {
//                    System.out.println(nameParts[i]);
//                }

                if (nameParts.length < 2 || nameParts.length > 3) {
                    // TODO: shouldnt sout here, need to set the PlayerResult to be the error message
                    System.out.println("Given name length too short or too long. Enter valid name");
                    // no player's name should have less than 2 parts or more than 3 parts
                } else {
                    break;
                } // break when checked that the string is valid and i have split it up
            } else {
                // TODO: shouldnt sout here, need to set the PlayerResult to be the error message
                System.out.println("Invalid Name. Name must have only alphabetical letters. Enter valid name.");
            }
        }
//        for (int i = 0; i < nameParts.length ; i++ ) {
//            System.out.println(nameParts[i]);
//        }
        return nameParts;
    }

    // TODO:
    // think of special player names that will require a different URL type

    public static String createURL(String givenName) {
        String url = "https://en.wikipedia.org/wiki/";

        String[] stringArray = validNameChecker(givenName);

        if (stringArray.length == 2) {
            String first = stringArray[0];
            first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
            String last = stringArray[1];

            if (first.contains("-")) {
                first = firstNameWithDash(first);
            }

            if (last.contains("-")) {
                last = lastNameWithDash(last);
            } else if (last.contains("mc")){
                last = namesWithMc(last);
            } else if (last.contains("mac")) {
                last = namesWithMac(last);
            } else {
                last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
            }
            url = url + first + "_" + last;
        }

        if (stringArray.length == 3) {
            String first = stringArray[0];
            first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
            String middle = stringArray[1]; // assume middle name is not capitalized (ie James van Riemsdyk)
            String last = stringArray[2];
            last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
            url = url + first + "_" + middle + "_" + last;
        }

        //System.out.println(url);

        return url;
    }

//    public static String formattedName() {
//        String[] nameParts = validNameChecker();
//        if (nameParts.length > 2) {
//            return nameParts[0] + nameParts[1] + nameParts[2];
//        } else {
//            return nameParts[0] + nameParts[1];
//        }
//    }

    public static String firstNameWithDash(String first) {
        String[] split = first.split("-");
        split[0] = split[0].substring(0, 1).toUpperCase() + split[0].substring(1).toLowerCase();
        split[1] = split[1].substring(0, 1).toUpperCase() + split[1].substring(1).toLowerCase();
        return split[0] + "-" + split[1];

    }

    public static String lastNameWithDash(String last) {
        String[] splitLastName = last.split("-");
        splitLastName[0] = splitLastName[0].substring(0, 1).toUpperCase() + splitLastName[0].substring(1).toLowerCase();
        splitLastName[1] = splitLastName[1].substring(0, 1).toUpperCase() + splitLastName[1].substring(1).toLowerCase();
        return splitLastName[0] + "-" + splitLastName[1];
    }

    public static String namesWithMc(String last) {
        return "Mc" + last.substring(2).substring(0,1).toUpperCase() + last.substring(3).toLowerCase();
    }

    public static String namesWithMac(String last) {
        return "Mac" + last.substring(3).substring(0,1).toUpperCase() + last.substring(4).toLowerCase();

    }

    public static String makeNewURLWithIceHockey(String url) {
        return url + "_(ice_hockey)";

    }

}


//        String[] nameParts = null;
//        String url = "https://en.wikipedia.org/wiki/";
//
//        while (true) {
//            Pattern pattern = Pattern.compile("^[a-zA-Z\\\\s]*$"); // regex to check for spaces, valid A-Z characters
//            Matcher matcher = pattern.matcher(playerName);
//            if (matcher.matches()) {
//                nameParts = playerName.split(" ");
//                if (nameParts.length < 2 || nameParts.length > 3) {
//                    System.out.println("Given name length too short or too long. Enter valid name");
//                    // no player's name should have less than 2 parts or more than 3 parts
//                } else System.out.println("Invalid Name. Enter valid name. Name must have only alphabetical letters");
//            }
//            break; // break when checked that the string is valid and i have split it up
//        }

