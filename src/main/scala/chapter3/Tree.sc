sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A](tree: Tree[A]) : Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }

  def maximum(tree: Tree[Int]) : Int = tree match {
    case Leaf(n) => n
    case Branch(l,r) => maximum(l) max maximum(r)
  }

  def depth[A](tree: Tree[A], leaf: A) : Int = tree match {
    case Leaf(leaf) => 0
    case Branch(l, r) => 1 + depth(l, leaf) + depth(r, leaf)
  }

  def map[A, B](tree: Tree[A])(f: A => B) : Tree[B] =  tree match {
    case Leaf(a) => Leaf(f(a))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

}

