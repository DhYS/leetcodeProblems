public class Divide2Integers{
    public int divide(int dividend, int divisor) {
 	  // take care of sign
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) { 
            // one of numbers is negative
            sign = -1;
        }
        
        // treat numbers as both positive
        long dDend = Math.abs((long) dividend);
        long dSor = Math.abs((long) divisor);
        long ans = helper(dDend, dSor);
        
        int res;
        // corner cases
        if (ans > Integer.MAX_VALUE) {
            res = (sign > 0) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
        } else {
            res = ((int)ans) * sign;
        }
        return res;
    }
    private long helper(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        
        long sum = divisor;
        long mult = 1;
        while ((sum + sum) < dividend) {
            sum += sum;
            mult += mult;
        }
        return mult + helper(dividend - sum, divisor);
    }
}
