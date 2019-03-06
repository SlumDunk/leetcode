package com.github.leetcode.medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 22:19
 * @Description: Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
 * <p>
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * <p>
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
 * <p>
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
 * <p>
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 * <p>
 * Example:
 * <p>
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * <p>
 * Snake snake = new Snake(width, height, food);
 * <p>
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * <p>
 * |S| | |
 * | | |F|
 * <p>
 * snake.move("R"); -> Returns 0
 * <p>
 * | |S| |
 * | | |F|
 * <p>
 * snake.move("D"); -> Returns 0
 * <p>
 * | | | |
 * | |S|F|
 * <p>
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 * <p>
 * | |F| |
 * | |S|S|
 * <p>
 * snake.move("U"); -> Returns 1
 * <p>
 * | |F|S|
 * | | |S|
 * <p>
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * <p>
 * | |S|S|
 * | | |S|
 * <p>
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class Leetcode353 {
    class SnakeGame {
        /**
         * 贪食蛇覆盖的位置
         */
        HashSet<Integer> set;
        /**
         * 双向队列，存储贪食蛇移动轨迹
         */
        Deque<Integer> deque;
        /**
         * 获取的分数
         */
        int score;
        /**
         * 食物位置索引
         */
        int foodIndex;
        /**
         * 宽度
         */
        int width;
        /**
         * 高度
         */
        int height;
        /**
         * 食物位置
         */
        int[][] food;

        /**
         * Initialize your data structure here.
         *
         * @param width  - screen width
         * @param height - screen height
         * @param food   - A list of food positions
         *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            set = new HashSet<>();
            deque = new LinkedList<>();
            score = 0;
            foodIndex = 0;
            set.add(0);
            deque.offerLast(0);
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            if (score == -1) {
                return -1;
            }

            int rowHead = deque.peekFirst() / width;
            int colHead = deque.peekFirst() % width;
            switch (direction) {
                case "U":
                    rowHead--;
                    break;
                case "D":
                    rowHead++;
                    break;
                case "L":
                    colHead--;
                    break;
                default:
                    colHead++;
            }

            int head = rowHead * width + colHead;
            set.remove(deque.peekLast());
            if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
                return score = -1;
            }
            set.add(head);
            deque.offerFirst(head);
            if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
                foodIndex++;
                ++score;
                set.add(deque.peekLast());
                return score;
            }
            deque.pollLast();
            return score;
        }
    }
}
