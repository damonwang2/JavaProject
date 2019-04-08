package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");

        List<String> listPath = new ArrayList<>();

        for (String p: paths) {
            if (p == null || p.equals("") || p.equals(".")) {
                continue;
            }

            if (p.equals("..") && listPath.size() > 0) {
                listPath.remove(listPath.size() - 1);
            } else {
                listPath.add(p);
            }
        }

        if (listPath.size() == 0) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (String p : listPath) {
            res.append("/").append(p);
        }

        return res.toString();
    }
}
