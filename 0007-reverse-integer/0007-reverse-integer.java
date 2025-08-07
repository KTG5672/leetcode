class Solution {
    public int reverse(int x) {
        int input = x;
        boolean isNegative = x < 0;
        if (input == 0) {
            return 0;
        }
        input = Math.abs(input);
        int startPlace = getMaxPlace(input);
        int result = 0;
        int sourcePlace = startPlace;
        int targetPlace = 1;
        while (sourcePlace != 0) {
            int digit =  input / sourcePlace;
            long check = (long) result + ((long) digit * (long) targetPlace);
            if (check > Integer.MAX_VALUE || isNegative && ((check * -1) < Integer.MIN_VALUE)) {
                return 0;
            }
            result += digit * targetPlace;
            targetPlace = targetPlace * 10;
            input = input % sourcePlace;
            if (input == 0) break;
            sourcePlace = sourcePlace / 10;
        }
        result = isNegative ? result * -1 : result;
        return result;
    }

    private int getMaxPlace(int input) {
        long place = 1;
        while (input >= place) {
            place = place * 10;
        }
        place = place / 10;
        return (int) place;
    }
}