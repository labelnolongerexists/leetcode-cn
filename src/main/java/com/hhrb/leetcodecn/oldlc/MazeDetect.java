package com.hhrb.leetcodecn.oldlc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * User: Z J Wu Date: 2019-02-15 Time: 16:35 Package: com.hhrb.leetcodecn
 */
public class MazeDetect {

  public static final int NON_ACCESS = -1;
  public static final int ACCESSABLE = 0;
  public static final int VISITED = 1;
  public static final int TARGET = 9;

  public static final class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Coordinate))
        return false;
      Coordinate that = (Coordinate) o;
      return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return new StringBuilder().append('(').append(x).append(',').append(y).append(')').toString();
    }
  }

  public static final class Maze {

    private int row;
    private int column;
    private int[][] store;

    public Maze(int row, int column) {
      this.row = row;
      this.column = column;
      this.store = new int[row][column];
    }

    public Maze addBlock(int x, int y) {
      if (x >= column || y >= row) {
        return this;
      }
      this.store[y][x] = NON_ACCESS;
      return this;
    }

    public Maze addTarget(int x, int y) {
      if (x >= column || y >= row) {
        return this;
      }
      this.store[y][x] = TARGET;
      return this;
    }

    public void print() {
      for (int i = 0; i < store.length; i++) {
        for (int j = 0; j < store[i].length; j++) {
          System.out.print(store[i][j]);
          System.out.print(",");
        }
        System.out.println();
      }
    }

    public boolean findDfs(Collection<Coordinate> visited, final int row, final int column) {
      if (row >= this.row || column >= this.column || row < 0 || column < 0) {
        return false;
      }
      Coordinate c = new Coordinate(row, column);
      if (visited.contains(c)) {
        return false;
      }
      System.out.println(c);
      visited.add(c);
      if (store[row][column] == NON_ACCESS) {
        return false;
      } else if (store[row][column] == TARGET) {
        System.out.println("found - " + row + "," + column);
        return true;
      }
      // right
      boolean found = findDfs(visited, row, column + 1);

      // down
      if (!found) {
        found = findDfs(visited, row + 1, column);
      }

      // left
      if (!found) {
        found = findDfs(visited, row, column - 1);
      }

      // up
      if (!found) {
        found = findDfs(visited, row - 1, column);
      }
      return found;
    }

  }

  public static void main(String[] args) {
    Maze maze = new Maze(4, 5).addBlock(4, 1).addBlock(1, 2).addTarget(4, 2);
    maze.print();
    Collection<Coordinate> path = new ArrayList<>();
    maze.findDfs(path, 0, 0);
    System.out.println("---------------------------------");
    System.out.println(path);
  }

}
