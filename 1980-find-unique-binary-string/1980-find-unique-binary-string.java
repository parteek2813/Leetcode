class Solution {

    public String findDifferentBinaryString(String[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (String num : nums)
            set.add(Integer.parseInt(num, 2));

        for (int i = 0; i <= nums.length; i++)
            if (!set.contains(i)) return convertToBinary(i, nums.length);

        return "";

    }

    public String convertToBinary(int number, int n) {
        String binaryString = Integer.toBinaryString(number);
        return "0".repeat(n - binaryString.length()) + Integer.toBinaryString(number);
    }

}