package com.LeetCode.June;

public class ValidateIPAddress {

    public static void main(String... a) {
        Solution sol = new Solution();
        System.out.println(sol.validIPAddress("15.16.-0.1"));
    }
    static class Solution {
        public String validIPAddress(String IP) {
            if(IP == null || IP.length() ==0){
                return "Neither";
            }
            if (IP.contains(".")) {
                return processIPV4(IP);
            } else {
                return processIPV6(IP);
            }
        }

        private String processIPV6(String ip) {
            if(ip.charAt(ip.length()-1) == ':'){
                return "Neither";
            }
            String[] arr = ip.split(":");
            if (arr.length != 8) {
                return "Neither";
            }
            for (String str : arr) {
                // str = str.toUpperCase();
                if (str.length() > 4 || str.length()==0) {
                    return "Neither";
                }
                for (char ch : str.toCharArray()) {
                    if (!isHex2(ch)) {
                        return "Neither";
                    }
                }

            }
            return "IPv6";
        }

        private String processIPV4(String ip) {
            if(ip.charAt(ip.length()-1) == '.'){
                return "Neither";
            }
            String[] arr = ip.split("\\.");
            if (arr.length != 4) {
                return "Neither";
            }
            for (String str : arr) {
                if (str.length() > 3) {
                    return "Neither";
                }
                int val = -1;
                try {
                    for(int i=0; i<str.length(); i++){
                        if(str.charAt(i) == '0' || str.charAt(i) == '-'){
                            return "Neither";
                        }else{
                            break;
                        }
                    }
                    val = Integer.parseInt(str);
                } catch (Exception e) {
                    return "Neither";
                }
                if (val > 255 || val < 0) {
                    return "Neither";
                }

            }
            return "IPv4";

        }

        private boolean isHex2(char c) {
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                    return true;
                default:
                    return false;
            }
        }
    }
}
