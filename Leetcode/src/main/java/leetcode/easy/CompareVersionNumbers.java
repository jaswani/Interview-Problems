package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of
 * the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int iter = 0;
        while(iter < v1.length  && iter < v2.length) {
            if (convertToInt(v1[iter]) > convertToInt(v2[iter])) {
                return 1;
            } else if(convertToInt(v1[iter]) < convertToInt(v2[iter])) {
                return -1;
            }
            iter++;
        }
        for(; iter < v1.length; iter++) {
            if(convertToInt(v1[iter]) > 0) {
                return 1;
            }
        }
        for(; iter < v2.length; iter++) {
            if(convertToInt(v2[iter]) > 0) {
                return -1;
            }
        }
        return 0;

    }

    public int convertToInt(String version) {
        if(version.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < version.length(); i++) {
            sum = sum*10 + Character.getNumericValue(version.charAt(i));
        }
        return sum;
    }
}
