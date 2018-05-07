import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Player {

    //private String position;

    public String lastSeasonPlayed;
    public String lastTeamPlayedFor;
    public String league;
    public String gamesPlayed;

    public Player(String lastSeasonPlayed, String lastTeamPlayedFor, String league, String gamesPlayed) {
        this.lastSeasonPlayed = lastSeasonPlayed;
        this.lastTeamPlayedFor = lastTeamPlayedFor;
        this.league = league;
        this.gamesPlayed = gamesPlayed;
    }

//    public Player(String position) {
//        this.position = position;
//    }

    public static String getPosition(Document document) {

        assert document != null;
        Elements summaryTable = document.select("table[class=infobox vcard]");
        // first, we want the position of the player
        Elements positionRow = summaryTable.select("tr:nth-child(6)");
        // inside the HTML for the position
        Elements positionSecondRow = positionRow.select("td[class=role]");
        String position = positionSecondRow.text();

        // check if the player plays multiple positions:
        String[] positionParts = position.split("/");
//        for (int i = 0 ; i < positionParts.length ; i++) {
//            System.out.println(positionParts[i]);
//        }

        if (positionParts.length > 1) {
            if (positionParts[1].contains("[")) {
                positionParts[1] = positionParts[1].substring(0, positionParts[1].indexOf("["));
            }
            return positionParts[0] + " and " + positionParts[1];
        } else {
            return position;
        }
    }

//    public static String getLastSeasonPlayed(Player player) {
//        return player.lastSeasonPlayed;
//    }
//
//    public static String getTeam(Player player) {
//        return player.lastTeamPlayedFor;
//    }
//
//    public static String getLeague(Player player) {
//        return player.league;
//    }
//
//    public static String getGamesPlayed(Player player) {
//        return player.gamesPlayed;
//    }


    public static boolean isGoaltender(Document document) {
        Elements summaryTable = document.select("table[class=infobox vcard]");
        // first, we want the position of the player
        Elements positionRow = summaryTable.select("tr:nth-child(6)");
        // inside the HTML for the position
        Elements positionSecondRow = positionRow.select("td[class=role]");
        return positionSecondRow.select("a[title]").text().contains("Goaltender");
    }

    public static void playOffInfo(Document document, Element dataRow) {
        if (!dataRow.select("td").get(8).text().matches(".*\\d+.*")
                || !dataRow.select("td").get(12).text().matches(".*\\d+.*")) {
            System.out.println("Did not participate in the playoffs in his last season or is currently in the playoffs");
        } else if (isGoaltender(document)) {
            try {
                Goaltender.printPlayoffInfo(dataRow);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cannot retrieve playoff statistics.");
            }
        } else try {
            NonGoaltender.printPlayoffInfo(dataRow);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Cannot retrieve the playoff statistics.");
        }
    }
}