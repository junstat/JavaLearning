package Q0499.Q0468ValidateIPAddress;

// Runtime: 1 ms, faster than 98.02% of Java online submissions for Validate IP Address.
public class Solution2 {
    public String validIPAddress(String queryIP) {
        String IPv4 = "IPv4";
        String IPv6 = "IPv6";
        String INVALID = "Neither";

        if (queryIP == null || queryIP.length() == 0) {
            return INVALID;
        }

        if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') {
            return INVALID;
        }
        if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
            return INVALID;
        }

        //split the string by . or :
        // String[] dots = queryIP.split(".");
        String[] dots = queryIP.split("\\.");
        String[] colons = queryIP.split(":");

        if (dots.length == 0 && colons.length == 0) {
            return INVALID;
        }

        if (dots.length == 4) {

            for (int i = 0; i < dots.length; i++) {
                if (!isValidIPv4Section(dots[i])) {
                    return INVALID;
                }
            }
            return IPv4;
        } else if (colons.length == 8) {
            for (int i = 0; i < colons.length; i++) {
                if (!isValidIPv6Section(colons[i])) {
                    return INVALID;
                }
            }
            return IPv6;
        } else {
            return INVALID;
        }
    }

    public boolean isValidIPv4Section(String section) {

        if (section.length() < 1 || section.length() > 3) {
            return false;
        }
        if (section.charAt(0) == '0' && section.length() == 1) {
            return true;
        }

        if (section.charAt(0) == '0') {
            return false;
        }

        int subnet = 0;
        for (int i = 0; i < section.length(); i++) {
            int digit = section.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                return false;
            }
            subnet = subnet * 10 + digit;
        }

        if (subnet < 1 || subnet > 255) {
            return false;
        }

        return true;
    }

    public boolean isValidHex(char input) {
        int digit = input - '0';
        if (digit >= 0 && digit <= 9) {
            return true;
        }
        digit = input - 'a';
        if (digit >= 0 && digit <= ('f' - 'a')) {
            return true;
        }
        digit = input - 'A';
        if (digit >= 0 && digit <= ('F' - 'A')) {
            return true;
        }
        return false;
    }

    public boolean isValidIPv6Section(String section) {
        if (section.length() < 1 || section.length() > 4) {
            return false;
        }

        for (int i = 0; i < section.length(); i++) {
            char current = section.charAt(i);
            if (!isValidHex(current)) {
                return false;
            }
        }
        return true;
    }
}
