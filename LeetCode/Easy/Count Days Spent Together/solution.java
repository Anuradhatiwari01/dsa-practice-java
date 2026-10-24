
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int[] prefix = new int[13];

        for (int i = 1; i <= 12; i++) {
            prefix[i] = prefix[i - 1] + days[i - 1];
        }

        int aliceStart = getDay(arriveAlice, prefix);
        int aliceEnd = getDay(leaveAlice, prefix);
        int bobStart = getDay(arriveBob, prefix);
        int bobEnd = getDay(leaveBob, prefix);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    private int getDay(String date, int[] prefix) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        return prefix[month - 1] + day;
    }
}
