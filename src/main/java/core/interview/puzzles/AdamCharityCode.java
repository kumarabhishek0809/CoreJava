package core.interview.puzzles;

public class AdamCharityCode {
    public static void main(String[] args) {

    }

    public int charity(int noOfDays){
        int charity = 0;
        for (int day =1; day<=noOfDays;day++){
            charity= charity + (day*day);
        }
        return charity;
    }
}
