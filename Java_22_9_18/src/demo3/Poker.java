package demo3;

public class Poker {
    private String suit;
    private int rank;

    public Poker(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return this.suit+" "+this.rank;
    }
}
