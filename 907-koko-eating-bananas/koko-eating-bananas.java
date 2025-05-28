class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1, r = max;
        int result = max;

        while(l<=r){
            int mid = l + (r-l)/2;

            int he = getTotalHours(piles, mid);

            if (he <= h) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    int getTotalHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / k);
        }
        return hours;
    }
}