# 576. Out of Boundary Paths - WORK

# There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

# Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

# Example 1:


# Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
# Output: 6
# Example 2:


# Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
# Output: 12
 

# Constraints:

# 1 <= m, n <= 50
# 0 <= maxMove <= 50
# 0 <= startRow < m
# 0 <= startColumn < n

class Solution:
    def __init__(self):
        self.dp = None
        self.mod = 10**9 + 7
        self.m = 0
        self.n = 0

    def findPaths(self, m, n, maxMove, x, y):
        self.dp = [[[None for _ in range(maxMove + 1)] for _ in range(n)] for _ in range(m)]
        self.m = m
        self.n = n
        return self.helper(maxMove, x, y)

    def helper(self, maxMove, x, y):
        if x < 0 or x >= self.m or y < 0 or y >= self.n:
            return 1
        if maxMove <= 0:
            return 0
        if self.dp[x][y][maxMove] is not None:
            return self.dp[x][y][maxMove]
        
        res = 0
        res = (res + self.helper(maxMove - 1, x + 1, y)) % self.mod
        res = (res + self.helper(maxMove - 1, x, y - 1)) % self.mod
        res = (res + self.helper(maxMove - 1, x - 1, y)) % self.mod
        res = (res + self.helper(maxMove - 1, x, y + 1)) % self.mod
        self.dp[x][y][maxMove] = res
        return res
