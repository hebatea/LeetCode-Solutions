class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfDigit(n);
        if(slow == 1||fast == 1) return true;
        System.out.println(slow + "::" + fast);
        while(slow != fast){
            slow = sumOfDigit(slow);
            fast = sumOfDigit(sumOfDigit(fast));
            if(slow == 1 || fast == 1) return true;
            System.out.println(slow + "::" + fast);

        }

        return false;

    }

    private int sumOfDigit(int n){
        String number = ""; number += n;
        int sum = 0;
        for(int i = 0; i < number.length(); i++){
            int cur = Character.getNumericValue(number.charAt(i)); 
            sum += cur*cur;
        }
        return sum;
    }
}