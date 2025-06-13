
public class TennisGame1 implements TennisGame {

    private static final String[] Point_names = {"Love", "Fifteen", "Thirty", "Forty"};
    private final int[] scores = new int [2];
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            scores[0]++;
        } else if (playerName.equals(player2Name)) {
            scores[1]++;
        } else {
            throw new IllegalArgumentException("Invalid player name: " + playerName);
        }
    }

    @Override
    public String getScore() {
        int p1Score = scores[0];
        int p2Score = scores[1];

        if (p1Score == p2Score){
            return p1Score >=3 ? "Deuce" : Point_names[p1Score] + "-All";
        }

        if (p1Score>= 4 || p2Score >= 4) {
            int scoreDifference = p1Score - p2Score;
            String leadingPlayer = scoreDifference > 0 ? player1Name : player2Name;
            return Math.abs(scoreDifference) == 1 ? "Advantage " + leadingPlayer : "Win for " + leadingPlayer;
        }

        return Point_names[p1Score] + "-" + Point_names[p2Score];

    }
}
