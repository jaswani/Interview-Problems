package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jai on 1/8/16.
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible
 * results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        char[] c = s.toCharArray();
        int count = 0, i = 0;
        int lastIndex = 0;
        boolean setbreak = false;
        List<String> returnList = new ArrayList<>();
        while (i < c.length) {
            char curr = c[i++];
            if (curr == '(') count++;
            else if (curr == ')') count--;
            //check counts
            if (count == -1) {
                while (i < c.length && c[i++] == ')') ;
//                String toFix = null;
                if (c[i - 1] != ')') {
//                    toFix = s.substring(lastIndex, i);
                    i--;
                }

                // now we need to call fixExtraClosingBracket
                if (returnList.isEmpty()) {
                    returnList.addAll(fixExtraClosingBracket(s.substring(lastIndex, i)));
                } else {
                    Set<String> newReturnSet = new HashSet<>();
                    for (String l : returnList) {
                        newReturnSet.addAll(fixExtraClosingBracket(l + s.substring(lastIndex, i)));
                    }
                    returnList.clear();
                    returnList.addAll(newReturnSet);
                }
                count = 0;
                lastIndex = i;
            }
            if (setbreak) break;
        }
        if (count == 0) {
            if (returnList.isEmpty()) {
                returnList.add(s);
            } else {
                for (int x = 0; x < returnList.size(); x++) {
                    returnList.set(x, returnList.get(x) + s.substring(lastIndex));
                }
            }
        } else if (count > 0) {
            //excess open brackets...
            List<String> rList = removeInvalidParentheses(reverse(s.substring(lastIndex)));
            if (returnList.isEmpty()) {
                for (String p : rList) {
                    returnList.add(reverse(p));
                }
            } else {
                List<String> newReturnList = new ArrayList<>();
                for (String prefix : returnList) {
                    for (String postfix : rList) {
                        newReturnList.add(prefix + reverse(postfix));
                    }
                }
                returnList = newReturnList;
            }
        }
        return returnList;
    }

    public List<String> fixExtraClosingBracket(String s) {
        int count = 0;
        Set<String> validSet = new HashSet<>();
        String firstValidString = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') count--;
            else continue;
            if (count == -1) {
                if (firstValidString == null) {
                    firstValidString = s.substring(0, i);
                    Set<String> r = fixOneExtraClosingBracket(s.substring(0, i + 1), false);
                    validSet.addAll(r);
                } else {
                    List<String> newReturnList = new ArrayList<>();
                    for (String x : validSet) {
                        newReturnList.addAll(fixOneExtraClosingBracket(x + ')', false));
                    }
                    validSet.addAll(newReturnList);
                }
                count = 0; //reset count
            }
        }
        List<String> returnList = new ArrayList<>();
        returnList.add(firstValidString);
        returnList.addAll(validSet);
        return returnList;
    }

    //This function can fix strings with 1 extra )
    public Set<String> fixOneExtraClosingBracket(String s, boolean addFirst) {
        Set<String> validSet = new HashSet<>();
        String validStr = s.substring(0, s.length() - 1);
        if (addFirst) validSet.add(validStr);
        if (validStr.isEmpty()) return validSet;
        int processLength = validStr.length() - 1;
        while (validStr.charAt(processLength) == ')') processLength--;
        int i = 0;
        while (i <= processLength) {
            if (validStr.charAt(i) == ')') {
                validSet.add(validStr.substring(0, i) + validStr.substring(i + 1) + ')');
                while (i <= processLength && validStr.charAt(i) == ')') i++;
                continue;
            }
            i++;
        }
        return validSet;
    }

    // public void print(Collection<String> list) {
    //     for (String s : list) {
    //         System.out.println(s);
    //     }
    // }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == '(') sb.append(')');
            else if (c[i] == ')') sb.append('(');
            else sb.append(c[i]);
        }
        return sb.toString();
    }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
// //        sol.print(sol.fixOneExtraClosingBracket(s, true));
// //        sol.print(sol.removeInvalidParentheses(s));

//         sol.test("))", Arrays.asList(""));
//         sol.test(")(", Arrays.asList(""));
//         sol.test("((()a)", Arrays.asList("(()a)"));
//         sol.test("(a()))", Arrays.asList("(a())"));
//         sol.test("()())()", Arrays.asList("(())()", "()()()"));
//         sol.test("(a)())()", Arrays.asList("(a())()", "(a)()()"));
//         sol.test("()()()))(()()", Arrays.asList("((()))()()", "((()))(())", "(()())()()", "(()())(())", "()(())()()",
//                 "()(())(())",
//                 "()()()()()", "()()()(())"));
//         sol.test("()()()))()(()()", Arrays.asList("((()))()()()", "((()))()(())", "(()())()()()", "(()())()(())",
//                 "()(())()()()", "()(())()(())", "()()()()()()", "()()()()(())"));
//         sol.test(")(())(0()90))(()()", Arrays.asList("(()(0()90))()()","(()(0()90))(())","(())(0(90))()()",
//                 "(())(0(90))(())","(())(0()90)()()","(())(0()90)(())"));
//         sol.test("()())()", Arrays.asList("(())()","()()()"));
//         sol.test("x(", Arrays.asList("x"));
//         sol.test(")x", Arrays.asList("x"));
// //        sol.test(, Arrays.asList());
//     }

    // public void test(String s, List<String> result) {
    //     System.out.println("Input: " + s);
    //     boolean outcome = true;
    //     Set<String> set = new HashSet<>();
    //     set.addAll(removeInvalidParentheses(s));
    //     for (String r : result) {
    //         if (!set.contains(r)) {
    //             outcome = false;
    //             System.out.println("Not found: " + r);
    //             break;
    //         }
    //     }
    //     System.out.println("Result: " + outcome);
    //     if (!outcome) print(set);
    // }
}
