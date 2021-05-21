class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ret = solution.numDecodings("226");
        System.out.println(ret);
    }

    public int numDecodings(String s, int count){
        if(s.charAt(0) == '1'){
            if(s.length() > 2){
                return count + this.numDecodings(s.substring(2));
            }else {
                return count + 1;
            }
        }else if(s.charAt(0) == '2'){
            if(s.length() > 2){
                if(s.charAt(1) > '6'){
                    return count;
                }else {
                    return count + this.numDecodings(s.substring(2));
                }
            }else {
                if(s.charAt(1) > '6'){
                    return count;
                }else {
                    return count + 1;
                }
            }
        }
        return 0;
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        if(s.charAt(0) == '1'){
            if(s.length() > 2){
                int right = this.numDecodings(s.substring(2));
                if(s.charAt(1) > '2'){
                    return right * 2;
                }else {
                    return this.numDecodings(s.substring(1), right) + right;
                }
            }else {
                if(s.charAt(1) == '0'){
                    return 1;
                }else {
                    return 2;
                }
            }
        }
        if(s.charAt(0) == '2'){
            if(s.charAt(1) <= '6'){
                if(s.length() > 2){
                    int right = this.numDecodings(s.substring(2));
                    if(s.charAt(1) > '2'){
                        return right * 2;
                    }else {
                        return this.numDecodings(s.substring(1), right) + right;
                    }
                }else {
                    if(s.charAt(1) == '0'){
                        return 1;
                    }else {
                        return 2;
                    }
                }
            }else {
                return this.numDecodings(s.substring(1));
            }
        }
        return this.numDecodings(s.substring(1));
    }
}