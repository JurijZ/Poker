package com.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {


    @Test
    public void FirstLevelEvaluator_ShouldReturnHandRating(){

        Hand h = new Hand("8C", "TS", "KC", "9H", "4S");
        Rules r = new Rules();
        var rating = r.RankEvaluator(h);

        assertEquals(0, rating);
    }

    @Test
    public void IsRoyalFlash_ShouldReturnTrue(){

        Hand h = new Hand("JC", "TC", "KC", "AC", "QC");
        Rules r = new Rules();

        assertTrue(r.IsRoyalFlash(h));
    }

    @Test
    public void IsRoyalFlash_ShouldReturnFalse(){

        Hand h = new Hand("JC", "TC", "KC", "AC", "QD");
        Rules r = new Rules();

        assertFalse(r.IsRoyalFlash(h));
    }

    @Test
    public void isStraightFlush_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "6C", "5C", "7C");
        Rules r = new Rules();

        assertTrue(r.IsStraightFlush(h));
    }

    @Test
    public void isStraightFlush_ShouldReturnFalse() {
        Hand h = new Hand("JC", "TC", "KC", "AC", "QD");
        Hand h1 = new Hand("3C", "8C", "6C", "5C", "7C");
        Rules r = new Rules();

        assertFalse(r.IsStraightFlush(h));
        assertFalse(r.IsStraightFlush(h1));
    }

    @Test
    void isFourOfAKind_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "4D", "4S", "4H");
        Rules r = new Rules();

        assertTrue(r.IsFourOfAKind(h));
    }

    @Test
    void isFourOfAKind_ShouldReturnFalse() {
        Hand h = new Hand("4C", "8C", "3D", "4S", "4H");
        Rules r = new Rules();

        assertFalse(r.IsFourOfAKind(h));
    }

    @Test
    void isFullHouse_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "4D", "8S", "4H");
        Rules r = new Rules();

        assertTrue(r.IsFullHouse(h));
    }

    @Test
    void isFullHouse_ShouldReturnFalse() {
        Hand h = new Hand("4C", "4C", "4D", "8S", "4H");
        Rules r = new Rules();

        assertFalse(r.IsFullHouse(h));
    }

    @Test
    void isFlush_ShouldReturnTrue() {
        Hand h = new Hand("4S", "8S", "5S", "8S", "KS");
        Rules r = new Rules();

        assertTrue(r.IsFlush(h));
    }

    @Test
    void isFlush_ShouldReturnFalse() {
        Hand h = new Hand("4S", "8H", "5S", "8S", "KS");
        Rules r = new Rules();

        assertFalse(r.IsFlush(h));
    }

    @Test
    public void isStraight_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8D", "6C", "5H", "7C");
        Hand h1 = new Hand("JC", "TC", "KC", "AC", "QD");
        Rules r = new Rules();

        assertTrue(r.IsStraight(h));
        assertTrue(r.IsStraight(h1));
    }

    @Test
    public void isStraight_ShouldReturnFalse() {
        Hand h = new Hand("9C", "TC", "KC", "AC", "QD");
        Hand h1 = new Hand("3C", "8C", "6C", "5C", "7C");
        Rules r = new Rules();

        assertFalse(r.IsStraight(h));
        assertFalse(r.IsStraight(h1));
    }

    @Test
    void isThreeOfAKind_ShouldReturnTrue() {
        Hand h = new Hand("4C", "8C", "4D", "KS", "4H");
        Rules r = new Rules();

        assertTrue(r.IsThreeOfAKind(h));
    }

    @Test
    void isThreeOfAKind_ShouldReturnFalse() {
        Hand h = new Hand("4C", "4C", "3D", "4S", "4H");
        Rules r = new Rules();

        assertFalse(r.IsThreeOfAKind(h));
    }

    @Test
    public void isTwoPairs_ShouldReturnTrue() {
        Hand h = new Hand("4C", "7D", "6C", "4H", "7C");
        Rules r = new Rules();

        assertTrue(r.IsTwoPairs(h));
    }

    @Test
    public void isTwoPairs_ShouldReturnFalse() {
        Hand h = new Hand("TD", "TC", "KC", "AC", "QD");
        Hand h1 = new Hand("3C", "8C", "6C", "5C", "7C");
        Rules r = new Rules();

        assertFalse(r.IsTwoPairs(h));
        assertFalse(r.IsTwoPairs(h1));
    }

    @Test
    public void isOnePair_ShouldReturnTrue() {
        Hand h = new Hand("4C", "7D", "6C", "4H", "KC");
        Rules r = new Rules();

        assertTrue(r.IsOnePair(h));
    }

    @Test
    public void isOnePair_ShouldReturnFalse() {
        Hand h = new Hand("TD", "TC", "KC", "AC", "TD");
        Hand h1 = new Hand("4C", "7D", "6C", "4H", "7C");
        Rules r = new Rules();

        assertFalse(r.IsOnePair(h));
        assertFalse(r.IsOnePair(h1));
    }

    @Test
    public void straightFlashCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("JC", "TC", "KC", "AC", "QD");
        Hand p2hand = new Hand("3C", "8C", "6C", "5C", "7C");
        Rules r = new Rules();

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == -1);
    }

    @Test
    public void straightFlashCompare_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("3C", "8C", "6C", "5C", "7C");
        Hand p2hand = new Hand("JC", "TC", "KC", "AC", "QD");
        Rules r = new Rules();

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == 1);
    }

    @Test
    void fourOfAKindCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("4C", "8C", "4D", "4S", "4H");
        Hand p2hand = new Hand("2C", "KC", "2D", "2S", "2H");
        Rules r = new Rules();

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == -1);
    }

    @Test
    void fourOfAKindCompare_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("2C", "AC", "2D", "2S", "2H");
        Hand p2hand = new Hand("4C", "KC", "4D", "4S", "4H");
        Rules r = new Rules();

        assertTrue(r.StraightFlashCompare(p1hand, p2hand) == 1);
    }

    @Test
    void onePairCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("2C", "AC", "4C", "4S", "7H");
        Hand p2hand = new Hand("4H", "KC", "7D", "4D", "TH");
        Rules r = new Rules();

        assertTrue(r.OnePairCompare(p1hand, p2hand) == -1);
    }

    @Test
    void onePairCompare_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("2C", "AC", "4C", "4S", "7H");
        Hand p2hand = new Hand("4H", "AH", "7D", "4D", "TH");
        Rules r = new Rules();

        assertTrue(r.OnePairCompare(p1hand, p2hand) == 1);
    }

    @Test
    void HighCard_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("2C", "AC", "3C", "KS", "7H");
        Hand p2hand = new Hand("4H", "KC", "7D", "2D", "TH");
        Rules r = new Rules();

        assertTrue(r.HighCard(p1hand, p2hand) == -1);
    }

    @Test
    void HighCard_ShouldReturnPlayer2() {
        Hand p1hand = new Hand("2C", "AC", "4C", "4S", "7H");
        Hand p2hand = new Hand("4H", "AH", "7D", "4D", "TH");
        Rules r = new Rules();

        assertTrue(r.HighCard(p1hand, p2hand) == 1);
    }

    @Test
    void twoPairsCompare_ShouldReturnPlayer1() {
        Hand p1hand = new Hand("AH", "AC", "6C", "6S", "7H");
        Hand p2hand = new Hand("4H", "4C", "AD", "AS", "TH");
        Rules r = new Rules();

        assertTrue(r.TwoPairsCompare(p1hand, p2hand) == -1);
    }
}