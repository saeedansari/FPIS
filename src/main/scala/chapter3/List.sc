sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]) : Int = ints match {
    case Cons(x, xs) => x + sum(xs)
    case Nil => 0
  }

  def product(ints: List[Int]) : Int = ints match {
    case Cons(x, xs) => x * product(xs)
    case Nil => 1
    case (0.0, _) => 0
  }

}