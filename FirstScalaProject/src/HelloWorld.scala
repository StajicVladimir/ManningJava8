
object HelloWorld{
  def main(args: Array[String]): Unit = {
    val myString :String = "Vlada";
    val (num :Int, name :String) = Pair(40,"Name");

    println("Hello World!!! " + myString);
    println("Tuple: " + num + name);
  }
}