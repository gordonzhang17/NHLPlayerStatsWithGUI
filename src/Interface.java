import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {

    public JLabel title;
    public JTextField userInput;
    public JButton findStats;
    public JLabel position;
    public JLabel lastSeasonPlayed;
    public JLabel team;
    public JLabel league;
    public JLabel gamesPlayed;
    public JPanel Interface;
    public JLabel goals;
    public JLabel assists;
    public JLabel points;
    public JLabel penaltyInMinutes;
    public JLabel wins;
    public JLabel loses;
    public JLabel overtimeLoses;
    public JLabel totalMinutes;
    public JLabel goalsAllowed;
    public JLabel shutouts;
    public JLabel savePercentage;
    public JLabel goalsAllowedAverage;
    public JLabel error;

    private boolean pass = true;

    public Interface() {

        findStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. get the inputted text, then come up with all the data
                Document document;
                Element dataRow;
                String completedURL;

                if (pass) {
                    // do nothing, 1st time through
                    pass = false;

                } else {
                    //  this is to reset data if user wants to find stats for another player

                    position.setText(null);
                    lastSeasonPlayed.setText(null);
                    team.setText(null);
                    league.setText(null);
                    gamesPlayed.setText(null);

                    wins.setText(null);
                    loses.setText(null);
                    overtimeLoses.setText(null);
                    totalMinutes.setText(null);
                    goalsAllowed.setText(null);
                    goalsAllowedAverage.setText(null);
                    shutouts.setText(null);
                    savePercentage.setText(null);

                    goals.setText(null);
                    assists.setText(null);
                    points.setText(null);
                    penaltyInMinutes.setText(null);

                    error.setText(null);
                }
                try {
                    completedURL = MakeURL.createURL(userInput.getText());
                    document = Connection.connect(completedURL);
                    dataRow = DataSelection.selectData(document);

                    if (Player.isGoaltender(document)) {
                        Goaltender goaltender = Goaltender.goalieInfo(document, dataRow);
                        position.setText("Position: " + Player.getPosition(document));
                        lastSeasonPlayed.setText("Last Season Played: " + goaltender.lastSeasonPlayed);
                        team.setText("Last Team Played For: " + goaltender.lastTeamPlayedFor);
                        league.setText("League: " + goaltender.league);
                        gamesPlayed.setText("Games Played: " + goaltender.gamesPlayed);

                        wins.setText("Wins: " + goaltender.wins);
                        loses.setText("Loses: " + goaltender.loses);
                        overtimeLoses.setText("Overtime Loses: " + goaltender.overtimeLoses);
                        totalMinutes.setText("Total Minutes: " + goaltender.totalMinutes);
                        goalsAllowed.setText("Goals Allowed: " + goaltender.goalsAllowed);
                        goalsAllowedAverage.setText("Goals Allowed Average: " + goaltender.goalsAllowedAverage);
                        shutouts.setText("Shutouts" + goaltender.shutouts);
                        savePercentage.setText("Save Percentage: " + goaltender.savePercentage);

                    } else {

                        NonGoaltender nonGoalie = NonGoaltender.nonGoalieInfo(document, dataRow);
                        position.setText("Position: " + Player.getPosition(document));
                        lastSeasonPlayed.setText("Last Season Played: " + nonGoalie.lastSeasonPlayed);
                        team.setText("Last Team Played For: " + nonGoalie.lastTeamPlayedFor);
                        league.setText("League: " + nonGoalie.league);
                        gamesPlayed.setText("Games Played: " + nonGoalie.gamesPlayed);

                        goals.setText("Goals: " + nonGoalie.goals);
                        assists.setText("Assists: " + nonGoalie.assists);
                        points.setText("Points: " + nonGoalie.points);
                        penaltyInMinutes.setText("Penalty in Minutes: " + nonGoalie.penaltyInMinutes);
                    }
                } catch (Exception f) {
                    noPlayerExists();
                }

            }

            private void noPlayerExists() {
                error.setText("Cannot find this player or given name too short. Enter valid name.");
            }

        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interface");
        frame.setContentPane(new Interface().Interface);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Interface = new JPanel();
        Interface.setLayout(new GridBagLayout());
        Interface.setBackground(new Color(-12629012));
        Interface.setEnabled(false);
        Interface.setMaximumSize(new Dimension(10000, 10000));
        Interface.setMinimumSize(new Dimension(1000, 1000));
        Interface.setPreferredSize(new Dimension(2000, 2000));
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        Interface.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        Interface.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        Interface.add(spacer3, gbc);
        position = new JLabel();
        Font positionFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, position.getFont());
        if (positionFont != null) position.setFont(positionFont);
        position.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        Interface.add(position, gbc);
        lastSeasonPlayed = new JLabel();
        Font lastSeasonPlayedFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, lastSeasonPlayed.getFont());
        if (lastSeasonPlayedFont != null) lastSeasonPlayed.setFont(lastSeasonPlayedFont);
        lastSeasonPlayed.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        Interface.add(lastSeasonPlayed, gbc);
        team = new JLabel();
        Font teamFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, team.getFont());
        if (teamFont != null) team.setFont(teamFont);
        team.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        Interface.add(team, gbc);
        league = new JLabel();
        Font leagueFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, league.getFont());
        if (leagueFont != null) league.setFont(leagueFont);
        league.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 6;
        Interface.add(league, gbc);
        gamesPlayed = new JLabel();
        Font gamesPlayedFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, gamesPlayed.getFont());
        if (gamesPlayedFont != null) gamesPlayed.setFont(gamesPlayedFont);
        gamesPlayed.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 6;
        Interface.add(gamesPlayed, gbc);
        title = new JLabel();
        Font titleFont = this.$$$getFont$$$("Trebuchet MS", -1, 36, title.getFont());
        if (titleFont != null) title.setFont(titleFont);
        title.setText("NHL Player Stats");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        Interface.add(title, gbc);
        userInput = new JTextField();
        Font userInputFont = this.$$$getFont$$$("Trebuchet MS", -1, 22, userInput.getFont());
        if (userInputFont != null) userInput.setFont(userInputFont);
        userInput.setMinimumSize(new Dimension(50, 23));
        userInput.setPreferredSize(new Dimension(50, 28));
        userInput.setText("Enter Player Name Here");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Interface.add(userInput, gbc);
        findStats = new JButton();
        findStats.setBackground(new Color(-12168212));
        findStats.setBorderPainted(true);
        findStats.setContentAreaFilled(true);
        findStats.setDefaultCapable(true);
        findStats.setEnabled(true);
        Font findStatsFont = this.$$$getFont$$$("Trebuchet MS", -1, 20, findStats.getFont());
        if (findStatsFont != null) findStats.setFont(findStatsFont);
        findStats.setForeground(new Color(-16777216));
        findStats.setHideActionText(true);
        findStats.setText("Find Stats!");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Interface.add(findStats, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Interface.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Interface.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Interface.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Interface.add(spacer7, gbc);
        goals = new JLabel();
        Font goalsFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, goals.getFont());
        if (goalsFont != null) goals.setFont(goalsFont);
        goals.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(goals, gbc);
        assists = new JLabel();
        Font assistsFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, assists.getFont());
        if (assistsFont != null) assists.setFont(assistsFont);
        assists.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(assists, gbc);
        points = new JLabel();
        Font pointsFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, points.getFont());
        if (pointsFont != null) points.setFont(pointsFont);
        points.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(points, gbc);
        penaltyInMinutes = new JLabel();
        Font penaltyInMinutesFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, penaltyInMinutes.getFont());
        if (penaltyInMinutesFont != null) penaltyInMinutes.setFont(penaltyInMinutesFont);
        penaltyInMinutes.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(penaltyInMinutes, gbc);
        wins = new JLabel();
        Font winsFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, wins.getFont());
        if (winsFont != null) wins.setFont(winsFont);
        wins.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(wins, gbc);
        loses = new JLabel();
        loses.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(loses, gbc);
        overtimeLoses = new JLabel();
        Font overtimeLosesFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, overtimeLoses.getFont());
        if (overtimeLosesFont != null) overtimeLoses.setFont(overtimeLosesFont);
        overtimeLoses.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(overtimeLoses, gbc);
        totalMinutes = new JLabel();
        Font totalMinutesFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, totalMinutes.getFont());
        if (totalMinutesFont != null) totalMinutes.setFont(totalMinutesFont);
        totalMinutes.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(totalMinutes, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.VERTICAL;
        Interface.add(spacer8, gbc);
        goalsAllowed = new JLabel();
        Font goalsAllowedFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, goalsAllowed.getFont());
        if (goalsAllowedFont != null) goalsAllowed.setFont(goalsAllowedFont);
        goalsAllowed.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(goalsAllowed, gbc);
        savePercentage = new JLabel();
        Font savePercentageFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, savePercentage.getFont());
        if (savePercentageFont != null) savePercentage.setFont(savePercentageFont);
        savePercentage.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(savePercentage, gbc);
        shutouts = new JLabel();
        Font shutoutsFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, shutouts.getFont());
        if (shutoutsFont != null) shutouts.setFont(shutoutsFont);
        shutouts.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(shutouts, gbc);
        goalsAllowedAverage = new JLabel();
        Font goalsAllowedAverageFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, goalsAllowedAverage.getFont());
        if (goalsAllowedAverageFont != null) goalsAllowedAverage.setFont(goalsAllowedAverageFont);
        goalsAllowedAverage.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        Interface.add(goalsAllowedAverage, gbc);
        error = new JLabel();
        Font errorFont = this.$$$getFont$$$("Trebuchet MS", -1, 24, error.getFont());
        if (errorFont != null) error.setFont(errorFont);
        error.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 11;
        Interface.add(error, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Interface;
    }
}

