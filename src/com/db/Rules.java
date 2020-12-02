package com.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rules {

    public Integer RankEvaluator(Hand hand){
        // Check from the highest to lowest
        if (IsRoyalFlash(hand)){
            return 9;
        }
        else if (IsStraightFlush(hand)){
            return 8;
        }
        else if (IsFourOfAKind(hand)){
            return 7;
        }
        else if (IsFullHouse(hand)){
            return 6;
        }
        else if (IsFlush(hand)){
            return 5;
        }
        else if (IsStraight(hand)){
            return 4;
        }
        else if (IsThreeOfAKind(hand)){
            return 3;
        }
        else if (IsTwoPairs(hand)){
            return 2;
        }
        else if (IsOnePair(hand)){
            return 1;
        }
        else {
            return 0;
        }
    }

    public Integer EqualRankEvaluator(Integer rank, Hand p1hand, Hand p2hand) {
        Integer winner = 0;

        // Check from the highest to lowest
        switch(rank) {
            case 9:
                winner = RoyalFlashCompare(p1hand, p2hand);
                break;
            case 8:
                winner = StraightFlashCompare(p1hand, p2hand);
                break;
            case 7:
                winner = FourOfAKindCompare(p1hand, p2hand);
                break;
            case 6:
                winner = FullHouseCompare(p1hand, p2hand);
                break;
            case 5:
                winner = FlushCompare(p1hand, p2hand);
                break;
            case 4:
                winner = StraightCompare(p1hand, p2hand);
                break;
            case 3:
                winner = ThreeOfAKindCompare(p1hand, p2hand);
                break;
            case 2:
                winner = TwoPairsCompare(p1hand, p2hand);
                break;
            case 1:
                winner = OnePairCompare(p1hand, p2hand);
                break;
            case 0:
                winner = HighCard(p1hand, p2hand);
                break;
            default:
                winner = 0;
        }

        return winner;
    }



    public Integer HighCard(Hand p1hand, Hand p2hand) {
        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();

        // Compare highest remaining cards
        var winner = 0;
        for (int i = list1.size(); i-- > 0; ) {
            var v1 = list1.get(i);
            var v2 = list2.get(i);

            if (v1 > v2){
                winner =  -1;
                break;
            }
            else if (v1 < v2){
                winner =  1;
                break;
            }
        }

        return winner;
    }

    public Integer OnePairCompare(Hand p1hand, Hand p2hand) {
        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var set1OfValues = p1hand.GetHashSetOfValuesAsIntegers();
        Integer p1same2 = 0;

        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();
        var set2OfValues = p2hand.GetHashSetOfValuesAsIntegers();
        Integer p2same2 = 0;


        for (Integer v: set1OfValues){
            if (Collections.frequency(list1, v) == 2){
                p1same2 = v;
            }
        }

        for (Integer v: set2OfValues){
            if (Collections.frequency(list2, v) == 2){
                p2same2 = v;
            }
        }

        if( p1same2 > p2same2 ){
            return -1;
        }
        else if ( p1same2 < p2same2 ){
            return 1;
        }
        else{
            // Compare highest remaining cards
            var winner = 0;
            for (int i = list1.size(); i-- > 0; ) {
                var v1 = list1.get(i);
                var v2 = list2.get(i);

                if (v1 > v2){
                    winner = -1;
                    break;
                }
                else if (v1 < v2){
                    winner = 1;
                    break;
                }
            }

            return winner;
        }

    }

    public Integer TwoPairsCompare(Hand p1hand, Hand p2hand) {
        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var set1OfValues = p1hand.GetHashSetOfValuesAsIntegers();
        List<Integer> p1same2 = new ArrayList();
        Integer p1remaining = 2;

        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();
        var set2OfValues = p2hand.GetHashSetOfValuesAsIntegers();
        List<Integer> p2same2 = new ArrayList();
        Integer p2remaining = 2;

        for (Integer v: set1OfValues){
            if (Collections.frequency(list1, v) == 2){
                p1same2.add(v);
            }
            if (Collections.frequency(list1, v) == 1){
                p1remaining = v;
            }
        }

        for (Integer v: set2OfValues){
            if (Collections.frequency(list2, v) == 2){
                p2same2.add(v);
            }
            if (Collections.frequency(list1, v) == 1){
                p2remaining = v;
            }
        }

        if( Collections.max(p1same2) > Collections.max(p2same2) ){
            return -1;
        }
        else if ( Collections.max(p1same2) < Collections.max(p2same2) ){
            return 1;
        }
        else{
            if( Collections.min(p1same2) > Collections.min(p2same2) ){
                return -1;
            }
            else if ( Collections.min(p1same2) < Collections.min(p2same2) ){
                return 1;
            }
            else if ( p1remaining > p2remaining){
                return -1;
            }
            else if ( p1remaining < p2remaining){
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public Integer ThreeOfAKindCompare(Hand p1hand, Hand p2hand) {
        throw new Error("This is impossible");
    }

    public Integer StraightCompare(Hand p1hand, Hand p2hand) {
        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();

        if( Collections.max(list1) > Collections.max(list2) ){
            return -1;
        }
        else if( Collections.max(list1) < Collections.max(list2) ){
            return 1;
        }
        else {
            return 0;
        }
    }

    public Integer FlushCompare(Hand p1hand, Hand p2hand) {
        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();

        if( Collections.max(list1) > Collections.max(list2) ){
            return -1;
        }
        else if( Collections.max(list1) < Collections.max(list2) ){
            return 1;
        }
        else {
            return 0;
        }
    }

    public Integer FullHouseCompare(Hand p1hand, Hand p2hand) {
        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var set1OfValues = p1hand.GetHashSetOfValuesAsIntegers();
        Integer p1same3 = 0;

        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();
        var set2OfValues = p2hand.GetHashSetOfValuesAsIntegers();
        Integer p2same3 = 0;

        for (Integer v: set1OfValues){
            if (Collections.frequency(list1, v) == 3){
                p1same3 = v;
            }
        }

        for (Integer v: set2OfValues){
            if (Collections.frequency(list2, v) == 3){
                p2same3 = v;
            }
        }

        if( p1same3 > p2same3 ){
            return -1;
        }
        else if ( p1same3 < p1same3 ){
            return 1;
        }
        else{
            return 0;
        }
    }

    public Integer FourOfAKindCompare(Hand p1hand, Hand p2hand) {

        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var set1OfValues = p1hand.GetHashSetOfValuesAsIntegers();
        Integer p1same4 = 0;

        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();
        var set2OfValues = p2hand.GetHashSetOfValuesAsIntegers();
        Integer p2same4 = 0;

        for (Integer v: set1OfValues){
            if (Collections.frequency(list1, v) == 4){
                p1same4 = v;
            }
        }

        for (Integer v: set2OfValues){
            if (Collections.frequency(list2, v) == 4){
                p2same4 = v;
            }
        }

        if( p1same4 > p2same4 ){
            return -1;
        }
        else if ( p1same4 < p1same4 ){
            return 1;
        }
        else{
            return 0;
        }
    }

    public Integer StraightFlashCompare(Hand p1hand, Hand p2hand) {

        var list1 = p1hand.GetOrderedListOfValuesAsIntegers();
        var list2 = p2hand.GetOrderedListOfValuesAsIntegers();

        if( list1.get(0) > list2.get(0) ){
            return -1;
        }
        else if (list1.get(0) < list2.get(0)){
            return 1;
        }
        else{
            return 0;
        }
    }

    public Integer RoyalFlashCompare(Hand p1hand, Hand p2hand) {
        return 0;
    }

    public boolean IsOnePair(Hand hand){

        var setOfValues = hand.GetHashSetOfValues();
        var listOfValues = hand.GetOrderedListOfValues();
        Integer pairs = 0;

        for (Character c: setOfValues){
            if (Collections.frequency(listOfValues, c) == 2){
                pairs = pairs + 1;
            }
        }

        if (pairs == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean IsTwoPairs(Hand hand){

        var setOfValues = hand.GetHashSetOfValues();
        if (setOfValues.size() != 3){
            return false;
        }

        var listOfValues = hand.GetOrderedListOfValues();
        Integer pairs = 0;

        for (Character c: setOfValues){
            if (Collections.frequency(listOfValues, c) == 2){
                pairs = pairs + 1;
            }
        }

        if (pairs == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean IsThreeOfAKind(Hand hand){
        var listOfValues = hand.GetOrderedListOfValues();
        var setOfValues = hand.GetHashSetOfValues();

        for (Character c: setOfValues){
            if (Collections.frequency(listOfValues, c) == 3){
                return true;
            }
        }

        return false;
    }

    public boolean IsStraight(Hand hand){

        // Check that the values are consecutive
        var o = hand.GetOrderedListOfValuesAsIntegers();
        if(o.get(0) - o.get(1) == -1 &&
                o.get(1) - o.get(2) == -1 &&
                o.get(2) - o.get(3) == -1 &&
                o.get(3) - o.get(4) == -1 ){
            return true;
        }

        return false;
    }

    public boolean IsFlush(Hand hand){
        var setOfSuit = hand.GetHashSetOfSuit();

        // Check that all cards are of the same suit
        if (setOfSuit.size() == 1){
            return true;
        }

        return false;
    }

    public boolean IsFullHouse(Hand hand){

        var setOfValues = hand.GetHashSetOfValues();
        if (setOfValues.size() != 2){
            return false;
        }

        var listOfValues = hand.GetOrderedListOfValues();
        Integer three = 0;
        Integer two = 0;

        for (Character c: setOfValues){
            if (Collections.frequency(listOfValues, c) == 3){
                three = 3;
            }
            if (Collections.frequency(listOfValues, c) == 2){
                two = 2;
            }
        }

        if (three == 3 && two == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean IsFourOfAKind(Hand hand){
        var listOfValues = hand.GetOrderedListOfValues();
        var setOfValues = hand.GetHashSetOfValues();

        for (Character c: setOfValues){
            if (Collections.frequency(listOfValues, c) == 4){
                return true;
            }
        }

        return false;
    }

    public boolean IsStraightFlush(Hand hand){
        var setOfSuit = hand.GetHashSetOfSuit();

        // Check that all cards are of the same suit
        if (setOfSuit.size() > 1){
            return false;
        }

        // Check that the values are from the StraightFlush sequence
        var o = hand.GetOrderedListOfValuesAsIntegers();
        if(o.get(0) - o.get(1) == -1 &&
                o.get(1) - o.get(2) == -1 &&
                o.get(2) - o.get(3) == -1 &&
                o.get(3) - o.get(4) == -1 ){
            return true;
        }

        return false;
    }

    public boolean IsRoyalFlash(Hand hand){
        var setOfSuit = hand.GetHashSetOfSuit();

        // Check that all cards are of the same suit
        if (setOfSuit.size() > 1){
            return false;
        }

        // Check that the values are from the Royal Flash sequence
        var o = hand.GetOrderedListOfValues();
        if(o.get(0) == 'A' && o.get(1) == 'J' && o.get(2) == 'K' && o.get(3) == 'Q' && o.get(4) == 'T'){
            return true;
        }

        return false;
    }


}
