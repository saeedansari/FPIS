package chapter2

import scala.annotation.tailrec


object Chapter2 extends App {

  private def formatResult(name: String, n: Int, f: Int => Int) = {
    var msg = "result of %s for %d is %d"
  }

  def fib(n: Int) = {
    @tailrec
    def iterate(count: Int, previous: Int, beforePrevious: Int) : Int = {
      if (n == 1) beforePrevious
      else if (n == 2) previous
      else if (count == n) previous
      else iterate(count + 1, previous + beforePrevious, previous)
    }

    iterate(2, 1, 0)
  }

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def loop(n : Int): Boolean = {
      if (n >= as.length - 1) true
      else if (!ordered(as(n), as(n + 1))) false
      else loop(n + 1)
    }

    loop(0)

  }

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  }


}
