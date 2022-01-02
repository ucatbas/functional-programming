package recfun
object RecFun extends RecFunInterface:
  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = (c,r) match {
    case (0, _) => 1
    case (c, r)  if (c==r) => 1
    case (c,r) => pascal(c,r-1)+pascal(c-1,r-1)
  }
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance(acc: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) acc == 0
      else if (acc < 0) false
      else if (chars.head == '(') balance(acc + 1, chars.tail)
      else if (chars.head == ')') balance(acc - 1, chars.tail)
      else balance(acc, chars.tail)
    }
    balance(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (0, _) => 1
    case (m, _) if m < 0 => 0
    case (_, cs)  if cs.isEmpty => 0
    case (m, cs) => countChange(m - cs.head, cs) + countChange(m, cs.tail)
  }