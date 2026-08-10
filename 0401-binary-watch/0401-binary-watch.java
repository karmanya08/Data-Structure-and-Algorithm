class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> answer = new ArrayList<>();
        int[] leds = new int[10];

        backtrack(0, 0, turnedOn, leds, answer);

        return answer;
    }

    public void backtrack(int index, int count, int turnedOn,
                          int[] leds, List<String> answer) {

        if (count == turnedOn) {

            int hour = 0;
            int minute = 0;

            // First 4 LEDs represent hours
            for (int i = 0; i < 4; i++) {
                if (leds[i] == 1) {
                    hour += (1 << i);
                }
            }
            // Last 6 LEDs represent minutes
            for (int i = 4; i < 10; i++) {
                if (leds[i] == 1) {
                    minute += (1 << (i - 4));
                }
            }

            if (hour <= 11 && minute <= 59) {
                String time = hour + ":" + String.format("%02d", minute);
                answer.add(time);
            }

            return;
        }

        if (index == 10) {
            return;
        }

        // Turn current LED ON
        leds[index] = 1;
        backtrack(index + 1, count + 1, turnedOn, leds, answer);

        // Turn current LED OFF
        leds[index] = 0;
        backtrack(index + 1, count, turnedOn, leds, answer);
    }
}