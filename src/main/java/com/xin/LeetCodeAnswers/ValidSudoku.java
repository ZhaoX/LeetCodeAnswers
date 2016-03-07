package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/valid-sudoku/
// Author : Xin Zhao
// Date   : 2016-03-07

import java.util.HashSet;
import java.util.Set;

/**********************************************************************************
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * A partially filled sudoku which is valid.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 **********************************************************************************/

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {
            if(!isValidSudoku(board, 0, i, 8, i)) {
                return false;
            }
            if(!isValidSudoku(board, i, 0, i, 8)) {
                return false;
            }
            if(!isValidSudoku(board, (i/3)*3, (i%3)*3, (i/3)*3+2, (i%3)*3+2)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidSudoku(char[][] board, int x1, int y1, int x2, int y2) {

        Set<Character> set = new HashSet<Character>();

        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(board[i][j] != '.') {
                    if(!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
