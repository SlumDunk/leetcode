package com.github.leetcode.easy;

import java.util.*;

/**
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * <p>
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * <p>
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 * <p>
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode.com"]
 * Output:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 * <p>
 * Example 2:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation:
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 */
public class Leetcode811 {
    public static void main(String[] args) {
        Leetcode811 leetcode811 = new Leetcode811();
        String[] cpdomains = new String[]{"2777 nak.mkw.co", "654 yaw.lmm.ca", "3528 jyx.arz.us", "3215 bll.hoh.network", "408 tdt.zfz.network", "3322 xhe.team", "8342 srp.team", "9259 bfo.net", "3875 brk.ato.network", "2531 mce.ser.com", "2471 czb.us", "4806 xss.dfa.co", "654 yls.yjt.co", "767 irh.epf.us", "1501 ara.ca", "243 qay.network", "9103 vbo.org", "6890 bfo.network", "4296 xtb.jre.us", "2329 vva.qay.network", "9846 fuw.org", "4681 lwf.ytn.network", "1781 lbk.ksc.co", "7464 jpd.fff.co", "2740 xhe.org", "4602 weq.buf.team", "3055 fdy.jkx.com", "5705 mqa.wsv.net", "6629 vdu.bfo.team", "9897 lra.uyy.org", "8167 ahm.jre.team", "9374 jep.ato.co", "3624 vmv.epf.network", "6865 thk.net", "6920 tlc.dfa.us", "9372 hci.jia.network", "7968 gjf.network", "7292 zbl.ksc.net", "2862 coh.sci.net", "3855 yjt.network", "1387 hju.gbq.org", "817 sgp.htq.co", "2406 hkb.ocf.co", "622 wmt.cwn.net", "9172 zfz.net", "1523 suq.bhp.co", "9581 gqi.team", "2160 hsj.epf.org", "32 ulz.com", "1225 lmm.ca", "1137 ujs.qzi.co", "5041 cdf.hwu.us", "4126 lir.ajl.team", "3111 gdw.team", "8928 arz.org", "9531 hoh.co", "7344 czb.com", "2715 ubt.okv.us", "1110 kdd.znq.us", "5729 srp.com", "6122 nqk.srp.org", "7193 xth.fzx.ca", "3496 ytn.com", "3950 xuf.network", "4521 weh.bfo.us", "3262 mor.ixi.us", "4975 okv.com", "7089 ske.yls.com", "4198 xfs.okv.co", "2444 vks.gxz.team", "1789 xcf.zqy.ca", "7392 uyy.net", "3449 tfm.us", "5907 zfz.us", "9530 omu.network", "3314 ytd.hkt.net", "9523 wyv.cgl.network", "4439 gtu.us", "8390 zqk.network", "1627 bhp.ca", "3609 bhp.team", "8557 uai.lfn.net", "2913 ret.ych.ca", "2447 ksc.com", "7476 cze.yvr.net", "8544 xrj.bhp.com", "6129 hkt.com", "8274 ulz.co", "9219 tfm.ca", "5016 zwv.gqi.co", "5738 lar.bfo.team", "3377 jkx.network", "2979 bhp.org", "8176 ujm.gqs.ca", "84 lmm.network", "3090 ycc.yjt.us", "7042 btv.com", "2965 gxj.org", "8263 cwn.org", "1873 kse.gjf.ca"};
        System.out.println(leetcode811.subdomainVisits(cpdomains));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        //遍历字符串数组，对每个字符串进行切割处理，然后放进map里头
        Map<String, Integer> map = new HashMap<String, Integer>();
        int count = 0;
        String[] cp = new String[2];
        for (int i = 0; i < cpdomains.length; i++) {
            cp = cpdomains[i].split(" ");
            count = Integer.valueOf(cp[0]);
            //注意正则表达式
            String[] domains = cp[1].split("\\.");
            String tmp = "";
            for (int j = domains.length - 1; j >= 0; j--) {
                tmp = generateDomain(tmp, domains[j]);
                map.put(tmp, map.getOrDefault(tmp, 0) + count);
            }
        }
        //遍历map，放进结果集合里头
        List<String> resultList = new ArrayList<String>();
        for (String key : map.keySet()) {
            resultList.add(map.get(key) + " " + key);
        }
        return resultList;
    }

    /**
     * 构造域名
     *
     * @param parentDomain 父级域名
     * @param childDomain  子级域名
     * @return
     */
    public String generateDomain(String parentDomain, String childDomain) {
        if ("".equals(parentDomain)) {
            return childDomain;
        } else {
            return childDomain + "." + parentDomain;
        }
    }
}
