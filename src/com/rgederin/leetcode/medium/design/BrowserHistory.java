package com.rgederin.leetcode.medium.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 1472. Design Browser History
 * <p>
 * Runtime: 49 ms, faster than 46.31% of Java online submissions for Design Browser History. Memory
 * Usage: 47.1 MB, less than 76.20% of Java online submissions for Design Browser History.
 */
class BrowserHistory {

    private List<String> history = new ArrayList<>();
    private int current;

    public BrowserHistory(String homepage) {
        history.add(homepage);
        current = 0;
    }

    public void visit(String url) {
        if (current != history.size() - 1) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i <= current; i++) {
                temp.add(history.get(i));
            }

            history = temp;
        }
        history.add(url);
        current = history.size() - 1;
    }

    public String back(int steps) {
        current -= steps;

        if (current < 0) {
            current = 0;
        }

        return history.get(current);
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (current != history.size() - 1)
                current++;
        }

        return history.get(current);
    }
}

class Main {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(10);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(10);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}