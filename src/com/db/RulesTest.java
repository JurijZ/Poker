package com.db;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {

    private Rules r = new Rules();

    @Test
    public void FirstLevelEvaluator_ShouldReturnHandRating(){
        Hand h0 = new Hand("8C", "TS", "KC", "9H", "4S");
        Hand h1 = new Hand("8C", "8S", "KC", "9H", "4S");
        Hand h2 = new Hand("8C", "8S", "KC", "KH", "4S");
        Hand h3 = new Hand("8C", "8S", "KC", "8H", "4S");
        Hand h4 = new Hand("8C", "9S", "TC", "JH", "QS");
        Hand h5 = new Hand("8C", "TC", "KC", "9C", "4C");
        Hand h6 = new Hand("8C", "8S", "KC", "8H", "KS");
        Hand h7 = new Hand("8C", "8S", "8H", "9H", "8S");
        Hand h8 = new Hand("8S", "9S", "TS", "JS", "QS");
        Hand h9 = new Hand("TS", "AS", "KS", "JS", "QS");

        assertEquals(0, r.RankEvaluator(h0));
        assertEquals(1, r.RankEvaluator(h1));
        assertEquals(2, r.RankEvaluator(h2));
        assertEquals(3, r.RankEvaluator(h3));
        assertEquals(4, r.RankEvaluator(h4));
        assertEquals(5, r.RankEvaluator(h5));
        assertEquals(6, r.RankEvaluator(h6));
        assertEquals(7, r.RankEvaluator(h7));
        assertEquals(8, r.RankEvaluator(h8));
        assertEquals(9, r.RankEvaluator(h9));
    }

    @Test
    public void IsRoyalFlash_ShouldReturnTrue(){
        Hand h = new Hand("JC", "TC", "KC", "AC", "QC");

        assertTrue(r.IsRoyalFlash(h));
    }

    @Test
    public void IsRoyalFlash_ShouldReturnFalse(){
        Hand h = new Hand("JC", "TC", "KC", "AC", "QD");
        Hand h1 = new Hand("JC", "TC", "KC", "AC", "2C");

        assertFalse(r.IsRoyalFlash(h));
        assertFalse(r.IsRoyalFlash(h1));
    }

    @Test
    public void isStraightFlush_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "6C", "5C", "7C");

        assertTrue(r.IsStraightFlush(h));
    }

    @Test
    public void isStraightFlush_ShouldReturnFalse() {
        Hand h = new Hand("JD", "TC", "KC", "AC", "QC");
        Hand h1 = new Hand("3C", "8C", "6C", "5C", "7C");

        assertFalse(r.IsStraightFlush(h));
        assertFalse(r.IsStraightFlush(h1));
    }

    @Test
    void isFourOfAKind_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "4D", "4S", "4H");

        assertTrue(r.IsFourOfAKind(h));
    }

    @Test
    void isFourOfAKind_ShouldReturnFalse() {
        Hand h = new Hand("4C", "8C", "3D", "4S", "4H");

        assertFalse(r.IsFourOfAKind(h));
    }

    @Test
    void isFullHouse_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "4D", "8S", "4H");

        assertTrue(r.IsFullHouse(h));
    }

    @Test
    void isFullHouse_ShouldReturnFalse() {
        Hand h = new Hand("4C", "4C", "4D", "8S", "4H");
        Hand h1 = new Hand("4C", "8C", "5D", "8S", "4H");

        assertFalse(r.IsFullHouse(h));
        assertFalse(r.IsFullHouse(h1));
    }

    @Test
    void isFlush_ShouldReturnTrue() {
        Hand h = new Hand("4S", "8S", "5S", "8S", "KS");

        assertTrue(r.IsFlush(h));
    }

    @Test
    void isFlush_ShouldReturnFalse() {
        Hand h = new Hand("4S", "8H", "5S", "8S", "KS");

        assertFalse(r.IsFlush(h));
    }

    @Test
    public void isStraight_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8D", "6C", "5H", "7C");
        Hand h1 = new Hand("JC", "TC", "KC", "AC", "QD");

        assertTrue(r.IsStraight(h));
        assertTrue(r.IsStraight(h1));
    }

    @Test
    public void isStraight_ShouldReturnFalse() {
        Hand h = new Hand("9C", "TC", "KC", "AC", "QD");
        Hand h1 = new Hand("3C", "8C", "6C", "5C", "7C");

        assertFalse(r.IsStraight(h));
        assertFalse(r.IsStraight(h1));
    }

    @Test
    void isThreeOfAKind_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "4D", "KS", "4H");

        assertTrue(r.IsThreeOfAKind(h));
    }

    @Test
    void isThreeOfAKind_ShouldReturnFalse() {
        Hand h = new Hand("4C", "4C", "3D", "4S", "4H");

        assertFalse(r.IsThreeOfAKind(h));
    }

    @Test
    public void isTwoPairs_ShouldReturnTrue() {
        Hand h = new Hand("4C", "7D", "6C", "4H", "7C");

        assertTrue(r.IsTwoPairs(h));
    }

    @Test
    public void isTwoPairs_ShouldReturnFalse() {
        Hand h = new Hand("TD", "TC", "KC", "AC", "QD");
        Hand h1 = new Hand("3C", "8C", "6C", "5C", "7C");

        assertFalse(r.IsTwoPairs(h));
        assertFalse(r.IsTwoPairs(h1));
    }

    @Test
    public void isOnePair_ShouldReturnTrue() {
        Hand h = new Hand("4C", "7D", "6C", "4H", "KC");

        assertTrue(r.IsOnePair(h));
    }

    @Test
    public void isOnePair_ShouldReturnFalse() {
        Hand h = new Hand("TD", "TC", "KC", "AC", "TD");
        Hand h1 = new Hand("4C", "7D", "6C", "4H", "7C");

        assertFalse(r.IsOnePair(h));
        assertFalse(r.IsOnePair(h1));
    }

    @Test
    public void straightFlashCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("JC", "TC", "KC", "AC", "QC");
        Hand p2hand = new Hand("3C", "8C", "6C", "5C", "7C");

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == -1);
    }

    @Test
    public void straightFlashCompare_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("3C", "8C", "6C", "5C", "7C");
        Hand p2hand = new Hand("JC", "TC", "KC", "AC", "QC");

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == 1);
    }

    @Test
    void fourOfAKindCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("4C", "8C", "4D", "4S", "4H");
        Hand p2hand = new Hand("2C", "KC", "2D", "2S", "2H");

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == -1);
    }

    @Test
    void fourOfAKindCompare_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("2C", "AC", "2D", "2S", "2H");
        Hand p2hand = new Hand("4C", "KC", "4D", "4S", "4H");

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == 1);
    }

    @Test
    void twoPairsCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("AH", "AC", "6C", "6S", "7H");
        Hand p2hand = new Hand("4H", "4C", "AD", "AS", "TH");

        assertTrue(r.TwoPairsCompare(p1hand, p2hand) == -1);
    }

    @Test
    void twoPairsCompare_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("4H", "4C", "AD", "AS", "TH");
        Hand p2hand = new Hand("AH", "AC", "6C", "6S", "7H");

        assertTrue(r.TwoPairsCompare(p1hand, p2hand) == 1);
    }

    @Test
    void onePairCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("2C", "KH", "4C", "4S", "TH");
        Hand p2hand = new Hand("4H", "KC", "7D", "4D", "7H");

        assertTrue(r.OnePairCompare(p1hand, p2hand) == -1);
    }

    @Test
    void onePairCompare_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("2C", "AC", "4C", "4S", "7H");
        Hand p2hand = new Hand("4H", "AH", "7D", "4D", "TH");

        assertTrue(r.OnePairCompare(p1hand, p2hand) == 1);
    }

    @Test
    void HighCard_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("4C", "AC", "3C", "KS", "7H");
        Hand p2hand = new Hand("4H", "KC", "7D", "2D", "AH");

        assertTrue(r.HighCard(p1hand, p2hand) == -1);
    }

    @Test
    void HighCard_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("2C", "AC", "4C", "4S", "7H");
        Hand p2hand = new Hand("4H", "AH", "7D", "4D", "TH");

        assertTrue(r.HighCard(p1hand, p2hand) == 1);
    }
}