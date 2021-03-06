package leetcode_tags.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A website domain like "discuss.leetcode_tags.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode_tags.com", and at the lowest level, "discuss.leetcode_tags.com". When we visit a domain like "discuss.leetcode_tags.com", we will also visit the parent domains "leetcode_tags.com" and "com" implicitly.
 * <p>
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode_tags.com".
 * <p>
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 * <p>
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode_tags.com"]
 * Output:
 * ["9001 discuss.leetcode_tags.com", "9001 leetcode_tags.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode_tags.com". As discussed above, the subdomain "leetcode_tags.com" and "com" will also be visited. So they will all be visited 9001 times.
 * <p>
 * Example 2:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation:
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * <p>
 * Notes:
 * <p>
 * The length of cpdomains will not exceed 100.
 * The length of each domain name will not exceed 100.
 * Each address will have either 1 or 2 "." characters.
 * The input count in any count-paired domain will not exceed 10000.
 * The answer output can be returned in any order.
 */
public class Subdomain_Visit_Count {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> addressTimesMap = new HashMap<>();
            for (String domain : cpdomains) {
                String[] splitSpace = domain.split(" ");
                int times = Integer.parseInt(splitSpace[0]);
                String[] splitAddress = splitSpace[1].split("\\.");
                String tmp = "";
                for (int i = splitAddress.length - 1; i >= 0; i--) {
                    if (tmp.isEmpty()) {
                        tmp += splitAddress[i];
                    } else {
                        tmp = splitAddress[i] + "." + tmp;
                    }
                    addressTimesMap.put(tmp, addressTimesMap.getOrDefault(tmp, 0) + times);
                }
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : addressTimesMap.entrySet()) {
                res.add(entry.getValue() + " " + entry.getKey());
            }
            return res;
        }
    }
}
